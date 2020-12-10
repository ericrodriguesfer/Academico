const PATH = require("./utils/local");
const loadPath = require("./functions/load");
const readPerson = require("./view/person");

const data = loadPath(PATH);

readPerson(data);

data.forEach(person => {
    console.log("\n");
    console.log(person);
});