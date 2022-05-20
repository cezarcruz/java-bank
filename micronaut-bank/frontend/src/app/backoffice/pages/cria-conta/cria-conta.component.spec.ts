import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AgencyPipe } from 'src/app/shared/pipes/agency.pipe';
import { CriaContaService } from '../cria-conta.service';

import { CriaContaComponent } from './cria-conta.component';

describe('CriaContaComponent', () => {
  let component: CriaContaComponent;
  let fixture: ComponentFixture<CriaContaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        HttpClientModule,
      ],
      declarations: [
        CriaContaComponent,
        AgencyPipe,
      ],
      providers: [
        CriaContaService,
        AgencyPipe,
      ]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CriaContaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
