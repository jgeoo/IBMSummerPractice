import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElectivesPageComponent } from './electives-page.component';

describe('ElectivesPageComponent', () => {
  let component: ElectivesPageComponent;
  let fixture: ComponentFixture<ElectivesPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ElectivesPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElectivesPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
