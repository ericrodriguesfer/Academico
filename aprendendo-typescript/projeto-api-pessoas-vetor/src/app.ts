import server from './server/server';

const PORT : number = 3333;

server.listen(PORT, () => {
    console.log("Server was started in: http://localhost:3333");
});