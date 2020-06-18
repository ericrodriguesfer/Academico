#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include "dfx.h"
#include <unistd.h>
#include <string.h>
#include "telas.h"

void cria_parede(int largura, int* potuacao){
	set_cor('g');

	dlinha(110, 10, 940, 10);
	dlinha(110, 10, 110, 690);
	dlinha(940, 10, 940, 690);
	dlinha(110, 690 , 940, 690);

	/*movePxy(430, 692);
	dtexto("postuacao: ");

	movePxy(530, 692);
	dtexto("10");*/
}

void cria_cobra(){
	//ampliar(1,1);
	
	char cabeca[] = "\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n\
						######################\n";

		dpixel(cabeca);

}

int comeu_maca(int posicaoX_maca, int posicaoY_maca, int posicaoX_cobra, int posicaoY_cobra, int* pontucao){
	if((posicaoX_cobra <= posicaoX_maca+20 && posicaoY_cobra <= posicaoY_maca+20) && (posicaoX_cobra+20 >= posicaoX_maca && posicaoY_cobra+20 >= posicaoY_maca)){
		*pontucao += 5;
		return 1;
	}
	
	return 0;
} 

void gerar_maca(int posicaoX_maca, int posicaoY_maca){
	ampliar(1,1);
	set_cor('r');
	char maca[] = "\
                  ##\n\
                 ##\n\
                ##\n\
                ##\n\
        ##################\n\
      ######################\n\
     ########################\n\
    ##########################\n\
    ##########################\n\
    ##########################\n\
    ##########################\n\
    ##########################\n\
    ##########################\n\
    ##########################\n\
     ########################\n\
      ######################\n\
       ####################\n\
        ##################\n\
         ################\n\
          ##############\n\
            ##########\n";
	movexy((posicaoX_maca)/10, (posicaoY_maca)/10);
	
	dpixel(maca);
}

void gera_posicao_maca(int* posicaoX_maca, int* posicaoY_maca){
	
	srand(time(NULL));

	*posicaoX_maca = 110 + rand() % 800;
	*posicaoY_maca = 10 + rand() % 655;

	gerar_maca(*posicaoX_maca, *posicaoY_maca);

}

int movimento(int seta_atual, int* x, int* y){
	
	if(seta_atual == 1){
		 movePxy(*x -= 20, *y);	
		 return 1;
	}else if(seta_atual == 2){
		 movePxy(*x, *y -= 20);
		 return 1;	
	}else if(seta_atual == 3){
		movePxy(*x, *y += 20);
		return 1;	
	}else if(seta_atual == 4){ 
		movePxy(*x += 20, *y);
		return 1;
	}


	return 0;
}

int direcao_seta(char tecla, int anterior){
	int res;
	//tecla para esquerda
	if(tecla == 81) res = 1;	
	//tecla para cima
	else if(tecla == 82) res = 2;
	//tecla para baixo
	else if(tecla == 84) res = 3;
	//tecla para direita
	else if(tecla == 83) res = 4;

	//para empedir de voltar por dentro de si mesma
	if(res == 1 && anterior == 4) res = 4;
	else if(res == 3 && anterior == 2) res = 2;
	else if(res == 4 && anterior == 1) res = 1;
	else if(res == 2 && anterior == 3) res = 3;

	return res;	
}

int main(){
	
	int altura = 1024;
	int largura = 1024;
	int pontuacao = 0;
	char* titulo = "Jogo Da Cobrinha";
	char tecla;
	
	//cria a janela
	criar_janela(largura, altura, titulo);
	
	char maca[] = "\
                  ##\n\
                 ##\n\
                ##\n\
                ##\n\
        ##################\n\
      ######################\n\
     ########################\n\
    ##########################\n\
    ##########################\n\
    ##########################\n\
    ##########################\n\
    ##########################\n\
    ##########################\n\
    ##########################\n\
     ########################\n\
      ######################\n\
       ####################\n\
        ##################\n\
         ################\n\
          ##############\n\
            ##########\n";

	set_cor('R');
	
	int posicaoX_maca;
	int posicaoY_maca;

	//lugar na tela, e ja descidindo onde a  cobra  vai comecar
	int posicaoX[960]; 
	int posicaoY[700];

	//inicializa as posicoes da cobra
	int x = 532;
	int y = 333;

	posicaoX[0] = x;
	posicaoY[0] = y;
		
	/*
		desenha a tela inicial do jogo e so comeca quando o usuario aperta enter
	 */
	desenha_tela_inical();
	char tecla_da_tela_inicial = get_tecla();

	if(tecla_da_tela_inicial != 13 || tecla_da_tela_inicial == 13){
		//limmpar a tela para poder poder ir para outra tela
		//limpar_tela();

		instrucoes();
		//tempo para ler as instrucoes
		usleep(2000000);

		limpar_tela();
		
		//criar a parede
		cria_parede(largura, &pontuacao);	

		gera_posicao_maca(&posicaoX_maca, &posicaoY_maca);
		
		int tam_cobra = 3;
		int delay = 100000;
		int seta; 
		int ultima_seta;
		int controle_break = 0;		

		//para manter a janela aberta
		while(1){

			//para mander a cobrinha andando automaticamente
			while(1){

				if(tecla == 13)break;

				/* 
					se a tecla for pressionada ele sai do ciclo que faz a cobrinha andar automaticamente
					para pegar a proxima direcao
				*/	
				if(tecla_pressionada() == 1) break;	

				/*
				para dar o eveito que a cobrinha esta andando.
				faz cada posicao do vetores que pegam as cordenadas receberem 
				*/
				for(int controle = tam_cobra; controle > 0; controle--){   
					posicaoX[controle] = posicaoX[controle-1];
					
					posicaoY[controle] = posicaoY[controle-1];	
				}
				
				
				//pega para onde vai desenhar

				/*
				isso move as cordenadas na ultima posicao 
				depois criar um caractere igual o que representa o corpo da cobra
				e pintar ele da cor da tela, para apagar a cor
				
				*/
				movePxy(posicaoX[tam_cobra],posicaoY[tam_cobra]);
				set_cor('K');
				cria_cobra();
				
				
				/*
					gerar a maca automaticamte a maca fica la ate ser comida se ela for 
					comida gerar uma nova posicao e se desenha em outro lugar da tela
					e a varial que é o tamanho da cobra  aumenta
					e toda vez que a cobra aumenta de tamanho a variavel
					delay mudar de tamanho, diminuindo um pouco mais do que dobro que a cobra aumentou
					para fazer um ponderamento na velocidade
					para que a cobra fique grande e a cobra nao fique lenta
					fique no mesmo ritmo
				*/

				if(comeu_maca(posicaoX_maca, posicaoY_maca, posicaoX[0], posicaoY[0], &pontuacao) == 1){
					/*
						se a cobra comer a maca, tem que apagar o ultimo 
						desenho, entao desenho o mesmo desenho da cor da tela
					*/
				
					movexy(posicaoX_maca/10, posicaoY_maca/10);
					set_cor('K');
					dpixel(maca);
					
					gera_posicao_maca(&posicaoX_maca, &posicaoY_maca);
					tam_cobra += 1;
					delay; 

				}else gerar_maca(posicaoX_maca, posicaoY_maca);
				
				/*
					move para uma posicao e desenha na tela
					repinta o desenho
					usar um sleep ate voltar para o inicio do ciclo, para contralar 
					a veocidade da cobra
				*/
				
				int res = movimento(seta, &posicaoX[0], &posicaoY[0]);
				//para saber se o valor de direcao foi valido
				if(res == 1){
					set_cor('r');
					cria_cobra();
					usleep(delay);
					
					
					//para ela morrer batendo em si prorpia
					int i;
					for(i = 1; i <= tam_cobra; i++){
						if(posicaoX[0] == posicaoX[i] && posicaoY[0] == posicaoY[i]){
							limpar_tela();
							tela_game_over();
							controle_break = 1;
							usleep(2000000);
							break;
						}
					}
				}
				
				//caso bata na parede fechar o jogo
				if(posicaoY[0] >= 690 || posicaoY[0] <= 0 || posicaoX[0] >= 931 || posicaoX[0] <= 100){
					limpar_tela();
					tela_game_over();
					usleep(2000000);
					controle_break = 1;
				}
				
				if(controle_break == 1) break;	
			}
			
			//fechar a janela
			if(controle_break == 1 || tecla == 13) break;

			//pega a tecla digitada pelo usuario
			tecla = get_tecla();
	
			/* 
				se a tecla for para esquerda a variavel direcao vai receber o q equivale a esquerda
			*/
			seta = direcao_seta(tecla, ultima_seta);
			ultima_seta = seta;
		}

	}

	return 0;
}
