export default {
  development: {
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
  }
};
