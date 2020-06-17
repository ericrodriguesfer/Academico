#include <stdio.h>
#include <math.h>

int recursao(int i){
    if(i == 0) return -1;
    else if(i == 1) return 2;
    else
        return pow(recursao(i - 1), 2) * recursao(i - 2);
}

int main(){
    int a = 5;

    printf("%d", recursao(a));

    return 0;
}
