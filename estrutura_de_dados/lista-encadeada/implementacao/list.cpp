#include "list.hpp"
#include <limits>

list::list () {
    this -> primeiro = nullptr;
    this -> tamanho = 0;
}

list::list (unsigned int tamanho, int inicial) {
    this -> primeiro = nullptr;
    this -> tamanho = tamanho;

    for (unsigned int i = 0; i < this -> tamanho; i++) {
        no_encadeado *novo_no = new no_encadeado(inicial, this -> primeiro);
        this -> primeiro = novo_no;
    }
}

void list::inserir (int elemento) {
    no_encadeado *novo_no = new no_encadeado(elemento, this -> primeiro);
    this -> primeiro = novo_no;
    this -> tamanho++;
}

bool list::remover (int elemento) {
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

bool list::pertence (int elemento) {
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

bool list::inserir_em (unsigned int indice, int elemento) {
    if (indice == 0) {
        no_encadeado* novo_no = new no_encadeado(elemento, this -> primeiro);

        this -> primeiro = novo_no;
        this -> tamanho++;

        return true;
    } else {
        no_encadeado* anterior = obter_no_em(indice - 1);

        if (anterior != nullptr) {
            no_encadeado* novo_no = new no_encadeado(elemento);

            novo_no -> proximo = anterior -> proximo;
            anterior -> proximo = novo_no;
            this -> tamanho++;

            return true;
        } else {
            return false;
        }
    }
}

bool list::remover_de (unsigned int indice) {
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

int list::obter_elemento_em (unsigned int indice) {
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

unsigned int list::obter_indice_de (int elemento) {
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

list::no_encadeado::no_encadeado (int valor, no_encadeado* proximo) {
    this -> valor = valor;
    this -> proximo = proximo;
}

list::no_encadeado* list::obter_no_em (unsigned int indice) {
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

list::no_encadeado* list::obter_no_anterior_a (int valor) {
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
