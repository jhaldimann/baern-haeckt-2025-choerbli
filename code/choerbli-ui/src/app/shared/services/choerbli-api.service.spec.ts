import { TestBed } from '@angular/core/testing';

import { ChoerbliApiService } from './choerbli-api.service';

describe('ChoerbliApiService', () => {
  let service: ChoerbliApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChoerbliApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
