#include "vector.hpp"
#include <limits>
#include <cstdlib>

vector::vector (unsigned int capacidade) {
    this -> vetor = new int[capacidade];
    this -> tamanho = 0;
    this -> capacidade = capacidade;
}

vector::vector (unsigned int tamanho, int inicial) {
    this -> vetor = new int[tamanho];
    this -> capacidade = tamanho;
    this -> tamanho = tamanho;

    for (unsigned int i = 0; i < this -> tamanho; i++) {
        this -> vetor[i] = inicial;
    }
}

void vector::inserir (int elemento) {
    if (this -> tamanho < this -> capacidade) {
        this -> vetor[tamanho] = elemento;
        this -> tamanho++;
    } else {
        this -> vetor = (int*) realloc (this -> vetor, sizeof(int) * (this -> capacidade * 2));

        if (!this -> vetor) {
            return;
        } else {
            this -> capacidade *= 2;
            this -> vetor[tamanho] = elemento;
            this -> tamanho++;
        }
    }
}

bool vector::remover (int elemento) {
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

bool vector::pertence (int elemento) {
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

void vector::inserir_em (unsigned int indice, int elemento) {
    if (this -> tamanho == this -> capacidade) {
        return;
    }

    int copia_indice = indice;

    for (int i = this -> tamanho; i >= copia_indice; i--) {
        this -> vetor[i + 1] = this -> vetor[i];
    }

    this -> vetor[copia_indice] = elemento;
    this -> tamanho++;
}

bool vector::remover_de (unsigned int indice) {
    if (indice >= this -> tamanho || this -> tamanho == 0) {
        return false;
    }

    for (unsigned int i = (indice + 1); i < this -> tamanho; i++) {
        this -> vetor[i - 1] = this -> vetor[i];
    }
    this -> tamanho--;

    return true;
}

int vector::obter_elemento_em (unsigned int indice) {
    if (indice >= this -> tamanho || this -> tamanho == 0) {
        return std::numeric_limits<int>::max();
    }

    for (unsigned int i = 0; i < this -> tamanho; i++) {
        if(this -> vetor[i] == this -> vetor[indice]) {
            return this -> vetor[i];
        }
    }

    return std::numeric_limits<int>::max();
}

unsigned int vector::obter_indice_de (int elemento) {
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