import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatOption} from "@angular/material/core";
import {MatSelect} from "@angular/material/select";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {CourseService} from "../../../../core/services/http/course.service";
import {takeUntilDestroyed} from "@angular/core/rxjs-interop";

@Component({
  selector: 'app-edit-course-page',
  standalone: true,
  imports: [
    FormsModule,
    MatButton,
    MatFormField,
    MatInput,
    MatLabel,
    MatOption,
    MatSelect,
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './edit-course-page.component.html',
  styleUrl: './edit-course-page.component.css'
})
export class EditCoursePageComponent implements OnInit {
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
  private readonly route = inject(ActivatedRoute);
  private readonly destroyRef = inject(DestroyRef);

  ngOnInit() {
    this.courseService.getById(this.route.snapshot.params['id']).pipe(takeUntilDestroyed(this.destroyRef)).subscribe({
      next: value => {
        this.form.patchValue(value);
      }
    })
  }

  submit() {
    this.courseService.editCourse(this.route.snapshot.params['id'], this.form.getRawValue()).subscribe({
      next: value => {
        this.router.navigateByUrl("/admin/courses");
      }
    })
  }
}
