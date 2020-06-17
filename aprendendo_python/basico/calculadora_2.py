def somar(a, b):
    return a + b

def subtrair(a, b):
    return a - b

def dividir(a, b):
    return a / b

def multiplicar(a, b):
    return a * b

print("CALCULADORA BASICA")

a = True

while a:
    a = float(input("Digite o primeiro valor: "))
    b = float(input("Digite o segundo valor: "))

    print("As operacoes sao fornecidas por:")
    print("Digite (1) para soma")
    print("Digite (2) para divisao")
    print("Digite (3) para multiplicacao")
    print("Digite (4) para subtracao")
    oper = int(input("Escolha a operacao:"))

    if oper == 1:
        print(somar(a, b))
    elif oper == 2:
        print(dividir(a, b))
    elif oper == 3:
        print(multiplicar(a, b))
    elif oper == 4:
        print(subtrair(a, b))
    else:
        print("Erro no seu operador!")

    print("Repetir digite (1) para sim e (2) para nao")
    escolha = int(input())

    if escolha == 1:
        a = True
    elif escolha == 2:
        a = False
    else:
        print("ERRO")
        print("A execucao vai repetir")