#include <stdio.h>

int onis(char sequencia[]){
    if(sequencia == '\0') return 0;
    else if(sequencia == '1') return 10 + onis(--sequencia);
    else return onis(--sequencia);
}

int main(){
    char numero = "22222";

    printf("%d", onis(numero));

    return 0;
}
