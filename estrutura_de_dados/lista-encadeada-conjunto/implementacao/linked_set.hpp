class linked_set {
    private:
        class no_encadeado {
            public:
                int valor;
                no_encadeado* proximo;

                no_encadeado(int valor, no_encadeado* proximo = nullptr);

            friend class linked_set;
        };

        no_encadeado* primeiro;
        unsigned int tamanho;

    public:
        linked_set();

        bool inserir(int elemento);
        bool remover(int elemento);
        bool pertence(int elemento) const;

        unsigned int obter_tamanho() const { return tamanho; }

        void uniao_com(linked_set const &conjunto);
        void intersecao_com(linked_set const &conjunto);
        bool esta_contido_em(linked_set const &conjunto) const;

        unsigned int obter_indice_de(int elemento) const;

    protected:
        no_encadeado* obter_no_em(unsigned int indice) const;
        no_encadeado* obter_no_anterior_a(int valor) const;
};