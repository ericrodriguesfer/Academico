const getLine = require("../utils/read");
const Person = require("../model/person");
const size = require("../utils/size");

function readPerson () {
    Person.id = Number(size() + 1);

    console.log("Digite o nome da pessoa: ");
    Person.name = String(getLine());

    console.log("Digite o curso da pessoa: ");
    Person.course = String(getLine());

    console.log("Digite a idade da pessoa: ");
    Person.age = Number(getLine());

    console.log("Digite a cidade da pessoa: ");
    Person.city = String(getLine());

    console.log("Digite o UF da pessoa: ");
    Person.UF = String(getLine());

    return Person;
}

module.exports = readPerson;