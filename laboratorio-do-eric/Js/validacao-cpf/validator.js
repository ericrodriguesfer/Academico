var readLineSync = require('readline-sync');
var getLine = () => readLineSync.question();

var clearCpf = require("./funcoes/clearCpf");
var cpfCountDigit = require("./funcoes/cpfCountDigit");
var cpfVerifyDigits = require("./funcoes/cpfVerifyDigits");
var cpfVerifyFirstDigit = require("./funcoes/cpfVerifyFirstDigit");
var cpfVerifySecondDigit = require("./funcoes/cpfVerifySecondDigit");

var cpf = String(getLine());
var containerCpfGeneric = ["00000000000", "11111111111", "22222222222", "33333333333", "44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999"];
var cpfGeneric = false;

while(cpf === ""){
    console.log("Digite um CPF para prosseguir!");
    cpf = String(getLine());
}

var cpfClean = clearCpf(cpf);

if(cpfCountDigit(cpfClean) != 11){
    console.log("Formato de CPF que foi repassado é incorreto! Não há 11 caracteres");
    
    while(cpfCountDigit(clearCpf(cpf)) != 11){
        console.log("Digite novamente um CPF para prosseguir!");
        cpf = String(getLine());
    }
}else{
    console.log("Formato do CPF que foi repassado é correto! Há os 11 caracteres");
}

cpfClean = cpf;

if(cpfVerifyDigits(cpfClean) != true){
    console.log("Um CPF só pode conter digitos númericos!");

    while(cpfVerifyDigits(cpf) != true){
        console.log("Digite novamente um CPF para prosseguir!");
        cpf = String(getLine());

        while(cpfCountDigit(clearCpf(cpf)) != 11){
            console.log("Digite novamente um CPF para prosseguir!");
            cpf = String(getLine());
        }

        cpf = clearCpf(cpf);
    }
}

cpfClean = clearCpf(cpf);

var fisrtDigit = (cpfVerifyFirstDigit(cpfClean) * 10) % 11;
var secondDigit = (cpfVerifySecondDigit(cpfClean) * 10) % 11;

for(let i = 0; i < containerCpfGeneric.length; i++){
    if(cpfClean === containerCpfGeneric[i]){
        cpfGeneric = true;
    }
}

if(cpfGeneric === false){
    if(fisrtDigit === parseInt(cpfClean[9])){
        if(secondDigit === parseInt(cpfClean[10])){
            console.log("O CPF repassado está válidado");
        }else{
            console.log("CPF repassado não está válidado!");
        }
    }else{
        console.log("CPF repassado não está válidado!");
    }
}else{
    console.log("CPF repassado não está válidado!");
}