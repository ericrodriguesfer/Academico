import knex from 'knex';
import dbConfig from '../config/knexfile';

const connection = knex(dbConfig.development);

export default connection;