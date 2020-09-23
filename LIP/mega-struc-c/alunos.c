#include <stdio.h>
#include <string.h>

#define TRUE 1
#define FALSE 0
#define BOOL int

enum {
    LIP,
    Compiladores,
    Paralela
} disciplina;

enum Curso{
    CC,
    ES,
    EC,
    RC,
    DD
} Curso;

enum {
    NAO,
    SIM
} Consolidado;

typedef union {
    float media;
    float notas[3];
} Avaliacao;

typedef struct {
    char nome[50],
    disciplina,
    curso,
    consolidado;
    Avaliacao avaliacao
} Estudante;

BOOL comparaEstudante(Estudante aluno_1, Estudante aluno_2) {
    if (strcmp(aluno_1.nome, aluno_2.nome)== 0) {
        if (aluno_1.disciplina == aluno_2.disciplina) {
            if (aluno_1.curso == aluno_2.curso) {
                if (aluno_1.consolidado == SIM && aluno_2.consolidado == SIM) {
                    if (aluno_1.avaliacao.media == aluno_2.avaliacao.media) {
                        return TRUE;
                    } else {
                        return FALSE;
                    }
                } else if (aluno_1.consolidado == SIM && aluno_2.consolidado == NAO){
                    if ((aluno_1.avaliacao.media) == ((aluno_2.avaliacao.notas[0] + aluno_2.avaliacao.notas[1] + aluno_2.avaliacao.notas[2])/3.0)) {
                        return TRUE;
                    } else {
                        return FALSE;
                    }
                } else if (aluno_1.consolidado == NAO && aluno_2.consolidado == SIM) {
                    if (((aluno_1.avaliacao.notas[0] + aluno_1.avaliacao.notas[1] + aluno_1.avaliacao.notas[2])/3.0) == (aluno_2.avaliacao.media)) {
                        return TRUE;
                    } else {
                        return FALSE;
                    }
                } else {
                    if (((aluno_1.avaliacao.notas[0] + aluno_1.avaliacao.notas[1] + aluno_1.avaliacao.notas[2])/3.0) == ((aluno_2.avaliacao.notas[0] + aluno_2.avaliacao.notas[1] + aluno_2.avaliacao.notas[2])/3.0)) {
                        return TRUE;
                    } else {
                        return FALSE;
                    }
                }
            } else {
                return FALSE;
            }
        } else {
            return FALSE;
        }
    } else {
        return FALSE;
    }
}

int main () {
    Estudante a;
    Estudante b;
    Estudante c;
    Estudante d;

    strcpy(a.nome, "Joao Marcelo");
    a.disciplina = Paralela;
    a.curso = CC;
    a.avaliacao.media = 7.0;
    a.consolidado = SIM;

    strcpy(b.nome, "Joao Marcelo");
    b.disciplina = Paralela;
    b.curso = CC;
    b.avaliacao.notas[0] = 7.0;
    b.avaliacao.notas[1] = 8.0;
    b.avaliacao.notas[2] = 6.0;
    b.consolidado = NAO;

    strcpy(c.nome, "Maria do Carmo");
    c.disciplina = Compiladores;
    c.curso = ES;
    c.avaliacao.media = 8.0;
    c.consolidado = SIM;

    strcpy(d.nome, "Francisco de Assis");
    d.disciplina = LIP;
    d.curso = EC;
    d.avaliacao.notas[0] = 2.0;
    d.avaliacao.notas[1] = 2.0;
    d.avaliacao.notas[2] = 6.0;
    d.consolidado = NAO;

    printf("%s %d %d %.2f %d\n", a.nome, a.disciplina, a.curso, a.avaliacao.media, a.consolidado);
    printf("%s %d %d %.2f %d\n", b.nome, b.disciplina, b.curso,(b.avaliacao.notas[0] + b.avaliacao.notas[1] + b.avaliacao.notas[2])/3.0, b.consolidado) ;

    if (comparaEstudante(a, b)) {
        printf("a e b iguais.\n");
    } else {
        printf("a e b diferentes.\n");
    }

    printf("%s %d %d %.2f %d\n", c.nome, c.disciplina, c.curso, c.avaliacao.media, c.consolidado);
    printf("%s %d %d %.2f %d\n", d.nome, d.disciplina, d.curso, (d.avaliacao.notas[0] + d.avaliacao.notas[1] + d.avaliacao.notas[2])/3.0, d.consolidado) ;

    if (comparaEstudante(c, d)) {
        printf("c e d iguais.\n");
    } else {
        printf("c e d diferentes.\n");
    }

    return 0;
}
