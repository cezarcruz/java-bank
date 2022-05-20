import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { TransactionModel } from "./models/transaction.model";

@Injectable({
  providedIn: 'root',
})
export class TransactionService {

  constructor(private readonly httpClient: HttpClient) { }

  public getTransactionsBy(account: number): Observable<TransactionModel[]> {
    return this.httpClient.get<TransactionModel[]>(`http://localhost:8080/account/${account}/agency/100/transactions`);
  }

}
