import { Component, OnInit } from '@angular/core';
import { TeacherService } from '../../../../core/services/http/teacher.service';
import { TeacherDto } from '../../../../core/dto/teacher/TeacherDto';
import {JsonPipe} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-teacher-page',
  standalone: true,
  imports: [
    JsonPipe,
    MatButton,
    RouterLink
  ],
  templateUrl: './teacher-page.component.html',
  styleUrls: ['./teacher-page.component.ts']
})
export class TeacherPageComponent implements OnInit {
  teachers: TeacherDto[] = [];

  constructor(private teacherService: TeacherService) { }

  ngOnInit(): void {
    this.teacherService.getTeachers().subscribe({
      next: value => {
        this.teachers = value
      }
    });
  }
}
