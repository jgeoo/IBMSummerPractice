import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCoursePageComponent } from './edit-course-page.component';

describe('EditCoursePageComponent', () => {
  let component: EditCoursePageComponent;
  let fixture: ComponentFixture<EditCoursePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditCoursePageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditCoursePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
