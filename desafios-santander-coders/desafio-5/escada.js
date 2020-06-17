function escada(numero){
    var escadaResultado = [];

    for(var i = 0; i < numero; i++){
        escadaResultado.push(" ".repeat(numero - i - 1) + "#".repeat(i + 1));
    }

    return escadaResultado;
}

console.log(escada(5));