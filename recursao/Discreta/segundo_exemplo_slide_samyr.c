#include <stdio.h>

int exemplo_slide(int i){
    if(i == 0) return 3;
    else
        return 2 * exemplo_slide(i - 1) + 3;
}

int main(){
    int a = 4;

    printf("%d", exemplo_slide(a));

    return 0;
}
