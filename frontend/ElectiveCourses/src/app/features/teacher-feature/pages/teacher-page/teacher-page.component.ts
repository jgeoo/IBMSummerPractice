import {Component, inject, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

import {JsonPipe} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";
import {TeacherService} from "../../../../core/services/http/teacher.service";
import {TeacherDto} from "../../../../core/dto/teacher/TeacherDto";

@Component({
  selector: 'app-courses-page',
  standalone: true,
  imports: [
    JsonPipe,
    MatButton,
    RouterLink
  ],
  templateUrl: './teacher-page.component.html',
  styleUrl: './teacher-page.component.css'
})
export class TeacherPageComponent implements OnInit {
  private readonly teacherService = inject(TeacherService);
  teachers : TeacherDto[] = []
  ngOnInit() {
    this.teacherService.getTeachers().subscribe({
      next: value => {
        this.teachers = value
      }
    })
  }
}
