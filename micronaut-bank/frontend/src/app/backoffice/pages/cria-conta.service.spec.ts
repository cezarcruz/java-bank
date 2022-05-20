import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { CriaContaService } from './cria-conta.service';

describe('CriaContaService', () => {
  let service: CriaContaService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientModule,
      ]
    });
    service = TestBed.inject(CriaContaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
