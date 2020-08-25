#include "ordered_vector.hpp"
#include <limits>

// Construir lista vazia, mas com capacidade máxima informada.
ordered_vector::ordered_vector(unsigned int capacidade) {
    vetor = new int[capacidade];
    tamanho = 0;
    this->capacidade = capacidade;
}

// Construir lista com "tamanho" cópias do valor "inicial".
ordered_vector::ordered_vector(unsigned int tamanho, int inicial) {
    vetor = new int[tamanho];
    capacidade = tamanho;
    this->tamanho = tamanho;

    for(unsigned int i = 0; i < tamanho; i++) {
        vetor[i] = inicial;
    }
}


// --- Métodos de "Coleção" ---


// Inserir "elemento" na coleção. Sempre deve executar a inserção.
// NOTE  Observe que aumentar em apenas uma unidade não nos alivia da pressão que tínhamos antes...
void ordered_vector::inserir(int elemento) {
    // TODO Implementação.
}

// Remover "elemento" da coleção.
// Retornar indicativo de sucesso da remoção.
// NOTE Necessário preservar a ordem relativa dos que restarem.
bool ordered_vector::remover(int elemento) {
    // TODO Implementação.
}

// Determinar se "elemento" é um dos elementos ainda na coleção.
bool ordered_vector::pertence(int elemento) {
    // TODO Implementação.
}


// --- Métodos de "Lista" ---

// Remover o elemento associado a "indice".
// Retornar indicativo de sucesso da remoção.
bool ordered_vector::remover_de(unsigned int indice) {
    // TODO Implementação.
}

// Retornar o valor associado ao índice "indice".
// NOTE Quando o índice for inválido, retornar `std::numeric_limits<int>::max()`
//      (forma de obter o maior valor representável).
int ordered_vector::obter_elemento_em(unsigned int indice) {
    // TODO Implementação.
}

// Retornar o índice associado a "elemento".
// NOTE Quando o índice for inválido, retornar `std::numeric_limits<unsigned int>::max()`
//      (forma de obter o maior valor representável).
unsigned int ordered_vector::obter_indice_de(int elemento) {
    // TODO Implementação.
}
