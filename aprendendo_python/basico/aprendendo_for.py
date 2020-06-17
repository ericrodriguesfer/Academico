numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
alunos = ['eric', 'teste', 'joao', 'lucas']
nome = "eric"

for nomes in alunos:
    print(nomes, end=', ')

print()

for numero in numeros:
    print(numero, end=', ')

print()

for letras in nome:
    print(letras, end=', ')

print()
print("Quadrado dos numeros")

for numero in numeros:
    print(numero, '*', numero, '=', numero*numero)