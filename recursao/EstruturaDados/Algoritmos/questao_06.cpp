#include <iostream>

using namespace std;

void imprime_numeros(unsigned int termo){
    if(termo == 0){
        cout << termo << endl;
        return;
    }else{
        cout << termo << endl;
        return imprime_numeros(termo - 1);
    }
}

int main(){
    int termo = 15;
    imprime_numeros(termo);
}
