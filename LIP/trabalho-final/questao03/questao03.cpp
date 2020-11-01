/*
    Explicação a respeito da questão 03:

    Considerações iniciais, como é uma questão para afetuarmos a medição de tempo de execução a arquitetura da máquina
    em uso exerce determinada influência nos resultados, mas vamos lá. No inicio da tentativa de resolução da questão eu comecei usando vetores de tamanho 100 e depois 1000, mas mesmo assim
    ainda eram pequenos demais para realizar uma análise, os coloquei em tamanho 10000, ai sim eu tive margem de análise e etc. Para ter ainda mais precisão na avaliaçã,eu não só criei o vetor como o populei também, para assim ja termos o que obeservar
    a respeito das operação em cada caso. A diferença entre cada um dos três tipos de vetores criados, análisando com base
    em tempo de execução da função pedida, o que pode ser notado é que a criação e as operações no vetor estático ela é bem mais
    rápida quando comparada com as outrass duas, pois a criação estática é realizada com o SO disponibilizando o espaço pedido
    para uso, isso no inicio da execução do código, sem poder dar mais controle sobre ele, controle que só é permitido a inserção e o resgate de valores, como sendo 
    só essas operações em uma estrutura estática elas acontecem de maneira mais rápida. Quando vamos para a análise do vetor em pilha
    temos o mesmo fundamento da análise passada do vetor estático, mas com a diferença de que ele não pe criado assim que o código é
    executado, pois ele por ser de pilha, só irá ser criado no memento em que a execução do código passar pela chamada de criação dele,
    sendo muito semelhante em relação as operações, mas como ele é criado em tempo de execução e posto na pilha de execução as operações possíveis
    de serem realizadas no mesmo, são um pouco menos rápida que no estático. Agora falando de criar um vetor no monte, já temos um processo
    mais delicado de análisar, a criação do mesmo diferente dos dois anteriores que a função de criar e exercer controle é totalmente do SO, nesse
    caso do monte não, quem programa tem total responsabilidade sob esta operação, desde a criação, tal como: tamanho do vetor, tipo, como ele ficará disposto na memória
    e etc, estando tudo a cargo de quem está programando, tanto com criar, extender ou diminuir e inclusive o eliminar em caso de desuso, e tendo seu acesso totalmente
    por ponteiros ou aritimética dos mesmos, todas as operações possíveis de serem realizadas são um pouco menos rápida que no caso de pilha, pois todo
    acesso se dá por referências diretas de endereços de memória.

    Segue abaixo as médias de tempo de execução em segundos, para ambos os casos:
        > com vetores de tamanho 10000
        > sendo executado 100000 vezes
    
    Media estatica: 0.0240625000
    Media pilha: 0.0251562500
    Media monte: 0.0301562500

    Aqui podemos notar a diferença de tempo de execução citada na análise.
*/

#include <iostream>
#include <cstdlib>
#include <iomanip>
#include <ctime>

using namespace std;

void cria_vetor_estatico () {
    static int vetor[10000];

    for (unsigned int i = 0; i < 10000; i++) {
        vetor[i] = (i + 1);
    }
}

void cria_vetor_pilha () {
    int vetor[10000];

    for (unsigned int i = 0; i < 10000; i++) {
        vetor[i] = (i + 1);
    }
}

void cria_vetor_monte () {
    int *vetor = (int*) malloc (sizeof(int) * 10000);

    for (unsigned int i = 0; i < 10000; i++) {
        vetor[i] = (i + 1);
    }

    free(vetor);
}

int main () {
    clock_t inicio, fim;
    double tempo_decorrido_estatico, tempo_decorrido_pilha, tempo_decorrido_monte;
    double tempo_decorrido_estatico_media, tempo_decorrido_pilha_media, tempo_decorrido_monte_media;
    double *tempo_decorrido_estatico_valores = new double[100000];
    double *tempo_decorrido_pilha_valores = new double[100000];
    double *tempo_decorrido_monte_valores = new double[100000];

    cout << "Vetor estatico" << endl;

    for (unsigned int i = 0; i < 100000; i++) {
        inicio = clock();

        cria_vetor_estatico();

        fim = clock();

        tempo_decorrido_estatico = 1000.0 * double(fim - inicio) / CLOCKS_PER_SEC;

        cout << "Tempo decorrido: " << tempo_decorrido_estatico << fixed << setprecision(10) << endl;

        tempo_decorrido_estatico_valores[i] = tempo_decorrido_estatico;
    }

    cout << "Vetor pilha" << endl;
    
    for (unsigned int i = 0; i < 100000; i++) {
        inicio = clock();

        cria_vetor_pilha();

        fim = clock();

        tempo_decorrido_pilha = 1000.0 * double(fim - inicio) / CLOCKS_PER_SEC;

        cout << "Tempo decorrido: " << tempo_decorrido_pilha << fixed << setprecision(10) << endl;

        tempo_decorrido_pilha_valores[i] = tempo_decorrido_pilha;
    }

    cout << "Vetor monte" << endl;
    
    for (unsigned int i = 0; i < 100000; i++) {
        inicio = clock();

        cria_vetor_monte();

        fim = clock();

        tempo_decorrido_monte = 1000.0 * double(fim - inicio) / CLOCKS_PER_SEC;

        cout << "Tempo decorrido: " << tempo_decorrido_monte << fixed << setprecision(10) << endl;

        tempo_decorrido_monte_valores[i] = tempo_decorrido_monte;
    }

    for (unsigned int i = 0; i < 100000; i++) {
        tempo_decorrido_estatico_media += tempo_decorrido_estatico_valores[i];
        tempo_decorrido_pilha_media += tempo_decorrido_pilha_valores[i];
        tempo_decorrido_monte_media += tempo_decorrido_monte_valores[i];
    }

    tempo_decorrido_estatico_media = (tempo_decorrido_estatico_media / 100000);
    tempo_decorrido_pilha_media = (tempo_decorrido_pilha_media / 100000);
    tempo_decorrido_monte_media = (tempo_decorrido_monte_media / 100000);

    cout << "Media estatica: " << tempo_decorrido_estatico_media << fixed << setprecision(10) << endl;
    cout << "Media pilha: " << tempo_decorrido_pilha_media << fixed << setprecision(10) << endl;
    cout << "Media monte: " << tempo_decorrido_monte_media << fixed << setprecision(10) << endl;

    delete[] tempo_decorrido_estatico_valores;
    delete[] tempo_decorrido_pilha_valores;
    delete[] tempo_decorrido_monte_valores;

    return 0;
}