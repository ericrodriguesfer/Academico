/*
* dfx.h versão 1.1
*
* Original de
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

#ifndef DFX_H
#define DFX_H

/* Nomeclatura de cores
 * http://www.flamengo.com.br/flapedia/Lista_de_cores
 *
 * Cores cadastradas no sistema
 *  R,G,B,W,K,M,C,Y e respectivos minusculos.
 *  Veja o codigo de exemplo exemplos_basicos/e1_cores
 *
 * Caso seja pedida uma cor nao cadastra, será retornada a cor branca
 * e sera impresso um erro via printf
*/

//Execute o exemplo_basico/e2_get_tecla para outras opcoes
#define TECLA_ENTER    13
#define TECLA_BACKSPACE 8 
#define TECLA_TAB       9

#define TECLA_WINDOWS -21
#define TECLA_SHIFT_L -31
#define TECLA_SHIFT_R -30
#define TECLA_ALT_L   -23
#define TECLA_CONTROL -29

#define TECLA_ESPACO   32
#define TECLA_LEFT  81 //igual tecla Q
#define TECLA_UP    82 //igual tecla R
#define TECLA_RIGHT 83 //igual tecla S
#define TECLA_DOWN  84 //igual tecla T 

#define VERMELHO_C 'r'
#define VERMELHO_E 'R'
#define VERDE_C 'g'
#define VERDE_E 'G'
#define AZUL_C 'b'
#define AZUL_E 'B'
#define AMARELO_C 'y'
#define AMARELO_E 'Y'
#define ROXO_C 'm'
#define ROXO_E 'M'
#define CIANO_C 'c'
#define CIANO_E 'C'
#define BRANCO_C 'W'
#define BRANCO_E 'w'
#define PRETO_C 'k'
#define PRETO_E 'K'


	//Criar Janela e Inicializa ambiente
		void criar_janela(int largura, int altura, const char *titulo );

	//Mudar cor de texto, fundo e configurar tamanho
		void set_cor( char cor );
		void set_fundo( char cor );
		void ampliar(int x, int y);
		void set_negrito(int x, int y);

	//Limpar tela e executar plotagens na tela
		void limpar_tela();
		void repintar();
	//Entrada: verificar tecla pressionada, pegar tecla e pegar texto
		int  tecla_pressionada();
		int  mouse_clicado();
		
		char get_tecla();
		void get_mouse(int *x, int *y);
		
		int get_texto();
	//Plotagem: plotar linha, plotar pixels, plotar texto
		void dlinha( int x1, int y1, int x2, int y2 );
		void dpixel( char desenho[]);
		void dtexto( const char* format, ...);
	//Mover para bloco x,y ou move para pixel x,y
		void movexy ( int x, int y);
		void movePxy( int x, int y);
	//Pegar informações do ambiente
		int  get_x();
		int  get_y();
		char get_cor  ();
		char get_fundo();

#endif
