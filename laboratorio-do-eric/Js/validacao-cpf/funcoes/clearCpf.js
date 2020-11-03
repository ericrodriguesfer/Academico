var clearCpf = function (cpf){
    let cpfVerificatonSequence = cpf.split(".");
    let cpfVerificatonDigit = cpfVerificatonSequence[2].split("-");
    let cpfResultAnalyze = cpfVerificatonSequence[0] + cpfVerificatonSequence[1] + cpfVerificatonDigit[0] + cpfVerificatonDigit[1];

    return cpfResultAnalyze;
}

module.exports = clearCpf;