#include <stdio.h>

//função que soma os elementos do vetor filho
int somar_elementos(int vetor[], int tam){
    int soma = 0;
    int i;

    for(i = 0; i < tam; i++)
        soma += vetor[i];

    return soma;
}

int main(){
    int vetor[] = {1, 2, 3, 4, 5};
    int tam = 5;
    int vetor_resultado[tam];
    int posicao = 0;
    int total_soma = 10;
    int i;
    int j;
    int l;

    //checagem de soma padrão em 0
    if(total_soma == 0){

        //busco o elemento 0 no vetor pai
        for(i = 0; i < tam;i++){

            //olhando se tem o elememto 0 no vetor pai
            if(vetor[i] == 0){
                vetor_resultado[posicao] = vetor[i];
                posicao++;
            }

            //nao tinha elemento 0 no vetor pai
            if(posicao == 0){
                printf("Nao tem elementos no vetor que somados deem esse resultado\n");
                break;
            }
        }
    }

    //se a soma é algo maior que zero
    else if(total_soma > 0){

        //checando de inviabilidade da soma de maneira unitaria
        for(i = 0; i < tam; i++){

            //checa se todos elementos do vetor pai é maior que a soma
            if(vetor[i] > total_soma){
                printf("Nao tem elementos no vetor pai que formem essa soma\n");
                break;
            }
        }

        //checa se a soma já é um elemento do vetor pai
        for(i = 0; i < tam; i++){
            if(total_soma == vetor[i]){
                vetor_resultado[posicao] = vetor[i];
                posicao++;
                break;
            }
        }

        //começa a popular o vetor filho pondo logo os maiores elemento do pai
        for(i = (tam - 1); i >= 0; i--){

            //se a soma do vetor filho é menor que a soma de k, continua pondo os maiores elementos do pai
            if(somar_elementos(vetor_resultado, posicao) < total_soma){
                vetor_resultado[posicao] = vetor[i];
                posicao++;
            }

            //se a soma dos elementos do filho passar, apaga o ultimo elemento do filho, pois foi ele que fez a soma estrapolar
            else if(somar_elementos(vetor_resultado, posicao) > total_soma){
                vetor_resultado[posicao] = 0;
                posicao--;
            }
        }

        //faz a diferenca do k pela soma do filho
        int diferenca = total_soma - somar_elementos(vetor_resultado, posicao);

        //procura um elemento no pai que seja exatamebte a diferença e põe no filho
        for(i = 0; i < (tam - 1); i++){
            if(vetor[i] == diferenca){
               vetor_resultado[posicao] = vetor[i];
               posicao++;
               break;
            }
        }

        //se não a soma do filho ainda não deu o valor de k
        for(i = 0;i < (tam - 1); i++){

            //adiciona o menor valor do pai ao filho, se o a soma do filho é menor que k
            if(somar_elementos(vetor_resultado, posicao) < total_soma){
                vetor_resultado[posicao] = vetor[i];
                posicao++;
            }

            //se a soma do filho passa do k
            else if(somar_elementos(vetor_resultado, posicao) > total_soma){

                //faz a direnca que existe entre o k e a soma do filho
                int diferenca_acima = -(total_soma - somar_elementos(vetor_resultado, posicao));

                //procura um elemento no filho que é exatamente o valor da diferença de a mais e o remove
                for(j = 0; j < posicao; j++){
                    if(vetor_resultado[j] == diferenca_acima){
                        vetor_resultado[j] = 0;

                        //arrasta os elementos seguintes ao apagado para manter a organização no filho
                        for(l = j; l < posicao; l++){
                            vetor_resultado[l] = vetor_resultado[l + 1];
                        }
                        posicao--;
                        break;
                    }
                }
            }

            //checa se a soma do filho é igual a k e termina tudo
            else if(somar_elementos(vetor_resultado, posicao) == total_soma){
                break;
            }
        }
    }else{
        //caso a soma seja algo não possivel de ser formado sonbre os elementos do pai
        printf("Nao tem elementos no vetor pai que tornem esse valor de soma possivel de ser expresso em um vetor auxiliar\n");
    }

    printf("soma = %d\n", total_soma);
    printf("soma do vetor auxiliar = %d\n", somar_elementos(vetor_resultado, posicao));

    printf("o vetor pai:\n[");
    for(i = 0; i < tam; i++){
        printf("%d ", vetor[i]);
    }
    printf("]\n");

    printf("o vetor auxiliar:\n[");
    for(i = 0; i < posicao; i++){
        printf("%d ", vetor_resultado[i]);
    }
    printf("]\n");

    return 0;
}
