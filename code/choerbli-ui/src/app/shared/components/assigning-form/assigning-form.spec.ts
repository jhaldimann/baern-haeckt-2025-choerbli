import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssigningForm } from './assigning-form';

describe('AssigningForm', () => {
  let component: AssigningForm;
  let fixture: ComponentFixture<AssigningForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AssigningForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssigningForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
