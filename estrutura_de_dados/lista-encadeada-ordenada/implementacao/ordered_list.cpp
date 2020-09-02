#include "ordered_list.hpp"
#include <limits>

ordered_list::ordered_list () {
    this -> primeiro = nullptr;
    this -> tamanho = 0;
}

ordered_list::ordered_list (unsigned int tamanho, int inicial) {
    this -> primeiro = nullptr;
    this -> tamanho = tamanho;

    for (unsigned int i = 0; i < this -> tamanho; i++) {
        no_encadeado *novo_no = new no_encadeado(inicial, this -> primeiro);
        this -> primeiro = novo_no;
    }
}

void ordered_list::inserir (int elemento) {
    no_encadeado *novo_no = new no_encadeado(elemento, this -> primeiro);
    this -> primeiro = novo_no;
    this -> tamanho++;

    no_encadeado *i;
    no_encadeado *j;
    no_encadeado *fim = nullptr;

    for (i = this -> primeiro; i -> proximo != nullptr; i = i -> proximo) {
        for (j = this -> primeiro; j -> proximo != fim; j = j -> proximo) {
            if (j -> valor > j -> proximo -> valor) {
                int copia = j -> valor;
                j -> valor = j -> proximo -> valor;
                j -> proximo -> valor = copia;
            }
        }

        fim = j;
    }
}

bool ordered_list::remover (int elemento) {
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

bool ordered_list::pertence (int elemento) {
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

bool ordered_list::remover_de (unsigned int indice) {
    if (this -> tamanho == 0) {
        return false;
    }

    if (this -> pertence(this -> obter_elemento_em(indice))) {
        if (indice == 0) {
            no_encadeado *remocao = obter_no_em(indice);

            if (remocao == nullptr) {
                return false;
            }

            this -> primeiro = remocao -> proximo;
            this -> tamanho--;
            delete[] remocao;

            return true;
        } else {
            no_encadeado *remocao = obter_no_em(indice);
            no_encadeado *anterior = obter_no_em(indice - 1);

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

int ordered_list::obter_elemento_em (unsigned int indice) {
    if (this -> tamanho == 0) {
        return std::numeric_limits<int>::max();
    }

    unsigned int indice_busca = 0;
    no_encadeado *no = this -> primeiro;
    
    while (no != nullptr) {
        if (indice_busca == indice) {
            return no -> valor;
        }

        no = no -> proximo;
        indice_busca++;
    }

    return std::numeric_limits<int>::max();
}

unsigned int ordered_list::obter_indice_de (int elemento) {
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

ordered_list::no_encadeado::no_encadeado (int valor, no_encadeado* proximo) {
    this->valor = valor;
    this->proximo = proximo;
}

ordered_list::no_encadeado* ordered_list::obter_no_em(unsigned int indice) {
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

ordered_list::no_encadeado* ordered_list::obter_no_anterior_a (int valor) {
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