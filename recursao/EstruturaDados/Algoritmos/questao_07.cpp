#include <iostream>

using namespace std;

void imprime_numeros_pares(unsigned int termo){
    if(termo % 2 == 1){
        termo = termo - 1;
    }

    if(termo == 0){
        cout << termo << endl;
        return;
    }else{
        cout << termo << endl;
        return imprime_numeros_pares(termo - 2);
    }
}

int main(){
    int termo = 20;
    imprime_numeros_pares(termo);
}
