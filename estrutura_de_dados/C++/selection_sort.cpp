#include <iostream>

using namespace std;

void selection_sort(int vetor[], int tam){
    for(int i = 0; i < (tam - 1); i++){
        int posicao_menor =  i;

        for(int j = (i + 1); j < tam; j++){
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
    int vetor[] = {561, 165, 10, 88, 0, 1, 2, 55, 545, 0, -1};
    int tam = 11;

    for(int i = 0; i < tam; i++){
        cout << vetor[i] << " ";
    }
    cout << " " << endl;

    selection_sort(vetor, tam);

    for(int i = 0; i < tam; i++){
        cout << vetor[i] << " ";
    }
}
