import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { TasksModule } from './tasks/tasks.module';
import { UserModule } from './user/user.module';

@Module({
  imports: [TasksModule, UserModule],
  controllers: [AppController],
  providers: [AppService],
})

export class AppModule {}
