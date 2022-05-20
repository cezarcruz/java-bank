import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'backoffice',
    loadChildren: () => import('./backoffice/backofice.module').then(m => m.BackOfficeModule)
  },
  {
    path: 'pf',
    loadChildren: () => import('./pf/pf.module').then(m => m.PfModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
