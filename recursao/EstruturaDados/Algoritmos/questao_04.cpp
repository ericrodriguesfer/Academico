#include <iostream>

using namespace std;

int fibonacci_termo(unsigned int termo){
    if(termo == 1){
        return 0;
    }else if(termo == 2 || termo == 3){
        return 1;
    }else{
        return fibonacci_termo(termo - 1) + fibonacci_termo(termo - 2);
    }
}

int main(){
    unsigned int termo = 18;
    int fibonacci = fibonacci_termo(termo);

    cout << "O " << termo << " termo da sequencia de fibonacci e: " << fibonacci << endl;
}
