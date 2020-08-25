#include "ordered_vector.hpp"
#include <limits>
#include <cstdlib>

ordered_vector::ordered_vector (unsigned int capacidade) {
    this -> vetor = new int[capacidade];
    this -> tamanho = 0;
    this -> capacidade = capacidade;
}

ordered_vector::ordered_vector (unsigned int tamanho, int inicial) {
    this -> vetor = new int[tamanho];
    this -> capacidade = tamanho;
    this -> tamanho = tamanho;

    for(unsigned int i = 0; i < this -> tamanho; i++) {
        this -> vetor[i] = inicial;
    }
}

void ordered_vector::inserir (int elemento) {
    if (this -> tamanho < this -> capacidade) {
        this -> vetor[tamanho] = elemento;
        this -> tamanho++;
    } else {
        this -> vetor = (int*) realloc (this -> vetor, sizeof(int) * (this -> capacidade * 2));

        if (!vetor) {
            return;
        } else {
            this -> capacidade *= 2;
            this -> vetor[tamanho] = elemento;
            this -> tamanho++;
        }
    }

    int intervalo = this -> tamanho;
    int copiado = 1;

    while ((intervalo > 1) || (copiado == 1)) {
        intervalo = (intervalo * 10) / 13;

        if (intervalo == 9 || intervalo == 10) {
            intervalo = 11;
        }

        if (intervalo < 1) {
            intervalo = 1;
        }

        copiado = 0;

        for (unsigned int i = 0, j = intervalo; j < this -> tamanho; i++, j++) {
            if (this -> vetor[i] > this -> vetor[j]) {
                int copia = this -> vetor[j];
                this -> vetor[j] = this -> vetor[i];
                this -> vetor[i] = copia;
                copiado = 1;
            }
        }
    }
}

bool ordered_vector::remover (int elemento) {
    if (this -> tamanho == 0) {
        return false;
    }

    bool resposta = pertence(elemento);

    if (resposta) {
        int indice = obter_indice_de(elemento);

        if (indice == std::numeric_limits<unsigned int>::max()) {
            return false;
        } else {
            for (unsigned int i = (indice + 1); i < this -> tamanho; i++) {
                this -> vetor[i - 1] = this -> vetor[i];
            }

            this -> tamanho--;
            return true;
        }
    } else {
        return false;
    }
}

bool ordered_vector::pertence (int elemento) {
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

bool ordered_vector::remover_de (unsigned int indice) {
    if (indice >= this -> tamanho || this -> tamanho == 0) {
        return false;
    }

    for (unsigned int i = (indice + 1); i < this -> tamanho; i++) {
        this -> vetor[i - 1] = this -> vetor[i];
    }

    this -> tamanho--;

    return true;
}

int ordered_vector::obter_elemento_em (unsigned int indice) {
    if (indice >= this -> tamanho || this -> tamanho == 0) {
        return std::numeric_limits<int>::max();
    }

    for (unsigned int i = 0; i < this -> tamanho; i++) {
        if (this -> vetor[i] == this -> vetor[indice]) {
            return this -> vetor[i];
        }
    }

    return std::numeric_limits<int>::max();
}

unsigned int ordered_vector::obter_indice_de (int elemento) {
    if (this -> tamanho == 0) {
        return std::numeric_limits<unsigned int>::max();
    }

    bool resposta = pertence(elemento);

    if (resposta) {
        for (unsigned int i = 0; i < this -> tamanho; i++) {
            if (this -> vetor[i] == elemento) {
                return i;
            }
        }
    }

    return std::numeric_limits<unsigned int>::max();
}
