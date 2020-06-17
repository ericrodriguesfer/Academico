import math

def somar(a, b):
    return a + b

def subtrair(a, b):
    return a - b

def dividir(a, b):
    return a / b

def multiplicar(a, b):
    return a * b

def raiz(a):
    return math.sqrt(a)

def quadrado_perfeito(a):
    return math.pow(a, 2)

def cubo_perfeito(a):
    return math.pow(a, 3)

def maior(a, b):
    if a > b:
        return a
    elif a < b:
        return b
    else:
        print("Sao iguais")

def menor(a, b):
    if a < b:
        return a
    elif a > b:
        return b
    else:
        print("Sao iguais")

def maior_menor_lista(*a):
    b = []
    b.append(max(a))
    b.append(min(a))

    return b

def soma_lista(*a):
    b = 0
    for numeros in a:
        b += numeros

    return b

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

        print(somar(a, b))
    elif oper == 2:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(dividir(a, b))
    elif oper == 3:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(multiplicar(a, b))
    elif oper == 4:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(subtrair(a, b))
    elif oper == 5:
        a = float(input("Digite o numero: "))

        print(raiz(a))
    elif oper == 6:
        a = float(input("Digite o numero: "))

        print(quadrado_perfeito(a))
    elif oper == 7:
        a = float(input("Digite o numero: "))

        print(cubo_perfeito(a))
    elif oper == 8:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(maior(a, b))
    elif oper == 9:
        a = float(input("Digite o primeiro numero: "))
        b = float(input("Digite o segundo numero: "))

        print(menor(a, b))
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

        c = c + maior_menor_lista(*a)

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
        
        print(soma_lista(*a))
    elif oper == 12:
        a = False
    else:
        print("ERRO")
        print("A execucao vai repetir")