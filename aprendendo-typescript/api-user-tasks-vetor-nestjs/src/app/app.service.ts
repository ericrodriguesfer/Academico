import { Injectable } from '@nestjs/common';

@Injectable()
export class AppService {
  getHello(): string {
    return "Wellcome learning to NestJs! Yeah!";
  }
}
