// NOTE Em C++, a ocorrência de `const` após o nome de um método indica a promessa
//      de que tal método não irá fazer alterações nas variáveis do objeto e que
//      pode ser chamado em objetos declarados como `const`.

class set {
    private:
        // Ponteiro para o vetor que usaremos para armazenar os elementos.
        int *vetor;
        // Contagem da quantidade de elementos efetivamente presentes na lista.
        unsigned int tamanho;
        // Contagem do número de índices alocados no vetor "vetor".
        unsigned int capacidade;

    public:
        // Construtores
        set(unsigned int capacidade);

        // Métodos de "Coleção"
        bool inserir(int elemento);
        bool remover(int elemento);
        bool pertence(int elemento) const;

        unsigned int obter_tamanho() const { return tamanho; }

        // Métodos de "Conjunto"

        // NOTE Em C++, o "&" antes do nome da variável, neste caso, significa que iremos receber
        //      o outro conjunto por referência. Você não precisa se preocupar com isso, pois
        //      a sintaxe dentro do método funcionará como antes.
        void uniao_com(set const &conjunto);
        void intersecao_com(set const &conjunto);
        bool esta_contido_em(set const &conjunto) const;

        // Métodos auxiliares
        unsigned int obter_capacidade() const { return capacidade; }
};