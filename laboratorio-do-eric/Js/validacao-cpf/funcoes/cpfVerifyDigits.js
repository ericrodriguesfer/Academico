var cpfVerifyDigits = function (cpf){
    let containerLetter = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"];

    for(let i = 0; i < cpf.length; i++){
        for(let j = 0; j < containerLetter.length; j++){
            if(cpf[i] === containerLetter[j]){
                return false;
            }
        }
    }

    return true;
}

module.exports = cpfVerifyDigits;