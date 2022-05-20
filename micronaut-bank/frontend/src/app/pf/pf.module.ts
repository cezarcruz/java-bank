import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { PfHomeComponent } from './pages/pf-home.component';
import { PfRoutingModule } from './pf-routing.module';

@NgModule({
  imports: [CommonModule, PfRoutingModule],
  declarations: [PfHomeComponent],
})
export class PfModule { }
