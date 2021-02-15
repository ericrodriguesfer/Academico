import { Injectable } from '@nestjs/common';
import * as crypto from 'crypto';
import { User } from './user';

@Injectable()
export class UserService {
    users: Array<User> = [];

    getAllUsers() {
        return this.users;
    }

    getUserById(id: number) {
        const user: User = this.users.find((userSearch) => userSearch.id == id);

        if (!user) {
            throw new Error("Fail search this user!");
        }

        return user;
    }

    createUser(user: User) {
        this.users.forEach((userSearchEmail) => {
            if (userSearchEmail.email == user.email) {
                throw new Error("Account exists with this email!");
            }
        });

        let currentId: number = 0;

        if (this.users.length > 0) {
            currentId = this.users[this.users.length - 1].id;
        }

        user.id = (currentId + 1);
        user.identification = crypto.randomBytes(4).toString("hex");
        user.pass = crypto.createHmac("sha256", user.pass).update("i need security for password of user").digest("hex");

        this.users.push(user);

        return user;
    }

    updateUser(user: User) {
        const userSearch: User = this.getUserById(user.id);

        if (userSearch) {
            if (userSearch.email != user.email) {
                this.users.forEach((userSearchEmail) => {
                    if (userSearchEmail.email == user.email) {
                        throw new Error("Account exists with this email!");
                    }
                });
            }

            userSearch.name = user.name;
            userSearch.email = user.email;
            userSearch.pass = crypto.createHmac("sha256", user.pass).update("i need security for password of user").digest("hex");
        } else {
            throw new Error("Fail complet this user!");
        }

        return userSearch;
    }

    deleteUser(id: number) {
        const indexUser: number = this.users.findIndex((userSearch) => userSearch.id == id);

        if (indexUser < 0 || indexUser > this.users.length) {
            throw new Error("Fail search this user to delete!");
        }

        this.users.splice(indexUser, 1);

        return {message: "User delete with success!"};
    }
    
}
