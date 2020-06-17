#include <stdio.h>

void insertion_sort(int vetor[], int tam){
    int i;

    for(i = 1; i < tam; i++){
        int valor = vetor[i];
        int j = (i - 1);

        while((j >= 0) && (vetor[j] > valor)){
            vetor[j + 1] = vetor[j];
            j = (j - 1);
        }

        vetor[j + 1] = valor;
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

    insertion_sort(vetor, tam);

    for(i = 0; i < tam; i++){
        printf("%d ", vetor[i]);
    }
    printf("\n");

    return 0;
}
