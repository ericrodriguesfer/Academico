#include <stdio.h>

int recursao(int i){
    if(i == 0) return 1;
    else
        return 3 * recursao(i - 1);
}

int main(){
    int a  = 4;

    printf("%d", recursao(a));

    return 0;
}
