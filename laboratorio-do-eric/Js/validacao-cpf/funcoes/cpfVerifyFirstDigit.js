var cpfVerifyFirstDigit = function (cpf){
    let sumOperatorDigits = 0;
    let j = 10;

    for(let i = 0; i < (cpf.length - 2); i++){
        sumOperatorDigits += parseInt(cpf[i]) * j;
        j--;
    }
    
    return sumOperatorDigits;
}

module.exports = cpfVerifyFirstDigit;