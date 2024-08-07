import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CourseDto} from "../../dto/course/CourseDto";
import {CreateCourseDto} from "../../dto/course/CreateCourseDto";
import {EditCourseDto} from "../../dto/course/EditCourseDto";
import {map, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private readonly http = inject(HttpClient);
  private readonly path = "http://localhost:8080/courses"

  constructor() {
  }

  getAllCourses() {
    return this.http.get<CourseDto[]>(this.path);
  }

  createCourse(dto: CreateCourseDto) {
    return this.http.post(this.path, dto);
  }

  editCourse(id: number, dto: EditCourseDto) {
    return this.http.put(this.path + `/${id}`, dto);
  }

  deleteCourse(id: number) {
    return this.http.delete(this.path + `/${id}`);
  }

  getById(id: number) {
    return this.http.get<CourseDto>(this.path + `/${id}`);
  }

  getAllCourseIds(): Observable<number[]> {
    return this.http.get<CourseDto[]>(this.path).pipe(
      map(courses => courses.map(course => course.id))
    );
  }
}
