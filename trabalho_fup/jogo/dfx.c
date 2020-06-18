/*
* Versão original 
* http://www.nd.edu/~dthain/courses/cse20211/fall2011/gfx
* 
* Nova versão por David Sena sena.ufc@gmail.com
* 
* No ubuntu, para compilar você precisa do pacote libx11-dev
* sudo apt-get install libx11-dev
* 
* Para compilar use as opções
* gcc -lX11 -lm
* 
*/

#include <X11/Xlib.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdarg.h>

#include "dfx.h"

#define SIZECHAR 60
#define ASCMIN 33
#define ASCMAX 127
#define ASCSPACE 32

#define TEXTO 0
#define FUNDO 1

/* Variaveis Globais*/	

	//variaveis globais de manipulação de objetos X11
		static Display *gfx_display;
		static Window  gfx_window;
		static GC      gfx_gc;
		static Colormap gfx_colormap;

	//variaveis globais de cores e caracteres
		static int xa_ = 0;/*posicao atual do "cursor"*/
		static int ya_ = 0;
		
		static int xf_ = 1;//fator de tamanho de impressao
		static int yf_ = 1;

		static int xd_ = 1;//fator de densidade das letras
		static int yd_ = 1;

		static int saved_xpos = 0;
		static int saved_ypos = 0;
		
		static char fundo_; //cor de fundo atual
		static char cor_; //cor de risco atual, pixels e letras
		static char last_cor_;//ultima cor antes da atual
		
		char *asc_map_[100]; //mapa de caracteres: vetor de 100 ponteiros
		
/*Prototipos de Funcoes internas nao exportadas*/
		void init_asc_map();
		int  search_color(char letra,int *r,int *g, int*b);
		void dplot( int X, int Y, char s[]);
		char get_evento();
		int  evento_aconteceu();
		void dponto(int x, int y);
		void return_last_cor();//retorna para cor anterior


int get_x(){
	return xa_;
}
int get_y(){
	return ya_;
}
char get_cor(){
	return cor_;
}
char get_fundo(){
	return fundo_;
}

void criar_janela( int largura, int altura , const char *title ){
	
	int width = largura;
	int height= altura;
	init_asc_map();

	
	gfx_display = XOpenDisplay(0);
	if(!gfx_display) {
		fprintf(stderr,"gfx_open: unable to open the graphics window.\n");
		exit(1);
	}

	fundo_ = 'K';
	cor_='W';
	last_cor_='W';
	
	int blackColor = BlackPixel(gfx_display, DefaultScreen(gfx_display));
	int whiteColor = WhitePixel(gfx_display, DefaultScreen(gfx_display));

	gfx_window = XCreateSimpleWindow(gfx_display, DefaultRootWindow(gfx_display), 0, 0, width, height, 0, blackColor, blackColor);
	XSetWindowAttributes attr;
	attr.backing_store = Always;
	XChangeWindowAttributes(gfx_display,gfx_window,CWBackingStore,&attr);
	XStoreName(gfx_display,gfx_window,title);
	XSelectInput(gfx_display, gfx_window, StructureNotifyMask|KeyPressMask|ButtonPressMask);
	XMapWindow(gfx_display,gfx_window);
	gfx_gc = XCreateGC(gfx_display, gfx_window, 0, 0);
	gfx_colormap = DefaultColormap(gfx_display,0);
	XSetForeground(gfx_display, gfx_gc, whiteColor);
	// Wait for the MapNotify event
	for(;;) {
		XEvent e;
		XNextEvent(gfx_display, &e);
		if (e.type == MapNotify)
			break;
	}
}

//TIPO COR  TEXTO ou FUNDO, 
void mudar_cor( int tipo , int r, int g, int b){
	XColor color;
	color.pixel = 0;
	color.red = r<<8;
	color.green = g<<8;
	color.blue = b<<8;
	
	XAllocColor(gfx_display,gfx_colormap,&color);
	
	if (tipo == TEXTO)//texto
		XSetForeground(gfx_display, gfx_gc, color.pixel);
	else if (tipo == FUNDO){ //fundo
		XSetWindowAttributes attr;
		attr.background_pixel = color.pixel;
		XChangeWindowAttributes(gfx_display,gfx_window,CWBackPixel,&attr);
	}
}

void return_last_cor(){
	cor_ = last_cor_;
	set_cor(cor_);
}

/* Muda a cor de blocos e linhas */
void set_cor( char nova_cor ){
	int r,g,b;
	if(search_color(nova_cor, &r,&g,&b)==1){
		last_cor_=cor_;
		cor_=nova_cor;
		mudar_cor( TEXTO , r,g,b);
	}
}

/* Mudar Cor Background */
void set_fundo( char nova_cor ){
	int r,g,b;
	if(search_color(nova_cor, &r,&g,&b)==1){
		fundo_ = nova_cor;
		mudar_cor( FUNDO , r, g, b);
	}
}

//Procura o rgb da cor, se não encontrar, retorna 0
int search_color(char letra,int *r,int *g, int*b){
	switch(letra){
		case 'R':	*r=139;*g=0  ;*b=0  ;break;
		case 'r':	*r=255;*g=0  ;*b=0  ;break;
		case 'G':	*r=0  ;*g=100;*b=0  ;break;
		case 'g':	*r=0  ;*g=255;*b=0  ;break;
		case 'B':	*r=0  ;*g=0  ;*b=128;break;
		case 'b':	*r=0  ;*g=0  ;*b=255;break;
		case 'Y':	*r=255;*g=215;*b=0  ;break;
		case 'y':	*r=255;*g=255;*b=0  ;break;
		case 'C':	*r=0  ;*g=139;*b=139;break;
		case 'c':	*r=0  ;*g=255;*b=255;break;
		case 'M':	*r=148;*g=0  ;*b=211;break;
		case 'm':	*r=255;*g=192;*b=203;break;
		case 'W':	*r=255;*g=255;*b=255;break;
		case 'w':	*r=220;*g=245;*b=220;break;
		case 'K':	*r=0  ;*g=0  ;*b=0	;break;
		case 'k':	*r=61 ;*g=43 ;*b=31	;break;
		default:
			return 0;
	}
	return 1;

}

/* Clear the graphics window to the background color. */
void limpar_tela(){
	XClearWindow(gfx_display,gfx_window);
}
/* Flush all previous output to the window. */
void repintar(){
	XFlush(gfx_display);
}

//retorna 1 para evento de teclado e 2 para evento de mouse
//0 se não tem nenhum evento no buffer
int evento_aconteceu(){
       XEvent event;

       repintar();

       while (1) {
               if(XCheckMaskEvent(gfx_display,-1,&event)) {
                       if(event.type==KeyPress) {
                               XPutBackEvent(gfx_display,&event);
                               return 1;
                       } else if (event.type==ButtonPress) {
                               XPutBackEvent(gfx_display,&event);
                               return 2;
                       } else {
                               return 0;
                       }
               } else {
                       return 0;
               }
       }
}

//retorna 1 para evento de teclado e 2 para evento de mouse
//0 se não tem nenhum evento no buffer
int tecla_pressionada(){
	if(evento_aconteceu()==1)
		return 1;
	else
		return 0;
}
int mouse_clicado(){
	if(evento_aconteceu()==2)
		return 1;
	else
		return 0;
}


/* Wait for the user to press a key or mouse button. */
char get_evento(){
	XEvent event;

	repintar();
	while(1) {
		XNextEvent(gfx_display,&event);

		if(event.type==KeyPress) {
			saved_xpos = event.xkey.x;
			saved_ypos = event.xkey.y;
			return XLookupKeysym(&event.xkey,0);
		} else if(event.type==ButtonPress) {
			saved_xpos = event.xkey.x;
			saved_ypos = event.xkey.y;
			return event.xbutton.button;
		}
	}
}

char get_tecla(){
	return get_evento();
}

void get_mouse(int *x, int *y){
	get_evento();
	*x = saved_xpos;
	*y = saved_ypos;
}


/* Desenha uma linha de (x1,y1) para (x2,y2) */
void dlinha( int x1, int y1, int x2, int y2 ){
	XDrawLine(gfx_display,gfx_window,gfx_gc,x1,y1,x2,y2);
}

void dpixel( char desenho[] ){
	dplot(xa_, ya_, desenho);
	xa_ += xf_*10; //move posicao de plotagem //TODO
}

void dponto(int x, int y){
	dlinha(x,y,x,y);
}

//TODO dplot inteligente, para plotar linhas
void dplot( int X, int Y, char s[]){
	int dx=0;//deslocamento em x, em numero de pixels
	int dy=0;//deslocamento em y, em numero de pixels	
	int i=0;
	while(s[i] != '\0'){
		if (s[i]=='\n'){//nova linha
			dy += yf_;//move plotador para baixo
			dx  = 0; //zera deslocamento em x
		}else{
			//se nao for espaco ele plota o pixel
			if(!((int)s[i] == ASCSPACE)){
				if(s[i] != '#')//se nao for cerquila ele carrega cor
					set_cor(s[i]);
				
				int i;
				for (i=0;i<xd_;i++)
					dlinha(X+dx+i,Y+dy,X+dx+i,Y+dy+yd_-1);
			}
			dx += xf_;//move plotador para direita
		}
		i++;//proximo caractere
	}
}


//funcao de visibilidade externa para escrever caracteres
//possui a mesma sintaxe de printf
void dtexto( const char* format, ... ) {
	char s[1000];
	va_list args;
	va_start( args, format );
	vsprintf(s, format, args);
	va_end( args );

	int dx=0;//deslocamento em x, em numero de pixels
	int dy=0;//deslocamento em y, em numero de pixels
	int ax=0;//alinhando a letra em x no bloco para impressao
	int ay=0;//alinhando a letra em y no bloco para impressao

	int i=0;
	while(s[i] != '\0'){
		if (s[i]=='\n'){//nova linha
			dy += 10*yf_;//incrementa linha
			dx  = 0; //retorna pra x
		}else{
			//instrucoes de impressao
			//o mapa de caracteres permitidos vai do ascii 33 ao 127
			if((int)s[i]>=ASCMIN && (int)s[i]<=ASCMAX){
				int p = (int)s[i] - ASCSPACE;//posicao no vetor
				
				ax = 2*xf_;
				ay = yf_  ;//chama funcao para plotar o caractere
				dplot( xa_ + dx + ax, ya_ + dy + ay, asc_map_[p]);
			}
			dx += 10 * xf_;
		}
		i++;
	}
	xa_ = xa_ + dx;//incrementa para os valores finais
	ya_ = ya_ + dy;
}

//funcao utilizada pela funcao de ler texto
void sublinhar_atual( char cor ){
	
	set_cor( cor );
	dlinha(xa_ , ya_ + yf_ * 10 , xa_ + xf_ * 10, ya_ + yf_*10);
	return_last_cor();
}
int get_texto(char s[]){
	int c;
	static int tam = 0;//tamanho atual da string, variavel persistente
	static int novo = 1;//bool pra dizer se nova chamada da funcao
	static int fim = 0;//bool pra dizer se apertou enter, persistente
	static char cor_backup; //para apagar o char se backspace
	static int shift_pressionado = 0;
	static int xgt;//posicoes iniciais do plotador no inicio
	static int ygt;
	
	if(novo == 1){//nova chamada de get_texto();
		novo = 0;
		fim = 0; 
		cor_backup = cor_;
		xgt = xa_;
		ygt = ya_;
		tam = 0;
	} 
	else{//carregar contexto
		xa_ = xgt + xf_*10*tam;
		ya_ = ygt;
	}
	
	sublinhar_atual(cor_);
	c = get_evento();//enter =13, backspace = 8;
	if ( c==13 ){
		fim = 1;
	}
	else if(c==-30 || c ==-31){
		shift_pressionado = 1;
		printf("shift pressionado %d\n", shift_pressionado);
	}
	else if (c>=32 && c<=127){//char imprimivel
		
		sublinhar_atual(fundo_);//apaga sublinhado atual
		
		if((c>=(int)'a' && c<=(int)'z') && shift_pressionado){
			c = (char)(c-('a'-'A'));
			shift_pressionado = 0;
		}
		s[tam]=(char) c;
		dtexto("%c", (char)c);
				
		sublinhar_atual(cor_);
		repintar();
		
		s[tam+1]='\0';//cada retorno da funcao ja eh uma substring
		tam++;
	}
	else if(c == 8 && tam >  0){
			tam--;
			xa_ = xa_ - 10 * xf_;
			set_cor( fundo_ );
			dtexto("%c", s[tam]);
			sublinhar_atual( fundo_ );
			set_cor(cor_backup);
			s[tam]='\0';
			//a funcao de escrever o texto apagando incrementou xa_
			//por isso devemos decrementar novamente
			xa_ = xa_ - 10 * xf_;
	}

	if(fim){//enter foi digitado
		sublinhar_atual(fundo_);
		s[tam]='\0';
		novo = 1;
		return 1;
	}
	return 0;
}



void movexy( int x, int y){
	xa_ = x * xf_ * 10;
	ya_ = y * yf_ * 10;
}

void movePxy( int x, int y){
	xa_ = x;
	ya_ = y;
}

void ampliar(int xf, int yf){
	if (xf>=1 && xf <=5){
		xf_ = xf;
		xd_ = xf;
	}
	if (yf>=1 || yf <=5){
		yf_ = yf;
		yd_ = yf;
	}
}

void set_negrito(int x, int y){
	if(x<=xf_)
		xd_ = x;
	if(y<=yf_)
		yd_ = y;
}


void init_asc_map(){
int i=0;

asc_map_[i++]=("﻿\n\n\n\n\n\n\0");
asc_map_[i++]=("  ###  \n  ###  \n  ###  \n   #   \n       \n  ###  \n  ###  \0");
asc_map_[i++]=("       \n  #  # \n  #  # \n  #  # \n       \n       \n       \0");
asc_map_[i++]=("  # #  \n  # #  \n#######\n  # #  \n#######\n  # #  \n  # #  \0");
asc_map_[i++]=("   #   \n ##### \n#  #   \n ####  \n   # # \n#####  \n   #   \0");
asc_map_[i++]=("       \n ##  # \n ## #  \n   #   \n  # ## \n #  ## \n       \0");
asc_map_[i++]=("  ###  \n #   # \n #  #  \n  ##   \n  # #  \n #   # \n  ##  #\0");
asc_map_[i++]=("       \n  ##   \n  ##   \n  ##   \n       \n       \n       \0");
asc_map_[i++]=("    ## \n   #   \n  #    \n  #    \n  #    \n   #   \n    ## \0");
asc_map_[i++]=(" ##    \n   #   \n    #  \n    #  \n    #  \n   #   \n ##    \0");
asc_map_[i++]=("       \n   #   \n  ###  \n   #   \n       \n       \n       \0");
asc_map_[i++]=("       \n   #   \n   #   \n ##### \n   #   \n   #   \n       \0");
asc_map_[i++]=("       \n       \n       \n  ###  \n  ###  \n   #   \n  #    \0");
asc_map_[i++]=("       \n       \n       \n ##### \n       \n       \n       \0");
asc_map_[i++]=("       \n       \n       \n       \n  ###  \n  ###  \n  ###  \0");
asc_map_[i++]=("      #\n     # \n    #  \n   #   \n  #    \n #     \n#      \0");
asc_map_[i++]=("  ###  \n #   # \n#     #\n#     #\n#     #\n #   # \n  ###  \0");
asc_map_[i++]=("   #   \n  ##   \n # #   \n   #   \n   #   \n   #   \n ##### \0");
asc_map_[i++]=(" ##### \n#     #\n      #\n ##### \n#      \n#      \n#######\0");
asc_map_[i++]=(" ##### \n#     #\n      #\n ##### \n      #\n#     #\n ##### \0");
asc_map_[i++]=("#      \n#    # \n#    # \n#    # \n#######\n     # \n     # \0");
asc_map_[i++]=("#######\n#      \n#      \n###### \n      #\n#     #\n ##### \0");
asc_map_[i++]=(" ##### \n#     #\n#      \n###### \n#     #\n#     #\n ##### \0");
asc_map_[i++]=("#######\n#    # \n    #  \n   #   \n  #    \n  #    \n  #    \0");
asc_map_[i++]=(" ##### \n#     #\n#     #\n ##### \n#     #\n#     #\n ##### \0");
asc_map_[i++]=(" ##### \n#     #\n#     #\n ######\n      #\n#     #\n ##### \0");
asc_map_[i++]=("       \n   ##  \n   ##  \n       \n   ##  \n   ##  \n       \0");
asc_map_[i++]=("       \n   ##  \n   ##  \n       \n   ##  \n   #   \n  #    \0");
asc_map_[i++]=("     # \n   #   \n #     \n#      \n #     \n   #   \n     # \0");
asc_map_[i++]=("       \n       \n#######\n       \n#######\n       \n       \0");
asc_map_[i++]=(" #     \n   #   \n     # \n      #\n     # \n   #   \n #     \0");
asc_map_[i++]=(" ##### \n#     #\n      #\n   ### \n   #   \n       \n   #   \0");
asc_map_[i++]=(" ##### \n#     #\n# ### #\n# ### #\n# #### \n#      \n ##### \0");
asc_map_[i++]=("   #   \n  # #  \n #   # \n#     #\n#######\n#     #\n#     #\0");
asc_map_[i++]=("###### \n#     #\n#     #\n###### \n#     #\n#     #\n###### \0");
asc_map_[i++]=(" ##### \n#     #\n#      \n#      \n#      \n#     #\n ##### \0");
asc_map_[i++]=("###### \n#     #\n#     #\n#     #\n#     #\n#     #\n###### \0");
asc_map_[i++]=("#######\n#      \n#      \n#####  \n#      \n#      \n#######\0");
asc_map_[i++]=("#######\n#      \n#      \n#####  \n#      \n#      \n#      \0");
asc_map_[i++]=(" ##### \n#     #\n#      \n#  ####\n#     #\n#     #\n ##### \0");
asc_map_[i++]=("#     #\n#     #\n#     #\n#######\n#     #\n#     #\n#     #\0");
asc_map_[i++]=("  ###  \n   #   \n   #   \n   #   \n   #   \n   #   \n  ###  \0");
asc_map_[i++]=("      #\n      #\n      #\n      #\n#     #\n#     #\n ##### \0");
asc_map_[i++]=("#    # \n#   #  \n#  #   \n###    \n#  #   \n#   #  \n#    # \0");
asc_map_[i++]=("#      \n#      \n#      \n#      \n#      \n#      \n#######\0");
asc_map_[i++]=("#     #\n##   ##\n# # # #\n#  #  #\n#     #\n#     #\n#     #\0");
asc_map_[i++]=("#     #\n##    #\n# #   #\n#  #  #\n#   # #\n#    ##\n#     #\0");
asc_map_[i++]=("#######\n#     #\n#     #\n#     #\n#     #\n#     #\n#######\0");
asc_map_[i++]=("###### \n#     #\n#     #\n###### \n#      \n#      \n#      \0");
asc_map_[i++]=(" ##### \n#     #\n#     #\n#     #\n#   # #\n#    # \n #### #\0");
asc_map_[i++]=("###### \n#     #\n#     #\n###### \n#   #  \n#    # \n#     #\0");
asc_map_[i++]=(" ##### \n#     #\n#      \n ##### \n      #\n#     #\n ##### \0");
asc_map_[i++]=("#######\n   #   \n   #   \n   #   \n   #   \n   #   \n   #   \0");
asc_map_[i++]=("#     #\n#     #\n#     #\n#     #\n#     #\n#     #\n ##### \0");
asc_map_[i++]=("#     #\n#     #\n#     #\n#     #\n #   # \n  # #  \n   #   \0");
asc_map_[i++]=("#     #\n#  #  #\n#  #  #\n#  #  #\n#  #  #\n#  #  #\n ## ## \0");
asc_map_[i++]=("#     #\n #   # \n  # #  \n   #   \n  # #  \n #   # \n#     #\0");
asc_map_[i++]=("#     #\n #   # \n  # #  \n   #   \n   #   \n   #   \n   #   \0");
asc_map_[i++]=("#######\n     # \n    #  \n   #   \n  #    \n #     \n#######\0");
asc_map_[i++]=("  ###  \n  #    \n  #    \n  #    \n  #    \n  #    \n  ###  \0");
asc_map_[i++]=("#      \n #     \n  #    \n   #   \n    #  \n     # \n      #\0");
asc_map_[i++]=("  ###  \n    #  \n    #  \n    #  \n    #  \n    #  \n  ###  \0");
asc_map_[i++]=("   #   \n  # #  \n #   # \n       \n       \n       \n       \0");
asc_map_[i++]=("       \n       \n       \n       \n       \n       \n#######\0");
asc_map_[i++]=(" ##    \n   #   \n    #  \n       \n       \n       \n       \0");
asc_map_[i++]=("       \n  ##   \n #  #  \n#    # \n###### \n#    # \n#    # \0");
asc_map_[i++]=("       \n#####  \n#    # \n#####  \n#    # \n#    # \n#####  \0");
asc_map_[i++]=("       \n ####  \n#    # \n#      \n#      \n#    # \n ####  \0");
asc_map_[i++]=("       \n#####  \n#    # \n#    # \n#    # \n#    # \n#####  \0");
asc_map_[i++]=("       \n###### \n#      \n#####  \n#      \n#      \n###### \0");
asc_map_[i++]=("       \n###### \n#      \n#####  \n#      \n#      \n#      \0");
asc_map_[i++]=("       \n ####  \n#    # \n#      \n#  ### \n#    # \n ####  \0");
asc_map_[i++]=("       \n#    # \n#    # \n###### \n#    # \n#    # \n#    # \0");
asc_map_[i++]=("       \n   #   \n       \n   #   \n   #   \n   #   \n   #   \0");
asc_map_[i++]=("       \n     # \n     # \n     # \n     # \n#    # \n ####  \0");
asc_map_[i++]=("       \n#    # \n#   #  \n####   \n#  #   \n#   #  \n#    # \0");
asc_map_[i++]=("       \n#      \n#      \n#      \n#      \n#      \n###### \0");
asc_map_[i++]=("       \n#    # \n##  ## \n# ## # \n#    # \n#    # \n#    # \0");
asc_map_[i++]=("       \n#    # \n##   # \n# #  # \n#  # # \n#   ## \n#    # \0");
asc_map_[i++]=("       \n ####  \n#    # \n#    # \n#    # \n#    # \n ####  \0");
asc_map_[i++]=("       \n#####  \n#    # \n#    # \n#####  \n#      \n#      \0");
asc_map_[i++]=("       \n ####  \n#    # \n#    # \n#  # # \n#   #  \n ### # \0");
asc_map_[i++]=("       \n#####  \n#    # \n#    # \n#####  \n#   #  \n#    # \0");
asc_map_[i++]=("       \n ####  \n#      \n ####  \n     # \n#    # \n ####  \0");
asc_map_[i++]=("       \n#####  \n  #    \n  #    \n  #    \n  #    \n  #    \0");
asc_map_[i++]=("       \n#    # \n#    # \n#    # \n#    # \n#    # \n ####  \0");
asc_map_[i++]=("       \n#    # \n#    # \n#    # \n#    # \n #  #  \n  ##   \0");
asc_map_[i++]=("       \n#    # \n#    # \n#    # \n# ## # \n##  ## \n#    # \0");
asc_map_[i++]=("       \n#    # \n #  #  \n  ##   \n  ##   \n #  #  \n#    # \0");
asc_map_[i++]=("       \n #   # \n  # #  \n   #   \n   #   \n   #   \n   #   \0");
asc_map_[i++]=("       \n###### \n    #  \n   #   \n  #    \n #     \n###### \0");
asc_map_[i++]=("   ### \n   #   \n   #   \n  #    \n   #   \n   #   \n   ### \0");
asc_map_[i++]=("   #   \n   #   \n   #   \n   #   \n   #   \n   #   \n   #   \0");
asc_map_[i++]=(" ###   \n   #   \n   #   \n    #  \n   #   \n   #   \n ###   \0");
asc_map_[i++]=("       \n       \n ###  #\n #  ###\n       \n       \n       \0");
}


