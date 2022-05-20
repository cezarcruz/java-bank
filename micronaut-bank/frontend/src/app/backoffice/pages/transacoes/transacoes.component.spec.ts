import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { BalanceService } from '../../balance.service';
import { TransactionService } from '../../transaction.service';

import { TransacoesComponent } from './transacoes.component';

describe('TransacoesComponent', () => {
  let component: TransacoesComponent;
  let fixture: ComponentFixture<TransacoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        HttpClientModule,
        ReactiveFormsModule,
      ],
      declarations: [
        TransacoesComponent,
      ],
      providers: [
        BalanceService,
        TransactionService
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransacoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
