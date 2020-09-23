#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

#define TRUE 1
#define FALSE 0
#define BOOL int

int strlen (char *string) {
    int i;
    int contador = 0;

    for (i = 0; string[i]; i++) {
        contador++;
    }

    return contador;
}

BOOL strcmp (char *string_1, char *string_2) {
    int tamanho_string_1 = strlen(string_1);
    int tamanho_string_2 = strlen(string_2);
    int i;

    if (tamanho_string_1 != tamanho_string_2) {
        return FALSE;
    }

    for (i = 0; string_1[i]; i++) {
        if (string_1[i] != string_2[i]) {
            return FALSE;
        }
    }

    return TRUE;
}

char* strcat (char *string_1, char *string_2) {
    int tamanho_string_1 = strlen(string_1);
    int tamanho_string_2 = strlen(string_2);
    int i;

    int tamanho_nova_string = tamanho_string_1 + tamanho_string_2;
    char *nova_string = (char*) malloc (sizeof(char) * tamanho_nova_string);

    for (i = 0; string_1[i]; i++) {
        nova_string[i] = string_1[i];
    }

    for (i = 0; string_2[i]; i++) {
        nova_string[tamanho_string_1] = string_2[i];
        tamanho_string_1++;
    }

    nova_string[tamanho_nova_string] = '\0';

    return nova_string;
}

int main () {
    setlocale(LC_ALL, "Portuguese");

    char string_1[50];
    char string_2[50];

    scanf("%s", string_1);
    scanf("%s", string_2);

    char *string_retornada = strcat(&string_1, &string_2);

    printf("Tamanho da string 1: %d\n", strlen(&string_1));
    printf("Tamanho da string 2: %d\n", strlen(&string_2));
    printf((strcmp(&string_1, &string_2) == TRUE ? "As strings s�o iguais\n" : "As strings n�o s�o iguais\n"));
    printf("Uni�o das duas strings (%s) com (%s): %s\n", string_1, string_2, string_retornada);

    free(string_retornada);

    return 0;
}
