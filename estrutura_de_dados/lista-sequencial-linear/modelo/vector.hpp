class vector {
    private:
        // Ponteiro para o vetor que usaremos para armazenar os elementos.
        int *vetor;
        // Contagem da quantidade de elementos efetivamente presentes na lista.
        unsigned int tamanho; // FIXME Veja que a correspondência desse valor e do último índice ocupado está incorreta em alguns lugares do código.
        // Contagem do número de índices alocados no vetor "vetor".
        unsigned int capacidade;

    public:
        // Construtores
        vector(unsigned int capacidade);
        vector(unsigned int tamanho, int inicial);

        // Métodos de "Coleção"
        void inserir(int elemento);
        bool remover(int elemento);
        bool pertence(int elemento);

        unsigned int obter_tamanho() { return tamanho; }

        // Métodos de "Lista"
        void inserir_em(unsigned int indice, int elemento);
        bool remover_de(unsigned int indice);

        int obter_elemento_em(unsigned int indice);
        unsigned int obter_indice_de(int elemento);

        // Métodos auxiliares
        unsigned int obter_capacidade() { return capacidade; }
};