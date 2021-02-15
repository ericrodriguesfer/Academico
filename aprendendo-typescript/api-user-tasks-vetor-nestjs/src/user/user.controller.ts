import { Body, Controller, Delete, Get, Param, Post, Put } from '@nestjs/common';
import { User } from './shared/user';
import { UserService } from './shared/user.service';

@Controller('user')
export class UserController {
    constructor(
        private UserService: UserService
    ) {}

    @Get()
    async getAll(): Promise<Array<User>> {
        return this.UserService.getAllUsers();
    }

    @Get(":id")
    async getById(@Param("id") id: number): Promise<User> {
        return this.UserService.getUserById(id);
    }

    @Post()
    async create(@Body() user: User): Promise<User> {
        return this.UserService.createUser(user);
    }

    @Put(":id")
    async update(@Param("id") id: number, @Body() user: User): Promise<User> {
        user.id = id;
        
        return this.UserService.updateUser(user);
    }

    @Delete(":id")
    async delete(@Param("id") id: number) {
        return this.UserService.deleteUser(id);
    }
    
}
