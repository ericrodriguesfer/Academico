#include <stdio.h>

int quadrados(int i){
    if(i == 0) return 1;
    else
        return 2 * quadrados(i - 1);
}

int main(){
    int a = 5;

    printf("%d", quadrados(a));

    return 0;
}
