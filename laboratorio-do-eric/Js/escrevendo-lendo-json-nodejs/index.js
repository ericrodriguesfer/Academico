const express = require("express");
const handlebars = require("express-handlebars");
const bodyParser = require("body-parser");
const path = require("path");

const PATH = require("./utils/local");
const loadPath = require("./functions/load");
const Person = require("./model/person");
const size = require("./utils/size");
const addPerson = require("./controller/person");
const saveData = require("./functions/save");

const app = express();
const PORT = 3333;
const data = loadPath(PATH);

app.use(express.static(path.join(__dirname, 'public')));

app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

app.engine('handlebars', handlebars({ defaultLayout: 'main' }));

app.set('view engine', 'handlebars');

app.get("/", (require, response) => {
    response.render("home/index", {data: data});
});

app.post("/regiter", (require, response) => {
    Person.id = Number(size() + 1);
    Person.name = require.body.name;
    Person.course = require.body.course;
    Person.age = require.body.age;
    Person.city = require.body.city;
    Person.UF = require.body.uf;

    if (Person.id !== undefined && Person.name !== undefined && Person.course !== undefined && Person.age !== undefined && Person.city !== undefined && Person.UF !== undefined) {
        try {
            addPerson(data, Person);
            
            Person = undefined;

            response.render("home/index", {data: data});
        } catch (error) {
            response.redirect("/");
        }
    } else {
        response.redirect("/");
    }
});

app.get("/delete/:id", (require, response) => {
    let id_delete = require.params.id;

    let new_data_remove = [];

    for (let i = 0; i < size(); i++) {
        if (i !== (id_delete - 1)) {
            new_data_remove.push(data[i]);
        }
    }

    for (let i = 0; i < new_data_remove.length; i++) {
        new_data_remove[i].id = (i + 1);
    }

    saveData(PATH, new_data_remove);

    response.render("home/index", {data: new_data_remove});
});

app.listen(PORT, () => {
    console.log('Aplication was started in localhost:' + PORT);
});