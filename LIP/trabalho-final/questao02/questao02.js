function funcao_1 () {
    var x = 1;

    console.log("fun 1: " + x);

    funcao_2();
    function funcao_2 () {
        var y = 2;

        console.log("fun 2: " + y);
        console.log("fun 2: " + x);

        funcao_3();
        function funcao_3 () {
            var z = 3;

            console.log("fun 3: " + z);
            console.log("fun 3: " + y);
            console.log("fun 3: " + x);
        }
    }
}

funcao_1();