function printl (): void {
    console.log("Printed!!!");
}

function print2 (name: string): void {
    console.log("Printed!!! Your name is " + name + "...");
}

function print3 (name: string, age: number): void {
    console.log("Printed!!! Your name is " + name + " and age is " + age + "...");
}

function print_media (name: string, n1: number, n2: number): void {
    console.log("Your name is " + name + ", and median of notes is " + ((n1 + n2) / 2) + "...");
}

function num (): number {
    return 10;
}

function num2 (num: number): number {
    return num;
}

function sum (num1: number, num2: number): number {
    return (num1 + num2);
}

function aproved (num1: number, num2: number): boolean {
    if (((num1 + num2) / 2) >= 6) {
        return true;
    } else {
        return false;
    }
}

function word (num: number): string {
    return "This is value passed: " + num;
}

function test (v1: any, v2: any, v3?: any): any {
    if (v3  !== undefined) {
        return (v1 + v2 + v3);
    } else {
        return (v1 + v2);
    }
}

function test2 (v1: string, ...v2: number[]): void {
    let sum: number = 0;

    for (let i: number = 0; i < v2.length; i++) {
        sum += v2[i];
    }

    console.log(v1 + " " +sum);
}