# Jogo da Forca

Aqui está implementado por mim a minha resolução a esta atividade de revisão de Java e Orientação a Objetos, com o intuíto de implementarmos o jogo com a separação máxima de responsabilidade entre as entidades envolvidas no jogo.

## Funcionamento do jogo

O jogo se dá em um jogo da forca comum, onde ele funciona com base em uma _base de dados_ de palavras, palavras essas previamente cadastradas, onde a _base de dados_ de palavras se encontra no pacote "package" _br.com.eric.pds.utils_, ao adicionar palavras, as separe por um "@", como pode ser visto no estado atual do arquivo, tendo as suas palavras de escolha na _base de dados_, sempre que iniciada uma partida, um das palavras presente no arquivo de [_words.in_](https://github.com/ericrodriguesfer/Academico/blob/master/PDS/forca/src/br/com/eric/pds/utils/words.in) será sorteada e essa palavra sorteada será a palavra a qual o usuário terá que tentar descobrir.

# Sumário da sessão de PDS:

1. Descrição da atividade:
   * [Documento pdf de descrição](https://github.com/ericrodriguesfer/Academico/blob/master/PDS/forca/descricao-trabalho/descricao-trabalho.pdf)

2. Implementação:
   * [Implementação do jogo](https://github.com/ericrodriguesfer/Academico/tree/master/PDS/forca/src/br/com/eric/pds)

## Diagrama de Classes do Jogo

![Diagrama de Classes](https://github.com/ericrodriguesfer/Academico/blob/master/PDS/forca/diagramas/Class.png)

## Diagrama de Sequencia do Jogo

![Diagrama de Sequencia](https://github.com/ericrodriguesfer/Academico/blob/master/PDS/forca/diagramas/Sequence.png)
