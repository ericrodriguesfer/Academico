#include "linked_set.hpp"
#include <limits>

linked_set::linked_set () {
    this -> primeiro = nullptr;
    this -> tamanho = 0;
}

bool linked_set::inserir (int elemento) {
    if (this -> tamanho == 0) {
        no_encadeado *novo_no = new no_encadeado(elemento, this -> primeiro);
        this -> primeiro = novo_no;
        this -> tamanho++;

        return true;
    }

    if (!this -> pertence(elemento)) {
        no_encadeado *novo_no = new no_encadeado(elemento, this -> primeiro);
        this -> primeiro = novo_no;
        this -> tamanho++;

        return true;
    } else {
        return false;
    }

    return false;
}

bool linked_set::remover (int elemento) {
    if (this -> tamanho == 0) {
        return false;
    }

    if (this -> pertence(elemento)) {
        unsigned int indice_remocao = obter_indice_de(elemento);

        if (indice_remocao == 0) {
            no_encadeado *remocao = obter_no_em(indice_remocao);

            if (remocao == nullptr) {
                return false;
            }

            this -> primeiro = remocao -> proximo;
            this -> tamanho--;
            delete[] remocao;

            return true;
        } else {
            no_encadeado *remocao = obter_no_em(indice_remocao);
            no_encadeado *anterior = obter_no_em(indice_remocao - 1);

            if (remocao == nullptr || anterior == nullptr) {
                return false;
            }

            anterior -> proximo = remocao -> proximo;
            this -> tamanho--;
            delete[] remocao;

            return true;
        }
    } else {
        return false;
    }
}

bool linked_set::pertence (int elemento) const {
    if (this -> tamanho == 0) {
        return false;
    }

    no_encadeado *no = this -> primeiro;

    while (no != nullptr) {
        if (no -> valor == elemento) {
            return true;
        }

        no = no -> proximo;
    }

    return false;
}

void linked_set::uniao_com (linked_set const &conjunto) {
    for (no_encadeado *no = conjunto.primeiro; no != nullptr; no = no -> proximo) {
        this -> inserir(no -> valor);
    }
}

void linked_set::intersecao_com (linked_set const &conjunto) {
    int tamanho_intersecao = 0;
    int *intersecao = new int[this -> tamanho];

    for (no_encadeado *no_um = conjunto.primeiro; no_um != nullptr; no_um = no_um -> proximo) {
        for (no_encadeado *no_dois = this -> primeiro; no_dois != nullptr; no_dois = no_dois -> proximo) {
            if (no_dois -> valor == no_um -> valor) {
                intersecao[tamanho_intersecao] = no_dois -> valor;
                tamanho_intersecao++;
            }
        }
    }

    this -> primeiro = nullptr;
    this -> tamanho = 0;

    for (unsigned int i = 0; i < tamanho_intersecao; i++) {
        this -> inserir(intersecao[i]);
    }

    delete[] intersecao;
}

bool linked_set::esta_contido_em (linked_set const &conjunto) const {
    for (no_encadeado *no = this -> primeiro; no != nullptr; no = no -> proximo) {
        if (!conjunto.pertence(no -> valor)) {
            return false;
        }
    }

    return true;
}

unsigned int linked_set::obter_indice_de (int elemento) const {
    if (this -> tamanho == 0) {
        return std::numeric_limits<unsigned int>::max();
    }

    unsigned int indice = 0;
    no_encadeado* no = this -> primeiro;

    while (no != nullptr) {
        if (no -> valor == elemento) {
            return indice;
        }

        indice++;
        no = no -> proximo;
    }

    return std::numeric_limits<unsigned int>::max();
}

linked_set::no_encadeado::no_encadeado (int valor, no_encadeado* proximo) {
    this->valor = valor;
    this->proximo = proximo;
}

linked_set::no_encadeado* linked_set::obter_no_em (unsigned int indice) const {
    if (this -> tamanho == 0) {
        return nullptr;
    }

    unsigned int indice_busca = 0;
    no_encadeado *no = this -> primeiro;

    while (no != nullptr) {
        if (indice_busca == indice) {
            return no;
        }

        indice_busca++;
        no = no -> proximo;
    }

    return nullptr;
}

linked_set::no_encadeado* linked_set::obter_no_anterior_a (int valor) const {
    if (this -> tamanho == 0) {
        return nullptr;
    }

    no_encadeado *no = this -> primeiro;

    while (no != nullptr) {
        if (no -> proximo -> valor == valor) {
            return no;
        }

        no = no -> proximo;
    }

    return nullptr;
}
