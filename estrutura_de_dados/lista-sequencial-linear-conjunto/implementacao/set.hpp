class set {
    private:
        int *vetor;
        unsigned int tamanho;
        unsigned int capacidade;

    public:
        set(unsigned int capacidade);

        bool inserir(int elemento);
        bool remover(int elemento);
        bool pertence(int elemento) const;

        unsigned int obter_tamanho() const { return tamanho; }

        void uniao_com(set const &conjunto);
        void intersecao_com(set const &conjunto);
        bool esta_contido_em(set const &conjunto) const;

        unsigned int obter_capacidade() const { return capacidade; }
};