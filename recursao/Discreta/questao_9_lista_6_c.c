#include <stdio.h>
#include <math.h>

int recursao(int i){
    if(i == 0) return -1;
    else if(i == 1) return 2;
    else
        return 3 * (pow(recursao(i - 1), 2)) - (4 * pow(recursao(i - 2), 2));
}

int main(){
    int a = 4;

    printf("%d", recursao(a));

    return 0;
}
