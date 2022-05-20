import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { BalanceService } from '../../balance.service';
import { BalanceModel } from '../../models/balance.model';
import { TransactionModel } from '../../models/transaction.model';
import { TransactionService } from '../../transaction.service';

@Component({
  selector: 'app-transacoes',
  templateUrl: './transacoes.component.html',
  styleUrls: ['./transacoes.component.scss']
})
export class TransacoesComponent {

  readonly searchForm: FormGroup;

  transactionService$!: Observable<TransactionModel[]>;
  balanceService$!: Observable<BalanceModel>;

  constructor(
    private readonly transactionService: TransactionService,
    private readonly balanceService: BalanceService,
    private readonly fb: FormBuilder,
  ) {
    this.searchForm = fb.group({
      account: [59797, Validators.required]
    });
  }

  onSubmit(): void {
    //account
    const account: number = this.account?.value;

    this.transactionService$ = this.transactionService.getTransactionsBy(account);
    this.balanceService$ = this.balanceService.getBalance(account);

  }

  get account() {
    return this.searchForm.get('account');
  }

}
