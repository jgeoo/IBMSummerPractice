import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentFeatureComponent } from './student-feature.component';

describe('StudentFeatureComponent', () => {
  let component: StudentFeatureComponent;
  let fixture: ComponentFixture<StudentFeatureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudentFeatureComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentFeatureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
