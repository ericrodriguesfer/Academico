#include <stdio.h>
#include <math.h>

int recursao(int i){
    if(i == 0) return 1;
    else
        return pow(recursao(i - 1), 2) + recursao(i - 1) + 1;
}

int main(){
    int a  = 4;

    printf("%d", recursao(a));

    return 0;
}

