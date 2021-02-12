import crypto from 'crypto';

export default {
    async createIdentification(): Promise<string> {
        return await crypto.randomBytes(4).toString('hex');
    },

    async createPass(password: string): Promise<string> {
        return await crypto.createHmac('sha256', password).update('i need security for password of user').digest('hex');
    }
}