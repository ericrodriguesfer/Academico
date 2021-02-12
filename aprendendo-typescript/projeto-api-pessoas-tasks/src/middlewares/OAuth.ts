import { Request, Response, NextFunction } from 'express';
import { storage } from '../config/storage';

export const auth = async (_require: Request, _response: Response, _next: NextFunction) => {
    const authHeader: any = _require.headers.authorization;

    if (!authHeader) {
        _response.status(404).json( {message: "Execute seu login para obter acesso!"} );
    }
    
    const token = authHeader.split(" ");

    try {
        if (token[1] == storage.getItem("token")) {
            _next();
        } else {
            _response.status(404).json( {message: "Erro com seu login! Tente novamente!"} );
        }
    } catch(error) {
        _response.status(404).json( {message: "Execute seu login para obter acesso!"} );
    };
}