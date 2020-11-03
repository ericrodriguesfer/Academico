var cpfVerifySecondDigit = function (cpf){
    let sumOperatorDigits = 0;
    let j = 11;

    for(let i = 0; i < (cpf.length - 1); i++){
        sumOperatorDigits += parseInt(cpf[i]) * j;
        j--;
    }

    return sumOperatorDigits;
}

module.exports = cpfVerifySecondDigit;