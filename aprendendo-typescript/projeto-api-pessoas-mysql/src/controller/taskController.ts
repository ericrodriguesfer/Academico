import { Request, Response } from 'express';
import connection from '../database/connection/connection';
import existsController from './existsController';
import { Task } from '../models/task';

export default {
    async index(_require: Request, _response: Response): Promise<Response> {
        const identification: String = String(_require.headers.identification);

        const existsUser: Boolean = await existsController.existsPeople(identification);

        if (!existsUser) {
            return _response.status(404).json( {message: "Não foi achado este usuário!"} );
        }

        const tasks: Array<Task> = await connection('tasks').where('people_identification', identification).select('*');
    
        return _response.status(201).json(tasks);
    },

    async create(_require: Request, _response: Response): Promise<Response> {
        const existsUser: Boolean = await existsController.existsPeople(String(_require.headers.identification));

        if (!existsUser) {
            return _response.status(404).json( {message: "Não foi achado este usuário!"} );
        }

        const newTask: Task = {
            name: _require.body.name,
            action: _require.body.action,
            people_identification: String(_require.headers.identification)
        }

        await connection('tasks').insert(newTask);

        return _response.status(201).json(newTask);
    },

    async update(_require: Request, _response: Response): Promise<Response> {
        const identification: String = String(_require.headers.identification);
        const id_update: Number = parseInt(_require.params.id);

        const existsUser: Boolean = await existsController.existsPeople(identification);

        if (!existsUser) {
            return _response.status(404).json( {message: "Não foi achado este usuário!"} );
        }

        const task: Task = await connection('tasks').where('people_identification', identification).where('id', id_update).select('*').first();

        if (!task) {
            return _response.status(404).json( {message: "Não foi achada a tarefa deste usuário para atualização!"} );
        }

        if (_require.body.name != task.name) {
            task.name = _require.body.name;
        }

        if (_require.body.action != task.action) {
            task.action = _require.body.action;
        }

        await connection('tasks').where('people_identification', identification).where('id', id_update).update('name', task.name).update('action', task.action);

        return _response.status(201).json(task);
    },

    async delete(_require: Request, _response: Response): Promise<Response> {
        const identification: String = String(_require.headers.identification);
        const id_delete: Number = parseInt(_require.params.id);

        const existsUser: Boolean = await existsController.existsPeople(identification);

        if (existsUser) {
            return _response.status(404).json( {message: "Não foi achado este usuário!"} );
        }

        const task: Task = await connection('tasks').where('people_identification', identification).where('id', id_delete).select('*').first();

        if (!task) {
            return _response.status(404).json( {message: "Não foi achada a tarefa deste usuário para deleção!"} );
        }
    
        await connection('tasks').where('people_identification', identification).where('id', id_delete).delete();

        return _response.status(201).json(task);
    },

    async clearAll(_require: Request, _response: Response): Promise<Response> {
        const identification: String = String(_require.headers.identification);

        const existsUser: Boolean = await existsController.existsPeople(identification);

        if (existsUser) {
            return _response.status(404).json( {message: "Não foi achado este usuário!"} );
        }

        const taks: Array<Task> = await connection('tasks').where('people_identification', identification);

        if (taks.length == 0) {
            return _response.status(404).json( {message: "Este usuário não possui tarefas para deleção!"} );
        }
        
        await connection('tasks').where('people_identification', identification).delete();

        return _response.status(201).json( {message: 'Tarefas apagas com sucesso!'} );
    }
};