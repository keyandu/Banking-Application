import { Transaction } from "./Transaction";

export class AccountStatment{
    id:number=0;
    accountNo: string= '';
    accountType:string= '';
    accountBalance: number=0;
    accountStatus: string= '';
    transactions: Transaction[]=[];
}