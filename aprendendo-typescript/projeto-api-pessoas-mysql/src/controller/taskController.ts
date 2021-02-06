import { Request, Response } from 'express';
import connection from '../database/connection/connection';
import { Task } from '../models/task';

export default {
    async index(_require: Request, _response: Response): Promise<Response> {
        const identification = _require.headers.identification;

        const tasks: Array<Task> = await connection('tasks').where('people_identification', identification).select('*');
    
        return _response.status(201).json(tasks);
    },

    async create(_require: Request, _response: Response): Promise<Response> {
        const newTask: Task = {
            name: _require.body.name,
            action: _require.body.action,
            people_identification: String(_require.headers.identification)
        }

        await connection('tasks').insert(newTask);

        return _response.status(201).json(newTask);
    },

    async delete(_require: Request, _response: Response): Promise<Response> {
        const identification = _require.headers.identification;
        const id_delete = _require.params.id;

        const task: Task = await connection('tasks').where('people_identification', identification).where('id', id_delete).select('*').first();

        if (!task) {
            return _response.status(404).json( {message: "Não foi achado este usuário ou não foi achada a tarefa dele para deleção!"} );
        }
    
        await connection('tasks').where('people_identification', identification).where('id', id_delete).delete();

        return _response.status(201).json(task);
    },

    async clearAll(_require: Request, _response: Response): Promise<Response> {
        const identification = _require.headers.identification;

        const taks: Array<Task> = await connection('tasks').where('people_identification', identification);

        if (taks.length == 0) {
            return _response.status(404).json( {message: "Este usuário não possui tarefas para deleção!"} );
        }
        
        await connection('tasks').where('people_identification', identification).delete();

        return _response.status(201).json( {message: 'Tarefas apagas com sucesso!'} );
    }
};