import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThreekitImageCompComponent } from './threekit-image-comp.component';

describe('ThreekitImageCompComponent', () => {
  let component: ThreekitImageCompComponent;
  let fixture: ComponentFixture<ThreekitImageCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThreekitImageCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThreekitImageCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
