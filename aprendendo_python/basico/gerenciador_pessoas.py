banco_pessoas = []
a = True

while a:
    print("1 - adicionar uma pessoa")
    print("2 - remover uma pessoa")
    print("3 - listar as pessoas")
    print("4 - buscar uma pessoa")
    print("5 - atualizar uma pessoa")
    print("6 - sair")
    opcao = int(input())

    if opcao == 1:
        banco_pessoas.append(input("Digite o nome da pessoa: "))
    elif opcao == 2:
        if not banco_pessoas:
            print("Para apagar pessoas, tem que adicionar pessoas!")
        else:
            for indice, pessoa in enumerate(banco_pessoas):
                print(indice, '=', pessoa)
            pessoa_escolha = int(input("Digite o numero da pessoa: "))
            del(banco_pessoas[pessoa_escolha])
    elif opcao == 3:
        if not banco_pessoas:
            print("Para listar pessoas, tem que adicionar pessoas!")
        else:
            for pessoas in banco_pessoas:
                print(pessoas)
    elif opcao == 4:
        if not banco_pessoas:
            print("Para buscar pessoas, tem que adicionar pessoas!")
        else:
            nome_pessoa = input("Digite o nome da pessoa que deseja buscar: ")
            if nome_pessoa in banco_pessoas:
                print("Pessoa encontrada!")
            else:
                print("Pessoa nao encontrada!")
    elif opcao == 5:
        if not banco_pessoas:
            print("Para atualizar pessoas, tem que adicionar pessoas!")
        else:
            for indice, pessoa in enumerate(banco_pessoas):
                print(indice, '=', pessoa)
            pessoa_escolha = int(input("Digite o numero da pessoa: "))
            nome_pessoa = input("Digite o novo nome da pessoa: ")
            banco_pessoas[pessoa_escolha] = nome_pessoa
    elif opcao == 6:
        a = False
    else:
        print("ERRO")
        print("A execucao vai repetir")