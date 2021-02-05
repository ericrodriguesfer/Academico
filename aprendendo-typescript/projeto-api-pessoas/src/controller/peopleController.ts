import { Request, Response } from 'express';
import { People } from '../models/people';
import peopleBank from '../database/data';

export default {
    async index(_require: Request, _response: Response): Promise<Response> {
        return await _response.json(peopleBank);
    },

    async create(_require: Request, _response: Response): Promise<Response> {
        const newPeople: People = {
            name: _require.body.name,
            email: _require.body.email,
            age: _require.body.age,
            taks: []
        };
    
        peopleBank.push(newPeople);
        return await _response.status(201).json(newPeople);
    },

    async delete(_require: Request, _response: Response): Promise<Response> {
        if ((parseInt(_require.params.id) + 1 )> peopleBank.length) {
            return await _response.status(404).json( {message: "Não foi achado este usuário para deleção!"} );
        }
    
        peopleBank.splice(parseInt(_require.params.id), 1);
        return await _response.status(201).json(peopleBank);
    }
};