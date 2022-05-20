import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { PfHomeComponent } from "./pages/pf-home.component";

const routes: Routes = [
  {
    path: '',
    component: PfHomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PfRoutingModule {

}
