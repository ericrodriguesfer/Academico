#include <stdio.h>
#include <limits.h>

#define LIMITE INT_MAX

int main () {
    int num;

    scanf("%d", &num);

    while (num != INT_MAX) {
        num++;
    }

    printf("Maior multiplo: %d", num);

    return 0;
}
