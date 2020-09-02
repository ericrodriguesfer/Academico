#include "linked_set.hpp"
#include <limits>

// Construir lista vazia, mas com capacidade máxima informada.
linked_set::linked_set() {
    this->primeiro = nullptr;
    this->tamanho = 0;
}

// --- Métodos de "Coleção" ---


// Inserir "elemento" na coleção.
// Retornar indicativo de sucesso da inserção.
// NOTE Deve aumentar a capacidade caso necessário.
// NOTE Observe que aumentar em apenas uma unidade não nos alivia da pressão que tínhamos antes...
bool linked_set::inserir(int elemento) {
    // TODO Implementação.
}

// Remover "elemento" da coleção.
// Retornar indicativo de sucesso da remoção.
// NOTE Necessário preservar a ordem relativa dos que restarem.
bool linked_set::remover(int elemento) {
    // TODO Implementação.
}

// Determinar se "elemento" é um dos elementos ainda na coleção.
bool linked_set::pertence(int elemento) const {
    // TODO Implementação.
}


// --- Métodos de "Conjunto" ---

// Tornar o próprio conjunto (`this`) o resultado de sua união com o outro informado.
void linked_set::uniao_com(linked_set const &conjunto) {
    // TODO Implementação.
}

// Tornar o próprio conjunto (`this`) o resultado de sua intersecção com o outro informado.
void linked_set::intersecao_com(linked_set const &conjunto) {
    // TODO Implementação.
}

// Testar se este conjunto (`this`) está contido no outro informado.
bool linked_set::esta_contido_em(linked_set const &conjunto) const {
    // TODO Implementação.
}

// --- Métodos Auxiliares ---

// Construtor de um nó, onde a informação do próximo, no momento construção, é opcional
linked_set::no_encadeado::no_encadeado(int valor, no_encadeado* proximo) {
    this->valor = valor;
    this->proximo = proximo;
}

// Desejamos obter o próprio nó que esteja no índice informado.
// Deve retornar `nullptr` quando tal nó não existe.
// Auxilia processos que dependem de encontrar nós baseado em um índice.
linked_set::no_encadeado* linked_set::obter_no_em(unsigned int indice) {
    // TODO Implementação.
}

// Desejamos obter o próprio nó que veja **antes** de algum com o valor informado.
// (ou seja, `anterior.proximo.valor == valor`)
// Auxilia processos que dependem de encontrar nós baseado em um valor.
// Deve retornar `nullptr` quando tal nó não existe.
linked_set::no_encadeado* linked_set::obter_no_anterior_a(int valor) {
    // TODO Implementação.
}
