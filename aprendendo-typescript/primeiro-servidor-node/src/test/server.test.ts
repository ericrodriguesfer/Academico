import requisition from "supertest";
import server from "../server/server";

test("[GET] /", async () => {
  const response = await requisition(server).get("/");
  expect(response.text).toBe("Olá, seja bem vindo!");
});

test("[GET] /about", async () => {
  const response = await requisition(server).get("/about");
  expect(response.text).toBe("Sobre nós!");
});

test("[GET] /", async () => {
  const name_params = "teste";
  const response = await requisition(server).get("/ola/" + name_params);
  expect(response.text).toBe("De volta novamente, doutor " + name_params);
});