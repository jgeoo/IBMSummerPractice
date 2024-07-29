import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CourseDto} from "../../dto/course/CourseDto";

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
}
