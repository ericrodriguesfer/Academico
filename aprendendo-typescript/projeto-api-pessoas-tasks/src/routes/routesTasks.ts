import { Router } from 'express';
import { celebrate, Segments, Joi } from 'celebrate';
import taskController from '../controller/taskController';
import auth from '../middlewares/OAuth';

const routesTasks = Router();

routesTasks.use(auth.auth);

routesTasks.get("/list/people/taks", celebrate({
    [Segments.HEADERS] : Joi.object({
        identification: Joi.string().required()
    }).unknown(),
}), taskController.index);

routesTasks.post("/register/people/taks", celebrate({
    [Segments.HEADERS] : Joi.object({
        identification: Joi.string().required()
    }).unknown(),
    [Segments.BODY] : Joi.object().keys({
        name: Joi.string().required(),
        action: Joi.string().required().min(10)
    }),
}), taskController.create);

routesTasks.put("/update/task/:id", celebrate({
    [Segments.HEADERS] : Joi.object({
        identification: Joi.string().required(),
    }).unknown(),
    [Segments.PARAMS] : Joi.object({
        id: Joi.number().required(),
    }),
    [Segments.BODY]: Joi.object().keys({
        name: Joi.string().required(),
        action: Joi.string().required().min(10)
    }),
}), taskController.update);

routesTasks.delete("/delete/people/task/:id", celebrate({
    [Segments.HEADERS] : Joi.object({
        identification: Joi.string().required()
    }).unknown(),
    [Segments.PARAMS] : Joi.object({
        id: Joi.number().required()
    }),
}), taskController.delete);

routesTasks.delete("/clear/people/task/", celebrate({
    [Segments.HEADERS] : Joi.object({
        identification: Joi.string().required()
    }).unknown(),
}), taskController.clearAll);

export default routesTasks;