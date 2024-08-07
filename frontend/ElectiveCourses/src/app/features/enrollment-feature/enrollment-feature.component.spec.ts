import {ComponentFixture, TestBed} from '@angular/core/testing';

import {EnrollmentFeatureComponent} from './enrollment-feature.component';

describe('EnrollmentFeatureComponent', () => {
  let component: EnrollmentFeatureComponent;
  let fixture: ComponentFixture<EnrollmentFeatureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnrollmentFeatureComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(EnrollmentFeatureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
