const PATH = require("./local");
const loadPath = require("../functions/load");

function getSize () {
    const data = loadPath(PATH);
    const size = data.length;

    return size;
}

module.exports = getSize;