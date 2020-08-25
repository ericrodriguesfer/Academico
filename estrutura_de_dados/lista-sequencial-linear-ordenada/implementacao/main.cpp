#include "ordered_vector.hpp"
#include <iostream>
#include <limits>

using namespace std;

int main() {
    unsigned int capacidade;
    unsigned int comandos;
    
    cin >> capacidade >> comandos;
    
    ordered_vector v(capacidade);
    
    while (comandos-- > 0) {
        char acao;
        int elemento;
        unsigned int indice;
        
        cin >> acao;
        
        switch(acao) {
            case 'i':
                cin >> elemento;
                v.inserir(elemento);
                cout << "ok" << endl;
                break;
            case 'r':
                cin >> elemento;
                cout << v.remover(elemento) << endl;
                break;
            case 'b':
                cin >> elemento;
                cout << v.pertence(elemento) << endl;
                break;
            case 't':
                cout << v.obter_tamanho() << endl;
                break;
            case 'c':
                cout << (v.obter_capacidade() >= v.obter_tamanho()) << endl;
                break;
            case 'R':
                cin >> indice;
                cout << v.remover_de(indice) << endl;
                break;
            case 'e':
                cin >> elemento;
                indice = v.obter_indice_de(elemento);
                if (indice == std::numeric_limits<unsigned int>::max())
                    cout << "ko" << endl;
                else
                    cout << indice << endl;
                break;
            case 'l':
                cin >> indice;
                elemento = v.obter_elemento_em(indice);
                if (elemento == std::numeric_limits<int>::max())
                    cout << "ko" << endl;
                else
                    cout << elemento << endl;
                break;
        }
    }
    
    return 0;
}