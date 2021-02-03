import { Router } from 'express';

const routes = Router();

routes.get("/", (_, response) => {
    response.send("Olá, seja bem vindo!");
});

routes.get("/about", (_, response) => {
    response.send("Sobre nós!");
});

routes.get("/ola/:name", (_, response) => {
    response.send("Seu nome é: " + _.params.name);
});

export default routes;