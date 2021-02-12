import { Request, Response } from 'express';
import jwt from 'jsonwebtoken';
import connection from '../database/connection/connection';
import secretToken from '../config/secretToken';
import existsController from './existsController';
import creteHashs from '../utils/createHashs';
import { storage } from '../config/storage';
import { IPeople } from '../models/IPeople';
import { IPeopleAuth } from '../models/IPeopleAuth';
import { IPeopleLogin } from '../models/IPeopleLogin';

export default {
    async login(_require: Request, _response: Response): Promise<Response> {
        const peopleLogin: IPeopleLogin = {
            email: _require.body.email,
            pass: _require.body.pass
        };

        const login: IPeople = await connection('peoples').where('email', peopleLogin.email).select('*').first();

        if (login) {
            if (String(await creteHashs.createPass(peopleLogin.pass)) == login.pass) {
                const token: string = jwt.sign( { id: login.identification }, String(secretToken.index), {
                    expiresIn: "1d"
                });

                const peopleLogon: IPeopleAuth = {
                    identification: login.identification,
                    name: login.name,
                    email: login.email,
                    token
                };

                storage.setItem("token", token);

                return _response.status(201).json(peopleLogon);
            } else {
                return _response.status(404).json( {message: "A senha deste usuário está incorreta!"} );
            }
        }

        return _response.status(404).json( {message: "Este usuário não foi encontrado!"} );
    },

    async logout(_require: Request, _response: Response): Promise<Response> {
        const authHeader: any = _require.headers.authorization;

        if (!authHeader) {
            return _response.status(404).json( {message: "Você já está deslogado!"} );
        }

        const token = authHeader.split(" ");

        if (token[1] == storage.getItem("token")) {
            storage.clear();
            return _response.status(201).json( {message: "Deslogado com sucesso!"} );
        }

        return _response.status(201).json( {message: "Erro ao efetuar seu logout!"} );
    },

    async index(_require: Request, _response: Response): Promise<Response> {
        const peoples: Array<IPeople> = await connection('peoples').select('*').orderBy('id');

        return _response.status(201).json(peoples);
    },

    async create(_require: Request, _response: Response): Promise<Response> {
        const existsEmail: Boolean = await existsController.existsEmail(String(_require.body.email));

        if (existsEmail) {
            return _response.status(404).json( {message: "Este email já foi cadastrado!"} );
        }

        const newPeople: IPeople = {
            identification: String(await creteHashs.createIdentification()),
            name: _require.body.name,
            email: _require.body.email,
            pass: String(await creteHashs.createPass(_require.body.pass)),
            age: _require.body.age
        };
        
        await connection('peoples').insert(newPeople);

        return _response.status(201).json(newPeople);
    },

    async update(_require: Request, _response: Response): Promise<Response> {
        const id_update: Number = parseInt(_require.params.id);

        const people: IPeople = await connection('peoples').where('id', id_update).select('*').first();

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

        const people: IPeople = await connection('peoples').where('id', id_delete).select('*').first();

        if (!people) {
            return _response.status(404).json( {message: "Não foi achado este usuário para deleção!"} );
        }

        await connection('peoples').where('id', id_delete).delete();
        await connection('tasks').where('people_identification', people.identification).delete();

        return _response.status(201).json(people);
    }
};