import {ComponentFixture, TestBed} from '@angular/core/testing';

import {CourseFeatureComponent} from './course-feature.component';

describe('CourseFeatureComponent', () => {
  let component: CourseFeatureComponent;
  let fixture: ComponentFixture<CourseFeatureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseFeatureComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(CourseFeatureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
