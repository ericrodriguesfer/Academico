// NOTE Em C++, a ocorrência de `const` após o nome de um método indica a promessa
//      de que tal método não irá fazer alterações nas variáveis do objeto e que
//      pode ser chamado em objetos declarados como `const`.

class linked_set {
    private:
        // Classe que representa os componentes da lista na memória
        class no_encadeado {
        public:
            int valor;
            // Referência para o nó que vem após o atual
            no_encadeado* proximo;

            // Construtor
            no_encadeado(int valor, no_encadeado* proximo = nullptr);
        };

        // Contagem da quantidade de elementos presentes na lista.
        unsigned int tamanho;

        // Ponteiro para o primeiro elemento da lista
        no_encadeado* primeiro;

    public:
        // Construtores
        linked_set();

        // Métodos de "Coleção"
        bool inserir(int elemento);
        bool remover(int elemento);
        bool pertence(int elemento) const;

        unsigned int obter_tamanho() const { return tamanho; }

        // Métodos de "Conjunto"

        // NOTE Em C++, o "&" antes do nome da variável, neste caso, significa que iremos receber
        //      o outro conjunto por referência. Você não precisa se preocupar com isso, pois
        //      a sintaxe dentro do método funcionará como antes.
        void uniao_com(linked_set const &conjunto);
        void intersecao_com(linked_set const &conjunto);
        bool esta_contido_em(linked_set const &conjunto) const;

    protected:
        // Métodos auxiliares
        no_encadeado* obter_no_em(unsigned int indice) const;
        no_encadeado* obter_no_anterior_a(int valor) const;
};