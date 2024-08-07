import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CreateStudentDto} from "../../dto/student/CreateStudentDto";
import {StudentDto} from "../../dto/student/StudentDto";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private readonly http = inject(HttpClient);
  private readonly path = "http://localhost:8080/student";

  constructor() {
  }

  createStudent(dto: CreateStudentDto) {
    return this.http.post<StudentDto>(this.path, dto);
  }
}
