import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {StudentDto} from "../../../core/dto/student/StudentDto";

@Injectable({
  providedIn: 'root'
})
export class StudentStateService {

  constructor() { }
  subject = new BehaviorSubject<StudentDto | null>(null)
  getAsObservable() {
    return this.subject.asObservable();
  }
}
