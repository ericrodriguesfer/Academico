#include <iostream>

using namespace std;

void insertion_sort(int vetor[], int tam){
    for(int i = 1; i < tam; i++){
        int menor_valor = vetor[i];
        int j = (i - 1);

        while((j >= 0) && (vetor[j] > menor_valor)){
            vetor[j + 1] = vetor[j];
            j = (j - 1);
        }

        vetor[j + 1] = menor_valor;
    }
}

int main(){
    int vetor[] = {561, 165, 10, 88, 0, 1, 2, 55, 545, 0, -1};
    int tam = 11;

    for(int i = 0; i < tam; i++){
        cout << vetor[i] << " ";
    }
    cout << " " << endl;

    insertion_sort(vetor, tam);

    for(int i = 0; i < tam; i++){
        cout << vetor[i] << " ";
    }
}
