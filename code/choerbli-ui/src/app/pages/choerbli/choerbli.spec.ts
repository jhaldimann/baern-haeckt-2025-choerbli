import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Choerbli } from './choerbli';

describe('Choerbli', () => {
  let component: Choerbli;
  let fixture: ComponentFixture<Choerbli>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Choerbli]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Choerbli);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
