import knex from 'knex';

const connection = knex({
    client: 'mysql',
    connection: {
        host: 'localhost',
        user: 'root',
        password: '',
        database: 'people-tasks'
    },
    migrations: {
        directory: './src/database/migrations'
    },
    useNullAsDefault: true
});

export default connection;