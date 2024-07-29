import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CourseDto} from "../../dto/course/CourseDto";
import {CreateCourseDto} from "../../dto/course/CreateCourseDto";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

    private readonly http = inject(HttpClient);
  constructor() { }
    private readonly path = "http://localhost:8080/courses"
    getAllCourses() {
      return this.http.get<CourseDto[]>(this.path);
    }
    createCourse(dto: CreateCourseDto) {
      return this.http.post(this.path, dto);
    }
}
