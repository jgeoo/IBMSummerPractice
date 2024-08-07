import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {StudentDto} from "../../../core/dto/student/StudentDto";

@Injectable({
  providedIn: 'root'
})
export class StudentStateService {

  subject = new BehaviorSubject<StudentDto | null>(null)

  constructor() {
  }

  getAsObservable() {
    return this.subject.asObservable();
  }
}
