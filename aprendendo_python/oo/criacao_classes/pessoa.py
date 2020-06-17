class Pessoa:
    def __init__(self, nome, idade):
        self._nome = nome
        self._idade = idade

    def setNome(self, nome):
        self._nome = nome

    def getNome(self):
        return self._nome

    def setIdade(self, idade):
        self._idade = idade

    def getIdade(self):
        return self._idade

    def envelhecer(self):
        self.setIdade(self.getIdade() + 1)
        
    def __str__(self):
        retorno = "Nome: " + self.getNome()
        retorno += "\nIdade: " + str(self.getIdade())

        return retorno
