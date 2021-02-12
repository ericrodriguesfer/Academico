import { Router } from 'express';
import { celebrate, Segments, Joi } from 'celebrate';
import peopleController from '../controller/peopleController';
import { auth } from '../middlewares/OAuth';

const routesPeople = Router();

routesPeople.post("/register/people", celebrate({
    [Segments.BODY] : Joi.object().keys({
        name: Joi.string().required().min(3),
        email: Joi.string().required().email(),
        pass: Joi.string().required().min(4),
        age: Joi.number().required().min(1) 
    }),
}), peopleController.create);

routesPeople.post("/login", celebrate({
    [Segments.BODY] : Joi.object().keys({
        email: Joi.string().required(),
        pass: Joi.string().required()
    }),
}), peopleController.login);

routesPeople.use(auth);

routesPeople.get("/", peopleController.index);

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

routesPeople.get("/logout", peopleController.logout);

export default routesPeople;  