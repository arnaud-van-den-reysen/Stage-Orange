import { TestBed } from '@angular/core/testing';

import { DataFormulaireService } from './data-formulaire.service';

describe('DataFormulaireService', () => {
  let service: DataFormulaireService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DataFormulaireService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
