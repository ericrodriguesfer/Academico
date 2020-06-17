function produto(entrada){
    var resultado = 1;

    for(var i = 0; i < entrada.length; i++){
        resultado *= entrada[i];
    }

    return resultado;
}

produto([10,020,20]);