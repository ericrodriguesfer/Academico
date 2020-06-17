from pessoa import Pessoa

eric = Pessoa("eric", 18)
lucas = Pessoa("Lucas", 22)

print(eric.getNome(), '', eric.getIdade())

eric.setIdade(12)

print(lucas.getNome())
print(eric.getNome(), '', eric.getIdade())

eric.envelhecer()

print (eric)
print (lucas)