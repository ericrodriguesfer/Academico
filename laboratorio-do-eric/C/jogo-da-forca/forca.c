#include <stdio.h>
#include <string.h>
#include <locale.h>

#define TRUE 1
#define FALSE 0
#define BOOL int

int tamanho_palavra (char palavra[]) {
    return strlen(palavra);
}

void preenche_forca (char forca[], int tamanho_forca) {
    int i;

    for (i = 0; i < tamanho_forca; i++) {
        forca[i] = '_';
    }

    forca[tamanho_forca] = '\0';
}

void exibir_forca (char forca[], int tamanho_forca) {
    int i;

    for (i = 0; i < tamanho_forca; i++) {
        printf("%c ", forca[i]);
    }

    printf("\n");
}

BOOL marca_forca (char forca[], char palavra[], int tamanho_forca, char letra_forca) {
    BOOL acertou = FALSE;
    int i;

    for (i = 0; i < tamanho_forca; i++) {
        if (letra_forca == palavra[i] && forca[i] == '_') {
            forca[i] = letra_forca;
            acertou = TRUE;
        } else if (forca[i] == letra_forca) {
            acertou = TRUE;
        }
    }

    return acertou;
}

int main () {
    setlocale(LC_ALL, "Portuguese");

    char palavra[50];
    char forca[50];
    char letra_forca;
    int total_chances;
    int tamanho_forca;
    BOOL acertou;
    int i;

    printf("Digite a palavra que vai ser usada nesta rodada: ");
    scanf("%s", &palavra);

    printf("Digite a quantidade de tenativa para esta rodada: ");
    scanf("%d", &total_chances);

    tamanho_forca = tamanho_palavra(palavra);

    preenche_forca(forca, tamanho_forca);

    while (total_chances > 0) {
        system("cls");

        exibir_forca(forca, tamanho_forca);

        printf("Chances: %d\n", total_chances);

        printf("Digite uma letra que tu acha que esteja na palavra: ");
        scanf("\n%c", &letra_forca);

        acertou = marca_forca(forca, palavra, tamanho_forca, letra_forca);

        if (acertou == FALSE) {
            total_chances--;    
        }

        if (strcmp(palavra, forca) == 0) {
            printf("MUITO BEM, TU ACERTOU A MINHA PALAVRA\n");
            break;
        }
    }

    if (total_chances == 0) {
        printf("INFELIZMENTE TU NAO ACERTOU MIMHA PALAVRA\n");
    }

    return 0;
}