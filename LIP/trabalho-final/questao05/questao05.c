/*
    Explicação a respeito da questão 05:

    Considerações iniciais, como é uma questão para afetuarmos a medição de tempo de execução a arquitetura da máquina
    em uso exerce determinada influência nos resultados, mas vamos lá. O acesso mais confiável é o que é realizado por indices
    ao invés de ponteiros e aritimética de ponteiros, pois quando se executa acesso por meio de indices, se tem um acesso mais controlado
    por parte do código em relação a axecução, porque trabalhando com indices sempre estará a margem de um porção conhecidade de valores
    nos quais se deseja realizar alguma operação, caso estrapolado esse acesso com margem adentrando em locais de momória que não foram
    destinados ao código, provalvelmente será disparado um erro de falha de segmentação, pois se tentou acessar locais sob os quais o
    código não detia controle, sem contar que o avesso e operações são mais rápidas. No caso dos ponteiros por usar referência e calculos sobre
    o tamanho do tipo e dado na memória, isso torna o processo de acesso e operações mais lento, sem contar também que deixa de ser aquele controle
    citado anteriormente, onde nesse cenário, pode sim adentrar em locais de memória desconhecidos ao código, sem intimar sobre quais quer
    circunstâncias de erro, o que pode vir a acarretar falhas no processo de execução.

    Segue abaixo as médias de tempo de execução em segundos, para ambos os casos:
        > com matrizes de tamanho 100x100
    
    Tempo indice: 0.00000
    Tempo ponteiro: 31.25000
*/

#include <stdio.h>
#include <time.h>

void matriz_indices (int matriz[100][100]) {
    int i, j;
    for (i = 0; i < 100; i++) {
        for (j = 0; j < 100; j++) {
            matriz[i][j] = (i * j);
        }
    }

    for (i = 0; i < 100; i++) {
        for (j = 0; j < 100; j++) {
            printf("%d ", matriz[i][j]);
        }

        printf("\n");
    }
}

void matriz_ponteiro (int matriz[100][100]) {
    int i;
    int *ma;

    for (i = 0, ma = matriz[0]; i < (100 * 100); i++, ma++) {
        *ma = (i + 1);
    }

    for (i = 0, ma = matriz[0]; i < (100 * 100); i++, ma++) {
        printf("%d ", *ma);

        if (i == 1000 || i == 2000 || i == 3000 || i == 4000 || i == 5000 || i == 6000 || i == 7000 || i == 8000 || i == 9000 || i == 10000) {
            printf("\n");
        }
    }
}


int main () {
    int matriz[100][100];
    clock_t inicio, fim;
    double tempo_indice, tempo_ponteiro;

    inicio = clock();
    matriz_indices(matriz);
    fim = clock();

    tempo_indice = 1000.0 * ((double)fim - (double)inicio) / CLOCKS_PER_SEC;
    
    inicio = clock();
    matriz_ponteiro(matriz);
    fim = clock();

    tempo_ponteiro = 1000.0 * ((double)fim - (double)inicio) / CLOCKS_PER_SEC;

    printf("\nTempo indice: %.5f\n", tempo_indice);
    printf("Tempo ponteiro: %.5f\n", tempo_ponteiro);

    return 0;
}
