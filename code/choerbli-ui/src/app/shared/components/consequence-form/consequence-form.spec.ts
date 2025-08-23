import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsequenceForm } from './consequence-form';

describe('ConsequenceForm', () => {
  let component: ConsequenceForm;
  let fixture: ComponentFixture<ConsequenceForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsequenceForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsequenceForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
