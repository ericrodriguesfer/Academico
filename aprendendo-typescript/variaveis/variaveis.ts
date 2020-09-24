var num: number = 10;
var bool: boolean = true;

var str: string = "This use string is success...";
var str2: string = 'This use typescript is good!!!';
var str3: string = `${str} ${str2}`;

let list: number[] = [1, 2, 3];
let list2: Array<number> = [1, 2, 3];

let tuple: [string, number] = ["people", 10];

enum day{MONDAY, TUESDAY};

let day_definition: day = day.MONDAY;

let not_define: any = "test";

let example: void = null;
let example2: void = undefined;

let var1: any = "house";

let str_length: number = (<string> var1).length;
let str_upper_case: string = (var1 as string).toUpperCase();