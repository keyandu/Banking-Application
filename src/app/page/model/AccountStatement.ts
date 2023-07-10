import { Transaction } from "./Transaction";

export class AccountStatment{
    accountNo: string= '';
    accountType:string= '';
    accountBalance: number=0;
    accountStatus: string= '';
    transactions: Transaction[]=[];
}