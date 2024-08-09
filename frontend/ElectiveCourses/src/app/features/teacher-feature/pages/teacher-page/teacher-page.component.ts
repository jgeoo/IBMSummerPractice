import {Component, inject, OnInit} from '@angular/core';
import {TeacherService} from "../../../../core/services/http/teacher.service";
import {TeacherDto} from "../../../../core/dto/teacher/TeacherDto";
import {MatButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";
import {MatTableModule} from '@angular/material/table';
import {JsonPipe, NgIf} from "@angular/common";
import {CourseService} from "../../../../core/services/http/course.service";
import {CourseDto} from "../../../../core/dto/course/CourseDto";

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
  courses: CourseDto[] = [];

  displayedColumns: string[] = ['id', 'name', 'courseName'];
  loadingTeachers = true;
  loadingCourses = true;
  loading = true;
  error: string | null = null;
  private readonly teacherService = inject(TeacherService);
  private readonly courseService: CourseService = inject(CourseService);


  ngOnInit() {
    this.courseService.getAllCourses().subscribe({
      next: (value) => {
        this.courses = value;
        this.loadingCourses = false;
        this.loading = this.loadingTeachers;
      },
      error: (err) => {
        console.error('Error fetching courses', err);
        this.error = 'Error fetching courses data';
        this.loadingCourses = false;
        this.loading = this.loadingTeachers;
      }
    });

    this.teacherService.getTeachers().subscribe({
      next: (value) => {
        this.teachers = value;
        this.loadingTeachers = false;
        this.loading = this.loadingCourses;
      },
      error: (err) => {
        console.error('Error fetching teachers', err);
        this.error = 'Error fetching teacher data';
        this.loadingTeachers = false;
        this.loading = this.loadingCourses;
      }
    });
  }

  getCourseName(courseId: number): string {
    const course = this.courses.find(course => course.id === courseId);
    return course ? course.name : 'Unknown';
  }
}
