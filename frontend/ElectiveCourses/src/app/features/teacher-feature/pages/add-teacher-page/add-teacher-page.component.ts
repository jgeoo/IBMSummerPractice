import {Component, inject} from '@angular/core';
import {TeacherService} from "../../../../core/services/http/teacher.service";
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatError, MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {MatInput, MatInputModule} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {Router, RouterLink} from "@angular/router";
import {NgForOf, NgIf} from "@angular/common";
import {MatSelectModule} from "@angular/material/select";
import {CourseService} from "../../../../core/services/http/course.service";

@Component({
  selector: 'app-add-teacher-page',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormField,
    MatInput,
    MatButton,
    MatLabel,
    RouterLink,
    NgIf,
    MatError,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    FormsModule,
    NgForOf
  ],
  templateUrl: './add-teacher-page.component.html',
  styleUrls: ['./add-teacher-page.component.css']
})
export class AddTeacherPageComponent {

  courseIds: number[] =[];

  private readonly teacherService = inject(TeacherService);
  private readonly router = inject(Router);

  constructor(private courseService: CourseService) {}


  ngOnInit() {
    this.courseService.getAllCourseIds().subscribe({
      next: (data) => {
        this.courseIds = data;
        console.log('Fetched Course IDs:', this.courseIds);
      },
      error: (err) => {
        console.error('Error fetching course IDs', err);
      }
    });
  }

  form = new FormGroup({
    id: new FormControl(0, {
      validators: [Validators.required],
      nonNullable: true
    }),
    name: new FormControl("", {
      validators: [Validators.required],
      nonNullable: true
    }),
    courseId: new FormControl(0, {
      validators: [Validators.required],
      nonNullable: true
    }),
  });



  submit() {
    if (this.form.valid) {
      this.teacherService.createTeacher(this.form.getRawValue()).subscribe({
        next: value => {
          this.router.navigateByUrl("/admin/teachers");
        },
        error: err => {
          console.error('Error creating teacher', err);
        }
      });
    }
  }
}
