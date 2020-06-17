#include <iostream>

using namespace std;

int fatorial(unsigned int fator){
    if(fator == 0){
        return 1;
    }else{
        return fator * fatorial(fator - 1);
    }
}

int main(){
    int fator = 5;
    int fatorial_resultado = fatorial(fator);

    cout << "fatorial de: " << fator << ", e: " << fatorial_resultado << endl;
}
