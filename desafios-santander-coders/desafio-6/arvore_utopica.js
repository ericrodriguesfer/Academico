function alturaArvoreUtopica(ciclos){
    var altura = 1;

    if(ciclos == 0){
        return altura;
    }else{
        for(var i = 1; i <= ciclos; i++){
            if(i % 2 != 0){
                altura *= 2;
            }else if(i %2 == 0){
                altura += 1;
            }
        }
    }

    return altura;
}