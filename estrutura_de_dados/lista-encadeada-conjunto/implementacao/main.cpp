#include "linked_set.hpp"
#include <iostream>
#include <limits>

using namespace std;

int main() {
    unsigned int comandos;
    
    cin >> comandos;
    
    linked_set v;
    linked_set u;
    
    while (comandos-- > 0) {
        char acao, conjunto;
        int elemento;
        linked_set *alvo, *outro;
        
        cin >> acao >> conjunto;
        
        if(conjunto == 'u') {
            alvo  = &u;
            outro = &v;
        } else {
            alvo  = &v;
            outro = &u;
        }
        
        switch(acao) {
            case 'i':
                cin >> elemento;
                cout << alvo->inserir(elemento) << endl;
                break;
            case 'r':
                cin >> elemento;
                cout << alvo->remover(elemento) << endl;
                break;
            case 'p':
                cin >> elemento;
                cout << alvo->pertence(elemento) << endl;
                break;
            case 't':
                cout << alvo->obter_tamanho() << endl;
                break;
            case 'U':
                alvo->uniao_com(*outro);
                cout << "ok" << endl;
                break;
            case 'I':
                alvo->intersecao_com(*outro);
                cout << "ok" << endl;
                break;
            case 'S':    
                cout << alvo->esta_contido_em(*outro) << endl;
                break;
        }
    }
    
    return 0;
}