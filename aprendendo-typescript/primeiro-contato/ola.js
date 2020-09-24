var readLineSync = require('readline-sync');
var getLine = function () { return readLineSync.question(); };
function imprime_nome(nome) {
    return "O nome é: " + nome;
}
function retorna_dobro(num) {
    return (num * 2);
}
function fatorial(numero) {
    if (numero == 0) {
        return 1;
    }
    else {
        return numero * fatorial(numero - 1);
    }
}
function achei(nomes, busca) {
    var achamos = false;
    nomes.forEach(function (nome) {
        if (nome === busca) {
            achamos = true;
        }
    });
    return achamos;
}
var nome = "eric";
var nomes = ["eric", "tainara", "teste"];
var numeros = [];
var verdade = true;
var decimal = 6;
console.log(imprime_nome(nome));
console.log(retorna_dobro(2));
console.log(nomes);
verdade ? console.log("Is true!") : console.log("Is false!");
nomes.forEach(function (nome) {
    console.log(nome);
});
console.log("Fatorial de 5: " + fatorial(5));
console.log((achei(nomes, nome) ? "Achamos!" : "Não achamos!"));
console.log(decimal);
for (var i = 0; i < nomes.length; i++) {
    console.log(nomes[i]);
}
while (decimal-- > 0) {
    numeros.push(decimal);
}
numeros.forEach(function (numero) {
    console.log(numero);
});
var Nome = /** @class */ (function () {
    function Nome() {
    }
    Nome.prototype.Nome = function (nome) {
        this.nome = nome;
    };
    Nome.prototype.setnome = function (nome) {
        this.nome = nome;
    };
    Nome.prototype.getnome = function () {
        return this.nome;
    };
    return Nome;
}());
var nomesPessoas = [];
var pessoa = new Nome();
pessoa.setnome("eric");
console.log(pessoa.getnome());
for (var i = 0; i < 5; i++) {
    var nomePessoa = void 0;
    var pessoaNova = new Nome();
    nomePessoa = String(getLine());
    pessoa.setnome(nome);
    nomesPessoas.push(pessoaNova);
}
console.log(nomesPessoas.length);
nomesPessoas.forEach(function (pessoa) {
    console.log(pessoa.getnome());
});
for (var i = 0; i < nomesPessoas.length; i++) {
    console.log(nomesPessoas[i].getnome());
}
