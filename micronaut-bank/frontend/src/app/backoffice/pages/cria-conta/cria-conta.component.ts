import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AccountModel } from '../../models/account.model';
import { CriaContaModel } from '../../models/cria-conta.model';
import { CriaContaService } from '../cria-conta.service';

@Component({
  selector: 'app-cria-conta',
  templateUrl: './cria-conta.component.html',
  styleUrls: ['./cria-conta.component.scss']
})
export class CriaContaComponent {

  contaGerada: AccountModel = new AccountModel();

  profileForm = new FormGroup({
    agency: new FormControl('', [Validators.required]),
  });

  constructor(private criaContaService: CriaContaService) { }

  onSubmit() {
    this.criaContaService
      .criaConta(new CriaContaModel(this.profileForm.get('agency')?.value))
      .subscribe(e => this.contaGerada = e);
  }

}
