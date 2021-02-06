import { Router } from 'express';
import { celebrate, Segments, Joi } from 'celebrate';
import peopleController from '../controller/peopleController';
import taskController from '../controller/taskController';

const routes = Router();

routes.get("/", peopleController.index);

routes.post("/register/people", celebrate({
    [Segments.BODY] : Joi.object().keys({
       name: Joi.string().required().min(3),
       email: Joi.string().required().email(),
       age: Joi.number().required().min(1) 
    }),
}), peopleController.create);

routes.delete("/delete/people/:id", celebrate({
    [Segments.PARAMS] : Joi.object({
        id: Joi.number().required()
    }),
}), peopleController.delete);

routes.get("/list/people/taks/:id", celebrate({
    [Segments.PARAMS] : Joi.object({
        id: Joi.number().required()
    }),
}), taskController.index);

routes.post("/register/people/taks/:id", celebrate({
    [Segments.PARAMS] : Joi.object({
        id: Joi.number().required()
    }),
    [Segments.BODY] : Joi.object().keys({
        name: Joi.string().required(),
        action: Joi.string().required().min(10)
    }),
}), taskController.create);

routes.delete("/delete/people/:id_p/task/:id_t", celebrate({
    [Segments.PARAMS] : Joi.object({
        id_p: Joi.number().required(),
        id_t: Joi.number().required()
    }),
}), taskController.delete);

routes.delete("/clear/people/task/:id", celebrate({
    [Segments.PARAMS] : Joi.object({
        id: Joi.number().required()
    }),
}), taskController.clear);

export default routes;