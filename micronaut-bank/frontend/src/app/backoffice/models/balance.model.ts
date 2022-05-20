import { AccountModel } from "./account.model";

export class BalanceModel {
  constructor(
    public balance?: number,
    public accountResponse?: AccountModel,
  ) {}
}
