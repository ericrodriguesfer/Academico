#include <stdio.h>

float recursao(float i){
    if(i == 0) return -1;
    else if(i == 1) return 2;
    else
        return recursao(i - 2) / recursao(i - 1);
}

int main(){
    float a = 3;

    printf("%.3f", recursao(a));

    return 0;
}
