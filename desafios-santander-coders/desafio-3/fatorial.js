function fatorial(numero){
    var fatorial  = 1;

    for(var i = numero; i > 0; i--){
        fatorial *= i;
    }

    return fatorial;
}

fatorial(5);