import { Injectable } from '@nestjs/common';
import { Task } from './task';

@Injectable()
export class TaskService {
    tasks: Array<Task> = [];

    getAllTasks(owmer: string) {
        const tasks: Array<Task> = [];

        this.tasks.forEach((task) => {
            if (task.owner == owmer) {
                tasks.push(task);
            }
        });

        return tasks;
    }

    getTaskById(id: number, owner: string) {
        if (this.tasks.length == 0) {
            throw new Error("This user has not registered any tasks!");
        }

        const task: Task = this.tasks.find((taskSearch) => taskSearch.id == id && taskSearch.owner == owner);

        if (!task) {
            throw new Error("Fail search this task!");
        }

        return task;
    }

    getTasksCompleted(owner: string) {
        const tasksCompleted: Array<Task> = [];

        this.tasks.forEach((task) => {
            if (task.owner == owner) {
                if (task.completed) {
                    tasksCompleted.push(task);
                }
            }
        });

        return tasksCompleted;
    }
    
    getTasksNoCompleted(owner: string) {
        const tasksNoCompleted: Array<Task> = [];

        this.tasks.forEach((task) => {
            if (task.owner == owner) {
                if (!task.completed) {
                    tasksNoCompleted.push(task);
                }
            }
        });

        return tasksNoCompleted;
    }

    createTask(task: Task) {
        let lastId = 0;

        if (this.tasks.length > 0) {
            lastId = this.tasks[this.tasks.length - 1].id;
        }

        task.id = (lastId + 1);
        this.tasks.push(task);

        return task;
    }

    updateTask(task: Task) {
        const taskSearch: Task = this.getTaskById(task.id, task.owner);

        if (taskSearch) {
            taskSearch.description = task.description;
            taskSearch.completed = task.completed;
        } else {
            throw new Error("Fail update this task!");
        }

        return taskSearch;
    }

    updateCompletTask(id: number, owner: string) {
        const taskCompleted: Task = this.tasks.find((taskSearch) => taskSearch.id == id && taskSearch.owner == owner);

        if (taskCompleted) {
            taskCompleted.completed = true;
        } else {
            throw new Error("Fail complet this task!");
        }

        return taskCompleted;

    }

    deleteTask(id: number, owner: string) {
        const indexTask: number = this.tasks.findIndex((taskSearch) => taskSearch.id == id && taskSearch.owner == owner);

        if (indexTask < 0 || indexTask > this.tasks.length) {
            throw new Error("Fail search this task to delete!");
        }

        this.tasks.splice(indexTask, 1);

        return {message: "Task delete with success!"};
    }
    
}
