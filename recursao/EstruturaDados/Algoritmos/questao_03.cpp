#include <iostream>

using namespace std;

int fatorial_duplo(unsigned int fator){
    if(fator == 1){
        return 1;
    }else{
        return fator * fatorial_duplo(fator - 2);
    }
}

int main(){
    int fator = 5;
    int fatorial_resultado = fatorial_duplo(fator);

    cout << "fatorial de: " << fator << ", e: " << fatorial_resultado << endl;
}
