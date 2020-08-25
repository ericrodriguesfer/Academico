#include <stdio.h>
#include <string.h>

int main () {
    char string_um[50];
    char string_dois[50];
    char string_um_inversa[50];
    char string_dois_inversa[50];
    int tamanho_um = 0;
    int tamanho_dois = 0;
    int i;

    scanf("%s", string_um);
    scanf("%s", string_dois);

    for (i = 0; string_um[i]; i++) {
        tamanho_um++;
    }

    for (i = 0; string_dois[i]; i++) {
        tamanho_dois++;
    }

    printf("%s: %d\n", string_um, tamanho_um);
    printf("%s: %d\n", string_dois, tamanho_dois);

    if (strstr(string_um, string_dois) != NULL) {
        printf("%s contem $s\n", string_um, string_dois);
    } else {
        printf("%s nao contem %s\n", string_um, string_dois);
    }

    if (strstr(string_dois, string_um) != NULL) {
        printf("%s contem %s\n", string_dois, string_um);
    } else {
        printf("%s nao contem %s\n", string_dois, string_um);
    }

    string_um_inversa[tamanho_um] = '\0';
    tamanho_um--;
    string_dois_inversa[tamanho_dois] = '\0';
    tamanho_dois--;

    for (i = 0; string_um[i]; i++) {
        string_um_inversa[tamanho_um] = string_um[i];
        tamanho_um--;
    }

    for (i = 0; string_dois[i]; i++) {
        string_dois_inversa[tamanho_dois] = string_dois[i];
        tamanho_dois--;
    }

    printf("%s\n", string_um_inversa);
    printf("%s\n", string_dois_inversa);

    return 0;
}
