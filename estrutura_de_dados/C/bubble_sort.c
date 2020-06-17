#include <stdio.h>

void bubble_sort(int vetor[], int tam){
    int i;
    int j;

    for(i = 0; i < (tam - 1); i++){
        for(j = 0; j < (tam - 1); j++){
            if(vetor[j + 1] < vetor[j]){
                int copia = vetor[j + 1];
                vetor[j + 1] = vetor[j];
                vetor[j] = copia;
            }
        }
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

    bubble_sort(vetor, tam);

    for(i = 0; i < tam; i++){
        printf("%d ", vetor[i]);
    }
    printf("\n");

    return 0;
}
