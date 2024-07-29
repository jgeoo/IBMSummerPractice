import {inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TeacherDto } from '../../dto/teacher/TeacherDto'
@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  private apiUrl = 'http://localhost:8080/teachers';

  constructor(private http: HttpClient) { }

  getTeachers()  {
    return this.http.get<TeacherDto[]>(this.apiUrl);
  }
}
