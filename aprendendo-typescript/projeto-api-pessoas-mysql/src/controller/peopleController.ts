import { Request, Response } from 'express';
import crypto from 'crypto';
import connection from '../database/connection/connection';
import existsController from './existsController';
import { People } from '../models/people';

export default {
    async index(_require: Request, _response: Response): Promise<Response> {
        const peoples: Array<People> = await connection('peoples').select('*');

        return _response.status(201).json(peoples);
    },

    async create(_require: Request, _response: Response): Promise<Response> {
        const existsEmail: Boolean = await existsController.existsEmail(String(_require.body.email));

        if (existsEmail) {
            return _response.status(404).json( {message: "Este email já foi cadastrado!"} );
        }

        const newPeople: People = {
            identification: crypto.randomBytes(4).toString('hex'),
            name: _require.body.name,
            email: _require.body.email,
            pass: crypto.createHmac('sha256', _require.body.pass).update('i need security for password of user').digest('hex'),
            age: _require.body.age
        };
        
        await connection('peoples').insert(newPeople);

        return _response.status(201).json(newPeople);
    },

    async update(_require: Request, _response: Response): Promise<Response> {
        const id_update: Number = parseInt(_require.params.id);

        const people: People = await connection('peoples').where('id', id_update).select('*').first();

        if (!people) {
            return _response.status(404).json( {message: "Não foi achado este usuário para atualização!"} );
        }

        if (_require.body.name !== people.name) {
            people.name = _require.body.name;
        }

        if (_require.body.email != people.email) {
            const existsEmail: Boolean = await existsController.existsEmail(String(_require.body.email));

            if (existsEmail) {
                return _response.status(404).json( {message: "Este email já foi cadastrado!"} );
            } else {
                people.email = _require.body.email;
            }
        }

        if (_require.body.age != people.age) {
            people.age = _require.body.age;
        }

        await connection('peoples').where('id', id_update).update('name', people.name).update('email', people.email).update('age', people.age);

        return _response.status(201).json(people);
    },

    async delete(_require: Request, _response: Response): Promise<Response> {
        const id_delete: Number = parseInt(_require.params.id);

        const people: People = await connection('peoples').where('id', id_delete).select('*').first();

        if (!people) {
            return _response.status(404).json( {message: "Não foi achado este usuário para deleção!"} );
        }

        await connection('peoples').where('id', id_delete).delete();
        await connection('tasks').where('people_identification', people.identification).delete();

        return _response.status(201).json(people);
    }
};