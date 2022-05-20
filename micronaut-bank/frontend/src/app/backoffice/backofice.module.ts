import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { HttpClientModule } from '@angular/common/http';
import { BackOfficeRoutingModule } from "./backoffice-routing.module";
import { HomeComponent } from "./pages/home/home.component";
import { CriaContaComponent } from './pages/cria-conta/cria-conta.component';
import { ReactiveFormsModule } from "@angular/forms";
import { SharedModule } from "../shared/shared.module";
import { TransacoesComponent } from './pages/transacoes/transacoes.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    BackOfficeRoutingModule,
  ],
  declarations: [
    HomeComponent,
    CriaContaComponent,
    TransacoesComponent,
  ]
})
export class BackOfficeModule {

}
