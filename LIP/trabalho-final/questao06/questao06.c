/*
    Explicação a respeito da questão 06:

    O conjunto de resultados encontrados na execução em C, tendo que as expressões em questão foram avaliadas da esquerda para 
    a direita, são:

    sum 1: 46
    sum 2: 48

    Os resultado obtidos em C++:
    sum 1: 46
    sum 2: 48

    Os resultado obtidos em Java:
    sum 1: 46
    sum 2: 46
    
    Os resultado obtidos em C#:
    sum 1: 46
    sum 2: 48

    Como podemos observar o resultado se manteve os mesmo nas linguagens C, C++ e C#, pois são linguagens que a passagem de valores
    por referência é permitida, mas quando falamos em valores, estamos falando de valores de variaveis primitivas e não objetos. Já
    o código em Java onde a linguaguem só permite passagem de valores por copia (exceto objetos, que são por referência), então os
    valores modificados na função se não são retornados, não exercer influência na execução.
*/

#include <stdio.h>

int fun(int *k) {
    *k += 4;
    return 3 * (*k) - 1;
}

void main() {
    int i = 10, j = 10, sum1, sum2;
    
    sum1 = (i / 2) + fun(&i);
    sum2 = fun(&j) + (j / 2);

    printf("sum 1: %d\nsum 2: %d\n", sum1, sum2);
}