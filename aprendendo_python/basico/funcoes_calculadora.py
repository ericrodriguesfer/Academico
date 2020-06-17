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