import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenstreetComponent } from './openstreet.component';

describe('OpenstreetComponent', () => {
  let component: OpenstreetComponent;
  let fixture: ComponentFixture<OpenstreetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpenstreetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenstreetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
