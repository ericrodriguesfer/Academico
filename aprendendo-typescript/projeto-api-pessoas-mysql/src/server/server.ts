import express from 'express';
import { errors } from 'celebrate';
import routesPeople from '../routes/routesPeople';
import routesTasks from '../routes/routesTasks';

const app = express();

app.use(express.json());
app.use(routesPeople);
app.use(routesTasks);
app.use(errors());

export default app;