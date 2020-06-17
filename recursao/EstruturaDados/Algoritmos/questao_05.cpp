#include <iostream>

using namespace std;

void inverte_string(char *palavra, unsigned int inicio, unsigned int fim){
    if(inicio > fim){
        return;
    }else{
        char copia = palavra[inicio];
        palavra[inicio] = palavra[fim];
        palavra[fim] = copia;

        inverte_string(palavra, (inicio + 1), (fim - 1));
    }
}

int main(){
    char palavra[] = "casa";
    unsigned int tamanho_palavra = 0;

    for(unsigned int i = 0; palavra[i]; i++){
        tamanho_palavra++;
    }

    inverte_string(palavra, (tamanho_palavra - tamanho_palavra), (tamanho_palavra - 1));

    cout << palavra << endl;
}
