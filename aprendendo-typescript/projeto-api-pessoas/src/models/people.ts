import { Task } from "./task";

export interface People {
    name: string,
    email: string,
    age: number,
    taks: Array<Task>
}