import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AccountModel } from '../models/account.model';
import { CriaContaModel } from '../models/cria-conta.model';

@Injectable({
  providedIn: 'root'
})
export class CriaContaService {

  constructor(private http: HttpClient) { }

  criaConta(criaConta: CriaContaModel) {
    return this.http.post<AccountModel>(environment.api + '/account', criaConta)
  }

}
