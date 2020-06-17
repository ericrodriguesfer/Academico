function acontece(alunos, quantidadeMinima){
    var permite = 0;

    for(var i = 0; i < alunos.length; i++){
        if(alunos[i] == 0 || alunos[i] < 0){
            permite++;
        }
    }

    return permite == quantidadeMinima || permite > quantidadeMinima ? true : false;
}

function aberturas(alunos, quantidadeMinima){
    var ocorre = [];

    for(var i = 0; i < alunos.length; i++){
        ocorre.push(acontece(alunos[i], quantidadeMinima));
    }

    return ocorre;
}

aberturas([[10, 10, 0], [10, -3, 0], [0, -3, 0]], 2);