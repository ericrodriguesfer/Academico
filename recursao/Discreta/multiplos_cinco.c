#include <stdio.h>

int multiplos_cinco(int i){
    if(i == 0) return 5;
    else
        return 5 + multiplos_cinco(i - 1);
}

int main(){
    int a  = 4;

    printf("%d", multiplos_cinco(a));

    return 0;
}
