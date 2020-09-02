#include "set.hpp"
#include <limits>
#include <cstdlib>

set::set (unsigned int capacidade) {
    this -> vetor = new int[capacidade];
    this -> tamanho = 0;
    this -> capacidade = capacidade;
}

bool set::inserir (int elemento) {
    if (this -> tamanho < this -> capacidade) {
        if (!this -> pertence(elemento)) {
            this -> vetor[tamanho] = elemento;
            this -> tamanho++;

            return true;
        } else {
            return false;
        }
    } else {
        this -> vetor = (int*) realloc (this -> vetor, sizeof(int) * (this -> capacidade * 2));

        if (!vetor) {
            return false;
        } else {
            this -> capacidade *= 2;

            if (!this -> pertence(elemento)) {
                this -> vetor[tamanho] = elemento;
                this -> tamanho++;

                return true;
            } else {
                return false;
            }
        }
    }
}

bool set::remover (int elemento) {
    if (this -> tamanho == 0) {
        return false;
    }

    if (this -> pertence(elemento)) {
        for (unsigned int i = 0; i < this -> tamanho; i++) {
            if (this -> vetor[i] == elemento) {
                for (unsigned int j = (i + 1); j < this -> tamanho; j++) {
                    this -> vetor[j - 1] = this -> vetor[j];
                }

                this -> tamanho--;
                return true;
            }
        }
    } else {
        return false;
    }

    return false;
}

bool set::pertence (int elemento) const {
    if (this -> tamanho == 0) {
        return false;
    } 

    for (unsigned int i = 0; i < this -> tamanho; i++) {
        if (this -> vetor[i] == elemento) {
            return true;
        }
    }

    return false;
}

void set::uniao_com (set const &conjunto) {
    for (unsigned int i = 0; i < conjunto.tamanho; i++) {
        this -> inserir(conjunto.vetor[i]);
    }
}

void set::intersecao_com (set const &conjunto) {
    int tamanho_intersecao = 0;
    int *intersecao = new int[this -> tamanho];

    for (unsigned int i = 0; i < conjunto.tamanho; i++) {
        for (unsigned int j = 0; j < this -> tamanho; j++) {
            if (this -> vetor[j] == conjunto.vetor[i]) {
                intersecao[tamanho_intersecao] = this -> vetor[j];
                tamanho_intersecao++;
            }
        }
    }

    this -> tamanho = 0;

    for (unsigned int i = 0; i < tamanho_intersecao; i++) {
        this -> inserir(intersecao[i]);
    }

    delete[] intersecao;
}

bool set::esta_contido_em (set const &conjunto) const {
    for (unsigned int i = 0; i < this -> tamanho; i++) {
        if (!conjunto.pertence(this -> vetor[i])) {
            return false;
        }
    }

    return true;
}