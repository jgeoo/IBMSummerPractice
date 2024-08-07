import {Component, inject} from '@angular/core';
import {CourseService} from "../../../../core/services/http/course.service";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatOption, MatSelect} from "@angular/material/select";
import {MatButton} from "@angular/material/button";
import {Router, RouterLink} from "@angular/router";

@Component({
  selector: 'app-add-course-page',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormField,
    MatInput,
    MatSelect,
    MatOption,
    MatButton,
    MatLabel,
    RouterLink
  ],
  templateUrl: './add-course-page.component.html',
  styleUrl: './add-course-page.component.css'
})
export class AddCoursePageComponent {

  form = new FormGroup({
    name: new FormControl("", {
      validators: [Validators.required],
      nonNullable: true
    }),
    maxStudentsAllowed: new FormControl(0, {
      nonNullable: true
    }),
    yearOfStudy: new FormControl(0, {
      nonNullable: true
    }),
    dayOfWeek: new FormControl("", {
      nonNullable: true,
      validators: [Validators.required],
    }),
    startHour: new FormControl(0, {
      nonNullable: true
    }),
    endHour: new FormControl(0, {
      nonNullable: true
    }),

  })
  daysOfWeek = [""]
  private readonly courseService = inject(CourseService);
  private readonly router = inject(Router);

  submit() {
    this.courseService.createCourse(this.form.getRawValue()).subscribe({
      next: value => {
        this.router.navigateByUrl("/admin/courses");
      }
    })
  }
}
