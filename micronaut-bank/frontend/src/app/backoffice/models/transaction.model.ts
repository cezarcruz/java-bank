export class TransactionModel {
  constructor(
    public internalId: String,
    public account: String,
    public value: number,
    public operationType: String, //Enum
    public time: Date,
  ) {}
}
