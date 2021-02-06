import { Request, Response } from 'express';
import { Task } from '../models/task';
import peopleBank from '../database/data';

export default {
    async index(_require: Request, _response: Response): Promise<Response> {
        if ((parseInt(_require.params.id) + 1 ) > peopleBank.length) {
            return await _response.status(404).json( {message: "Não foi achado este usuário para lista suas tarefas!"} );
        }
    
        return await _response.status(201).json(peopleBank[parseInt(_require.params.id)].taks);
    },

    async create(_require: Request, _response: Response): Promise<Response> {
        const newTask: Task = {
            name: _require.body.name,
            action: _require.body.action
        }

        if ((parseInt(_require.params.id) + 1) > peopleBank.length) {
            return await _response.status(404).json( {message: "Não foi achado este usuário para cadastrar sua tarefas!"} );
        }
    
        peopleBank[parseInt(_require.params.id)].taks.push(newTask);
        return await _response.status(201).json(newTask);
    },

    async delete(_require: Request, _response: Response): Promise<Response> {
        if ((parseInt(_require.params.id_p) + 1) > peopleBank.length || (parseInt(_require.params.id_t) + 1) > peopleBank[parseInt(_require.params.id_p)].taks.length) {
            return await _response.status(404).json( {message: "Não foi achado o usuário ou não foi achado a tarefa do usuário!"} );
        }
    
        peopleBank[parseInt(_require.params.id_p)].taks.splice(parseInt(_require.params.id_t), 1);
        return await _response.status(201).json(peopleBank[parseInt(_require.params.id_p)]);
    },

    async clear(_require: Request, _response: Response): Promise<Response> {
        if ((parseInt(_require.params.id) + 1) > peopleBank.length) {
            return await _response.status(404).json( {message: "Não foi achado este usuário para a deleção de suas tarefas!"} );
        }
    
        peopleBank[parseInt(_require.params.id)].taks = [];
        return await _response.status(201).json(peopleBank[parseInt(_require.params.id)]);
    }
};