import { Request, Response, NextFunction } from 'express';
import jwt from 'jsonwebtoken';
import { storage } from '../config/storage';
import secret from '../config/secretToken';

export default {
    async auth(_require: Request, _response: Response, _next: NextFunction): Promise<any>{
        const token: string = String(storage.getItem("token"));

        if (!token) {
            return _response.status(404).json( {message: "Execute seu login para obter acesso!"} );
        }

        try {
            if (jwt.verify(token, String(secret.index))) {
                _next();
            } else {
                return _response.status(404).json( {message: "Erro com seu login! Tente novamente!"} );
            }
        } catch(error) {
            return _response.status(404).json( {message: "Execute seu login para obter acesso!"} );
        };
    }
}