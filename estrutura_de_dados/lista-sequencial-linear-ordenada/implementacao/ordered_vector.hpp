class ordered_vector {
    private:
        int *vetor;
        unsigned int tamanho;
        unsigned int capacidade;

    public:
        ordered_vector(unsigned int capacidade);
        ordered_vector(unsigned int tamanho, int inicial);

        void inserir(int elemento);
        bool remover(int elemento);
        bool pertence(int elemento);

        unsigned int obter_tamanho() { return tamanho; }

        bool remover_de(unsigned int indice);

        int obter_elemento_em(unsigned int indice);
        unsigned int obter_indice_de(int elemento);

        unsigned int obter_capacidade() { return capacidade; }
};