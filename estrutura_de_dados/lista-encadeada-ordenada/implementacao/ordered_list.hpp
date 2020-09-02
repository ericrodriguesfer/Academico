class ordered_list {
    private:
        class no_encadeado {
            public:
                int valor;
                no_encadeado* proximo;

                no_encadeado(int valor, no_encadeado* proximo = nullptr);

            friend class ordered_list;
        };

        unsigned int tamanho;
        no_encadeado* primeiro;

    public:
        ordered_list();
        ordered_list(unsigned int tamanho, int inicial);

        void inserir(int elemento);
        bool remover(int elemento);
        bool pertence(int elemento);

        unsigned int obter_tamanho() { return tamanho; }

        bool remover_de(unsigned int indice);

        int obter_elemento_em(unsigned int indice);
        unsigned int obter_indice_de(int elemento);

    protected:
        no_encadeado* obter_no_em(unsigned int indice);
        no_encadeado* obter_no_anterior_a(int valor);
};