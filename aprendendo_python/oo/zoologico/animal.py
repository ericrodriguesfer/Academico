class Animal:
    def __init__(self, identificador, nome, especie):
        self._identificador = identificador
        self._nome = nome
        self._especie = especie

    def setIdentificador(self, identificador):
        self._identificador = identificador

    def getIdentificador(self):
        return self._identificador

    def setNome(self, nome):
        self._nome = nome

    def getNome(self):
        return self._nome

    def setEspecie(self, especie):
        self._especie = especie

    def getEspecie(self):
        return self._especie

    def andar(self):
        print("Animal esta andando!")

    def comer(self):
        print("Animal esta comendo!")

    def dormir(self):
        print("Animal esta dormindo!")

    def __str__(self):
        retorno = "Id: " + str(self.getIdentificador())
        retorno += "\nNome: " + self.getNome()
        retorno += "\nEspecie: " + self.getEspecie() 

        return retorno