import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CriaContaComponent } from "./pages/cria-conta/cria-conta.component";
import { HomeComponent } from "./pages/home/home.component";
import { TransacoesComponent } from "./pages/transacoes/transacoes.component";

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'cria-conta',
    component: CriaContaComponent,
  },
  {
    path: 'trasactions',
    component: TransacoesComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BackOfficeRoutingModule {

}
