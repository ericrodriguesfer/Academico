const files = require("../utils/file");

function saveJSON (file = '', json = '""') {
    return files.writeFileSync(file, JSON.stringify(json, null, 2));
}

module.exports = saveJSON;