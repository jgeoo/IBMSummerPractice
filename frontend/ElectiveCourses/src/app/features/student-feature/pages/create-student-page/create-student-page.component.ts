import {Component, inject} from '@angular/core';
import {Router, RouterLink} from "@angular/router";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {StudentService} from "../../../../core/services/http/student.service";
import {MatButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatOption} from "@angular/material/core";
import {MatSelect} from "@angular/material/select";
import {StudentStateService} from "../../services/student-state.service";

@Component({
  selector: 'app-create-student-page',
  standalone: true,
  imports: [
    MatButton,
    MatFormField,
    MatInput,
    MatLabel,
    MatOption,
    MatSelect,
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './create-student-page.component.html',
  styleUrl: './create-student-page.component.css'
})
export class CreateStudentPageComponent {
  form = new FormGroup({
    name: new FormControl("", {
      validators: [Validators.required],
      nonNullable: true
    }),
    grade: new FormControl(0, {
      nonNullable: true
    }),
    study_year: new FormControl(0, {
      nonNullable: true
    }),
    faculty: new FormControl("", {
      nonNullable: true,
      validators: [Validators.required],
    })

  })
  daysOfWeek = [""]
  private readonly studentService = inject(StudentService);
  private readonly studentStateService = inject(StudentStateService);
  private readonly router = inject(Router);

  submit() {
    this.studentService.createStudent(this.form.getRawValue()).subscribe({
      next: value => {
        // poate cu url params
        this.studentStateService.subject.next(value);
        this.router.navigateByUrl("/student/electives");
      }
    })
  }
}
