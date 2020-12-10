const files = require("../utils/file");

function loadJSON (file = '') {
    return JSON.parse(files.existsSync(file) ? files.readFileSync(file).toString() : '""');
}

module.exports = loadJSON;