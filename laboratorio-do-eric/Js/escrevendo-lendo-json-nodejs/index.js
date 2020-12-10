const PATH = require("./utils/local");
const loadPath = require("./functions/load");
const readPerson = require("./view/person");
const addPerson = require("./controller/person");

const data = loadPath(PATH);

addPerson(data, readPerson());

data.forEach(person => {
    console.log("\n");
    console.log(person);
});