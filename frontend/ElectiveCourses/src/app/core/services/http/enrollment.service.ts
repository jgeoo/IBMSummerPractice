import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CreateEnrollmentDto} from "../../dto/enrollment/create-enrollment.dto";
import {EnrollmentDto} from "../../dto/enrollment/enrollment.dto";
import {EnrollmentDetailDto} from "../../dto/enrollment/enrollment-detail.dto";

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {

  private apiUrl = 'http://localhost:8080/enrollments';

  constructor(private http: HttpClient) {
  }

  getEnrollments() {
    return this.http.get<EnrollmentDetailDto[]>(this.apiUrl);
  }

  createEnrollment(dto: CreateEnrollmentDto) {
    return this.http.post<EnrollmentDto>(this.apiUrl, dto);
  }

  deleteEnrollment(id: number) {
    return this.http.delete(this.apiUrl + `/${id}`);
  }
}
