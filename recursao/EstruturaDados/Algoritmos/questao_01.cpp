#include <iostream>

using namespace std;

void inverte_vetor(double *vetor, unsigned int inicio, unsigned int fim){
    if(inicio > fim){
        return;
    }else{
        double copia = vetor[fim];
        vetor[fim] = vetor[inicio];
        vetor[inicio] = copia;

        inverte_vetor(vetor, (inicio + 1), (fim - 1));
    }
}

int main(){
    unsigned int tam = 10;
    double vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    for(unsigned int i = 0; i < tam; i++){
        cout << vetor[i] << " ";
    }

    cout << " " << endl;

    inverte_vetor(vetor, (tam - tam), (tam - 1));

    for(unsigned int i = 0; i < tam; i++){
        cout << vetor[i] << " ";
    }

    cout << " " << endl;
}
