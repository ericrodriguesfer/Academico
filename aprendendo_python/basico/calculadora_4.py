import funcoes_calculadora

print("#########CALCULADORA BASICA#########")
print()

a = True

while a:
    print("As operacoes sao fornecidas por:")
    print("Digite (1) para soma")
    print("Digite (2) para divisao")
    print("Digite (3) para multiplicacao")
    print("Digite (4) para subtracao")
    print("Digite (5) para raiz quadrada")
    print("Digite (6) para quadrado perfeito")
    print("Digite (7) para cubo perfeito")
    print("Digite (8) para buscar maior")
    print("Digite (9) para buscar menor")
    print("Digite (10) para buscar maior e menor em uma lista")
    print("Digite (11) para somar os elementos de uma lista")
    print("Digite (12) para sair")
    oper = int(input("Escolha a operacao:"))

    if oper == 1:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(funcoes_calculadora.somar(a, b))
    elif oper == 2:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(funcoes_calculadora.dividir(a, b))
    elif oper == 3:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(funcoes_calculadora.multiplicar(a, b))
    elif oper == 4:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(funcoes_calculadora.subtrair(a, b))
    elif oper == 5:
        a = float(input("Digite o numero: "))

        print(funcoes_calculadora.raiz(a))
    elif oper == 6:
        a = float(input("Digite o numero: "))

        print(funcoes_calculadora.quadrado_perfeito(a))
    elif oper == 7:
        a = float(input("Digite o numero: "))

        print(funcoes_calculadora.cubo_perfeito(a))
    elif oper == 8:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(funcoes_calculadora.maior(a, b))
    elif oper == 9:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(funcoes_calculadora.menor(a, b))
    elif oper == 10:
        a = []
        c = []
        b = True

        while b:
            a.append(float(input("Adicone um numero a lista: ")))

            print("Repetir digite (1) para sim e (2) para nao")
            escolha = int(input())

            if escolha == 1:
                b = b
            elif escolha == 2:
                b = False
            else:
                print("ERRO")
                print("A execucao vai repetir")

        c = c + funcoes_calculadora.maior_menor_lista(*a)

        print("maior = ", max(c))
        print("menor = ", min(c))
    elif oper == 11:
        a = []
        b = True

        while b:
            a.append(float(input("Adicone um numero a lista: ")))

            print("Repetir digite (1) para sim e (2) para nao")
            escolha = int(input())

            if escolha == 1:
                b = b
            elif escolha == 2:
                b = False
            else:
                print("ERRO")
                print("A execucao vai repetir")

        print(funcoes_calculadora.soma_lista(*a))
    elif oper == 12:
        a = False
    else:
        print("ERRO")
        print("A execucao vai repetir")
