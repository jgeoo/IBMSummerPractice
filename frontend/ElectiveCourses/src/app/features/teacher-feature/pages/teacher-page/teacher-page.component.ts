import {Component, inject, OnInit} from '@angular/core';
import {TeacherService} from "../../../../core/services/http/teacher.service";
import {TeacherDto} from "../../../../core/dto/teacher/TeacherDto";
import {MatButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";
import {MatTableModule} from '@angular/material/table';
import {JsonPipe, NgIf} from "@angular/common";

@Component({
  selector: 'app-teacher-page',
  standalone: true,
  imports: [
    JsonPipe,
    MatButton,
    RouterLink,
    MatTableModule,
    NgIf
  ],
  templateUrl: './teacher-page.component.html',
  styleUrls: ['./teacher-page.component.css']
})
export class TeacherPageComponent implements OnInit {
  teachers: TeacherDto[] = [];
  displayedColumns: string[] = ['id', 'name', 'courseId'];
  loading = true;
  error: string | null = null;
  private readonly teacherService = inject(TeacherService);

  ngOnInit() {
    this.teacherService.getTeachers().subscribe({
      next: (value) => {
        this.teachers = value;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching teachers', err);
        this.error = 'Error fetching teacher data';
        this.loading = false;
      }
    });
  }
}
