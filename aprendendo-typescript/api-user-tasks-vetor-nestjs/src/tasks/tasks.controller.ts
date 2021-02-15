import { Body, Controller, Delete, Get, Headers, Param, Post, Put } from '@nestjs/common';
import { Task } from './shared/task';
import { TaskService } from './shared/task.service';

@Controller('tasks')
export class TasksController {
    constructor(
        private TaskService: TaskService
    ) {}

    @Get()
    async getAll(@Headers("owner") owner: string): Promise<Array<Task>> {
        return this.TaskService.getAllTasks(owner);
    }   

    @Get("completede")
    async getCompleted(@Headers("owner") owner: string): Promise<Array<Task>> {
        return this.TaskService.getTasksCompleted(owner);
    }

    @Get("nocompletede")
    async getNoCompleted(@Headers("owner") owner: string): Promise<Array<Task>> {
        return this.TaskService.getTasksNoCompleted(owner);
    }

    @Get(":id")
    async getById(@Headers("owner") owner: string, @Param("id") id:number): Promise<Task> {
        return this.TaskService.getTaskById(id, owner);
    }

    @Post()
    async create(@Headers("owner") owner: string, @Body() task: Task): Promise<Task> {
        task.owner = owner;

        return this.TaskService.createTask(task);
    }

    @Put(":id")
    async update(@Headers("owner") owner: string, @Param("id") id: number, @Body() task: Task): Promise<Task> {
        task.id = id;
        task.owner = owner;

        return this.TaskService.updateTask(task);
    }

    @Put("complet/:id")
    async updateComplet(@Headers("owner") owner: string, @Param("id") id: number): Promise<Task> {
        return this.TaskService.updateCompletTask(id, owner);
    }

    @Delete(":id")
    async delete(@Headers("owner") owner: string, @Param("id") id: number) {
        return this.TaskService.deleteTask(id, owner);
    }

}   
