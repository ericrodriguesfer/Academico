const PATH = require("../utils/local");
const savePath = require("../functions/save");

function addPerson (data, person) {
    data.push(person);
    savePath(PATH, data);
}

module.exports = addPerson;