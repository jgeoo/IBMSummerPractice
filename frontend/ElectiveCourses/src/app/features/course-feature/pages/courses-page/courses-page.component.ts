import {Component, inject, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CourseDto} from "../../../../core/dto/course/CourseDto";
import {CourseService} from "../../../../core/services/http/course.service";
import {JsonPipe} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-courses-page',
  standalone: true,
    imports: [
        JsonPipe,
        MatButton,
        RouterLink
    ],
  templateUrl: './courses-page.component.html',
  styleUrl: './courses-page.component.css'
})
export class CoursesPageComponent implements OnInit {
    private readonly courseService = inject(CourseService);
    courses : CourseDto[] = []
    ngOnInit() {
        this.courseService.getAllCourses().subscribe({
            next: value => {
                this.courses = value
            }
        })
    }
}
