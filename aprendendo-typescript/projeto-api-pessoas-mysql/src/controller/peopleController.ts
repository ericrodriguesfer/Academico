import { Request, Response } from 'express';
import connection from '../database/connection/connection';
import crypto from 'crypto';
import { People } from '../models/people';

export default {
    async index(_require: Request, _response: Response): Promise<Response> {
        const peoples: Array<People> = await connection('peoples').select('*');

        return _response.status(201).json(peoples);
    },

    async create(_require: Request, _response: Response): Promise<Response> {
        const newPeople: People = {
            identification: crypto.randomBytes(4).toString('hex'),
            name: _require.body.name,
            email: _require.body.email,
            age: _require.body.age
        };
        
        await connection('peoples').insert(newPeople);

        return _response.status(201).json(newPeople);
    },

    async delete(_require: Request, _response: Response): Promise<Response> {
        const id_delete = _require.params.id;

        const people: People = await connection('peoples').where('id', id_delete).select('*').first();

        if (!people) {
            return _response.status(404).json( {message: "Não foi achado este usuário para deleção!"} );
        }

        await connection('peoples').where('id', id_delete).delete();
        await connection('tasks').where('people_identification', people.identification).delete();

        return _response.status(201).json(people);
    }
};