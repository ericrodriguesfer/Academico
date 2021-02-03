import server from './server/server';

const PORT = 3333;

server.listen(PORT, () => {
  console.log("Server was started in local: http://localhost:3333");
});