import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChoerbliCreation } from './choerbli-creation';

describe('ChoerbliCreation', () => {
  let component: ChoerbliCreation;
  let fixture: ComponentFixture<ChoerbliCreation>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChoerbliCreation]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChoerbliCreation);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
