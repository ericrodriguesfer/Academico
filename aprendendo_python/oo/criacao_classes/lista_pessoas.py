from pessoa import Pessoa

pessoas = []
a = True

while a:
    nome = input("Digite o nome da pessoa: ")
    idade = int(input("Digite a idade da pessoa: "))
    ser_humano = Pessoa(nome, idade)

    pessoas.append(ser_humano)

    escolha = int(input("Digite (1) p/ parar de adicionar pessos, outro valor para continuar: "))

    if escolha == 1:
        a = False
    else:
        a = a

for seres in pessoas:
    print(seres)
