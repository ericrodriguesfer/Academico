import { Module } from '@nestjs/common';
import { AppService } from './app.service';
import { TasksModule } from '../tasks/tasks.module';
import { UserModule } from '../user/user.module';

@Module({
  imports: [TasksModule, UserModule],
  controllers: [],
  providers: [AppService],
})

export class AppModule {}
