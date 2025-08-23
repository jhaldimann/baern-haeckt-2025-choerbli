import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChoerbliForm } from './choerbli-form';

describe('ChoerbliForm', () => {
  let component: ChoerbliForm;
  let fixture: ComponentFixture<ChoerbliForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChoerbliForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChoerbliForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
