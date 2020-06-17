numeros_1 = []
numeros_2 = []
simetria_listas = []
anti_simetria = []
a = True
b = True

while a:
    numero = int(input("Digite um numero para a lista de numeros um: "))
    numeros_1.append(numero)

    print("Digite (1) para continuar ou (2) para parar de inserir na lista um")
    escolha = int(input())

    if escolha == 1:
        a = a
    elif escolha == 2:
        a = False

while b:
    numero = int(input("Digite um numero para a lista de numeros dois: "))
    numeros_2.append(numero)

    print("Digite (1) para continuar ou (2) para parar de inserir na lista um")
    escolha = int(input())

    if escolha == 1:
        b = b
    elif escolha == 2:
        b = False

tamanho_lista_1 = len(numeros_1)
tamanho_lista_2 = len(numeros_2)

simetria_listas = [x for x in numeros_2 if x in numeros_1]
'''x in conjuntoA and conjuntoB'''

anti_simetria = numeros_1 + numeros_2

for numero in simetria_listas:
    while numero in anti_simetria:
        anti_simetria.remove(numero)

print(anti_simetria)