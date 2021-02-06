import express from 'express';
import { errors } from 'celebrate';
import routes from '../routes/routes';

const app = express();

app.use(express.json());
app.use(routes);
app.use(errors());

export default app;