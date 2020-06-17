#include <iostream>

using namespace std;

int menor_elemento_vetor(int *vetor, unsigned int tam){
    if(tam == 1){
        return vetor[0];
    }

    int menor = menor_elemento_vetor((vetor + 1), (tam -1));
    return (vetor[0] < menor) ? vetor[0] : menor;
}

int main(){
    unsigned int tam = 6;
    int vetor[] = {1, 2, 3, 3, 2, 1};

    int menor = menor_elemento_vetor(vetor, tam);

    cout << menor << endl;
}
