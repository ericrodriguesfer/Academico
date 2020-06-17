#include <stdio.h>

int conjunto_recursivo(int i){
    if(i == 0) return 3;
    else
        return 3 + conjunto_recursivo(i - 1);
}

int main(){
    int a = 3;

    printf("%d", conjunto_recursivo(a));

    return 0;
}
