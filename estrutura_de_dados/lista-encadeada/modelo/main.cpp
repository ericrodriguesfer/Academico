#include "list.hpp"
#include <iostream>
#include <limits>

using namespace std;

int main() {
    unsigned int comandos;
    
    cin >> comandos;
    
    list l;
    
    while (comandos-- > 0) {
        char acao;
        int elemento;
        unsigned int indice;
        
        cin >> acao;
        
        switch(acao) {
            case 'i':
                cin >> elemento;
                l.inserir(elemento);
                cout << "ok" << endl;
                break;
            case 'r':
                cin >> elemento;
                cout << l.remover(elemento) << endl;
                break;
            case 'b':
                cin >> elemento;
                cout << l.pertence(elemento) << endl;
                break;
            case 't':
                cout << l.obter_tamanho() << endl;
                break;
            case 'I':
                cin >> indice >> elemento;
                l.inserir_em(indice, elemento);
                cout << "ok" << endl;
                break;
            case 'R':
                cin >> indice;
                cout << l.remover_de(indice) << endl;
                break;
            case 'e':
                cin >> elemento;
                indice = l.obter_indice_de(elemento);
                if (indice == std::numeric_limits<unsigned int>::max())
                    cout << "ko" << endl;
                else
                    cout << indice << endl;
                break;
            case 'l':
                cin >> indice;
                elemento = l.obter_elemento_em(indice);
                if (elemento == std::numeric_limits<int>::max())
                    cout << "ko" << endl;
                else
                    cout << elemento << endl;
                break;
        }
    }
    
    return 0;
}