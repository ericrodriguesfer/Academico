nomes = []
a = True

while a:
    nomes.append(input("Digite um nome: "))

    print("Deseja continuar adicionando nomes: (1) para sim, (2) para nao")
    escolha = int(input())

    if escolha == 1:
        a = a
    elif escolha == 2:
        a = False
    else:
        print("Como nenhuma acao foi selecionada, ira voltar a insercacao de nomes!")

for nome in nomes:
    print(nome, end=', ')

print()
for indice, nome in enumerate(nomes):
    print(indice, '=', nome)