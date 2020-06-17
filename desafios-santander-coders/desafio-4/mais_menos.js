function maisMenos(entrada){
    var resultado = [];
    var tamanho = entrada.length;
    var positivos = 0;
    var negativos = 0;
    var zeros = 0;

    for(var i = 0; i < entrada.length; i++){
        if(entrada[i] > 0){
            positivos++;
        }else if(entrada[i] < 0){
            negativos++;
        }else{
            zeros++;
        }
    }

    resultado.push(positivos / tamanho);
    resultado.push(zeros / tamanho);
    resultado.push(negativos / tamanho);

    return resultado;
}

maisMenos([0,0,0,0]);