#include <iostream>

using namespace std;

void bubble_sort(int vetor[], int tam){
    for(int i = 0; i < (tam - 1); i++){
        for(int j = 0; j < (tam - i - 1); j++){
            if(vetor[j + 1] < vetor[j]){
                int copia = vetor[j + 1];
                vetor[j + 1] = vetor[j];
                vetor[j] = copia;
            }
        }
    }
}

int main(){
    int vetor[] = {24, 2452, 287, 42, 0, 1, 2, 542545, 545, 0, -1};
    int tam = 11;

    for(int i = 0; i < tam; i++){
        cout << vetor[i] << " ";
    }
    cout << " " << endl;

    bubble_sort(vetor, tam);

    for(int i = 0; i < tam; i++){
        cout << vetor[i] << " ";
    }
}
