import { TestBed } from '@angular/core/testing';

import { CalcusService } from './calcus.service';

describe('CalcusService', () => {
  let service: CalcusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalcusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
