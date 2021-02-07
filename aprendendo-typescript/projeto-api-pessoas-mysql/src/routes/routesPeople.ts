import { Router } from 'express';
import { celebrate, Segments, Joi } from 'celebrate';
import peopleController from '../controller/peopleController';

const routesPeople = Router();

routesPeople.get("/", peopleController.index);

routesPeople.post("/register/people", celebrate({
    [Segments.BODY] : Joi.object().keys({
        name: Joi.string().required().min(3),
        email: Joi.string().required().email(),
        pass: Joi.string().required().min(4),
        age: Joi.number().required().min(1) 
    }),
}), peopleController.create);

routesPeople.put("/update/people/:id", celebrate({
    [Segments.PARAMS] : Joi.object({
        id: Joi.number().required()
    }),
    [Segments.BODY] : Joi.object().keys({
        name: Joi.string().required().min(3),
        email: Joi.string().required().email(),
        age: Joi.number().required().min(1) 
    }),
}), peopleController.update);

routesPeople.delete("/delete/people/:id", celebrate({
    [Segments.PARAMS] : Joi.object({
         id: Joi.number().required()
    }),
}), peopleController.delete);

export default routesPeople;  