import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsequenceStep } from './consequence-step';

describe('ConsequenceStep', () => {
  let component: ConsequenceStep;
  let fixture: ComponentFixture<ConsequenceStep>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsequenceStep]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsequenceStep);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
