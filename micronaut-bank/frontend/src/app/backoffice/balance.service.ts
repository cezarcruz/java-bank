import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BalanceModel } from "./models/balance.model";

@Injectable({
  providedIn: 'root',
})
export class BalanceService {
  constructor(private readonly httpClient: HttpClient) {}

  public getBalance(account: number) {
    return this.httpClient.get<BalanceModel>(`http://localhost:8080/account/${account}/agency/100/balance`);
  }
}
