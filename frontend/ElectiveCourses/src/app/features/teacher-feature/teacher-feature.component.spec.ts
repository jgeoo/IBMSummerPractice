import {ComponentFixture, TestBed} from '@angular/core/testing';

import {TeacherFeatureComponent} from './teacher-feature.component';

describe('TeacherFeatureComponent', () => {
  let component: TeacherFeatureComponent;
  let fixture: ComponentFixture<TeacherFeatureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TeacherFeatureComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(TeacherFeatureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
