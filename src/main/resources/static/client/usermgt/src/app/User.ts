import { logging } from 'protractor';

export interface Response{
    _embedded:Users;
}

export interface Users{
    user:User[];
}

export interface User{
    id:number;
    firstName:string;
    email:string;
    address:string;
    password:string;
}