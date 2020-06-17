#include <stdio.h>

void selection_sort(int vetor[], int tam){
    int i;
    int j;

    for(i = 0; i < (tam - 1); i++){
        int posicao_menor = i;

        for(j = (i + 1); j < tam; j++){
            if(vetor[j] < vetor[posicao_menor]){
                posicao_menor = j;
            }
        }

        int copia = vetor[posicao_menor];
        vetor[posicao_menor] = vetor[i];
        vetor[i] = copia;
    }
}

int main(){
    int vetor[] = {12, 10, 8, 6, 4, 2, 0};
    int tam = 7;
    int i;

    for(i = 0; i < tam; i++){
        printf("%d ", vetor[i]);
    }
    printf("\n");

    selection_sort(vetor, tam);

    for(i = 0; i < tam; i++){
        printf("%d ", vetor[i]);
    }
    printf("\n");

    return 0;
}
