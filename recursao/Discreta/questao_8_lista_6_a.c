#include <stdio.h>

int recursao(int i){
    if(i == 0) return 1;
    else
        return 2 + recursao(i - 1);
}

int main(){
    int a  = 3;

    printf("%d", recursao(a));

    return 0;
}
