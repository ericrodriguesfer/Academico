print("CALCULADORA BASICA")

a = True

while a:
    a = int(input("Digite num numero: "))
    b = int(input("Digite o segundo numero: "))
    
    print("As operacoes sao fornecidas por:")
    print("Digite (1) para soma")
    print("Digite (2) para divisao")
    print("Digite (3) para multiplicacao")
    print("Digite (4) para subtracao")
    oper = int(input("Escolha a operacao:"))

    if oper == 1:
        print(a + b)
    elif oper == 2:
        print(a / b)
    elif oper == 3:
        print(a * b)
    elif oper == 4:
        print(a - b)
    else:
        print("ERRO")

    print("Repetir digite (1) para sim e (2) para nao")
    b = int(input())

    if b == 1:
        a = True
    elif b == 2:
        a = False
    else:
        print("ERRO")
        print("A execucao vai repetir")