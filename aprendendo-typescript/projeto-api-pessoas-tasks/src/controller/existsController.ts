import connection from '../database/connection/connection';
import { IPeople } from '../models/IPeople';

export default {
    async existsPeople(identification: String): Promise<Boolean> {
        const people: IPeople = await connection('peoples').where('identification', identification).select('*').first();

        if (people) {
            return true;
        }

        return false;
    },

    async existsEmail(email: String): Promise<Boolean> {
        const people: IPeople = await connection('peoples').where('email', email).select('*').first();

        if (people) {
            return true;
        }

        return false;
    }
}