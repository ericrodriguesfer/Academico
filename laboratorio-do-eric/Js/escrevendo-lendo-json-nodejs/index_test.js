const getLine = require("./utils/read");
const PATH = require("./utils/local");
const loadPath = require("./functions/load");
const savePath = require("./functions/save");
const readPerson = require("./view/person");

const REPEAT = true;
const data = loadPath(PATH);

while (REPEAT) {
    console.log("1 - Adicionar uma pessoa");
    console.log("2 - Exibir a lista de pessoas");
    let choose = Number(getLine());

    switch (choose) {
        case 1: {
            data.push(readPerson());
            savePath(PATH, data);

            break;
        }

        case 2: {
            data.forEach(person => {
                console.log("\n");
                console.log(person);
            });
            
            break;
        }

        default: {
            break;
        }
    }
}