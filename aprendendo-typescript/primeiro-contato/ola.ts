var readLineSync = require('readline-sync');
let getLine = () => readLineSync.question();

function imprime_nome(nome: string): string {
    return "O nome é: " + nome;
}

function retorna_dobro (num: number): number {
    return (num * 2);
}

function fatorial (numero: number): number {
    if (numero == 0) {
        return 1;
    } else {
        return numero * fatorial(numero - 1);
    }
}

function achei (nomes: Array<string>, busca: string): boolean {
    let achamos: boolean = false;

    nomes.forEach(nome => {
        if (nome === busca) {
            achamos = true;
        }
    });

    return achamos;
}

let nome: string = "eric";
let nomes: Array<string> = ["eric", "tainara", "teste"];
let numeros: Array<number> = [];
let verdade: boolean = true;
let decimal: number = 6;

console.log(imprime_nome(nome));
console.log(retorna_dobro(2));
console.log(nomes);
verdade ? console.log("Is true!") : console.log("Is false!");

nomes.forEach(nome => {
    console.log(nome);
});

console.log("Fatorial de 5: " + fatorial(5));

console.log((achei(nomes, nome) ? "Achamos!" : "Não achamos!"));
console.log(decimal);

for (let i: number = 0; i < nomes.length; i++) {
    console.log(nomes[i]);
}

while (decimal-- > 0) {
    numeros.push(decimal);
}

numeros.forEach(numero => {
    console.log(numero);
});

class Nome {
    private nome: string;

    public Nome (nome: string): void {
        this.nome = nome;
    }

    public setnome (nome: string): void {
        this.nome = nome;
    }

    public getnome (): string {
        return this.nome;
    }
}

let nomesPessoas: Array<Nome> = [];

let pessoa: Nome = new Nome();
pessoa.setnome("eric");
console.log(pessoa.getnome());

for (let i: number = 0; i < 5; i++) {
    let nomePessoa: string;
    let pessoaNova: Nome = new Nome();
    
    nomePessoa = String(getLine());

    pessoa.setnome(nome);

    nomesPessoas.push(pessoaNova);
}

console.log(nomesPessoas.length);

nomesPessoas.forEach(pessoa => {
    console.log(pessoa.getnome());
})

for (let i: number = 0; i < nomesPessoas.length; i++) {
    console.log(nomesPessoas[i].getnome());
}