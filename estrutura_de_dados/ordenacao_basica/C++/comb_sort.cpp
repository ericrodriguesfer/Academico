#include <iostream>

using namespace std;

void comb_sort(int *vetor, unsigned int tam){
    int intervalo = tam;
    unsigned int trocado = 1;

    while(intervalo > 1 || trocado == 1){
        intervalo = (intervalo * 10) / 13;

        if(intervalo == 9 || intervalo == 10){
            intervalo = 11;
        }

        if(intervalo < 1){
            intervalo = 1;
        }

        trocado = 0;

        for(unsigned int i = 0, j = intervalo; j < tam; i++, j++){
            if(vetor[i] > vetor[j]){
                int copia = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = copia;
                trocado = 1;
            }
        }
    }
}

int main(){
    int vetor[] = {561, 165, 10, 88, 0, 1, 2, 55, 545, 0, -1};
    int tam = 11;

    for(int i = 0; i < tam; i++){
        cout << vetor[i] << " ";
    }
    cout << " " << endl;

    comb_sort(vetor, tam);

    for(int i = 0; i < tam; i++){
        cout << vetor[i] << " ";
    }
}
