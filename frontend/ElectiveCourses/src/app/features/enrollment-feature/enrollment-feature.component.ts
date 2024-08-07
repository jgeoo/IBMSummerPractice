// @ts-nocheck
import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {EnrollmentService} from "../../core/services/http/enrollment.service";
import {EnrollmentDto} from "../../core/dto/enrollment/enrollment.dto";
import {takeUntilDestroyed} from "@angular/core/rxjs-interop";
import {AsyncPipe, JsonPipe, NgIf} from "@angular/common";
import {EnrollmentDetailDto} from "../../core/dto/enrollment/enrollment-detail.dto";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow, MatHeaderRowDef, MatRow, MatRowDef, MatTable,
  MatTableDataSource
} from "@angular/material/table";
import {TableData} from "../student-feature/pages/electives-page/electives-page.component";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatIcon} from "@angular/material/icon";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatInput} from "@angular/material/input";
import {MatPaginator} from "@angular/material/paginator";
import jsPDF from "jspdf";
import autoTable from "jspdf-autotable";

@Component({
  selector: 'app-enrollment-feature',
  standalone: true,
  imports: [
    JsonPipe,
    AsyncPipe,
    MatCell,
    MatCellDef,
    MatColumnDef,
    MatFormField,
    MatHeaderCell,
    MatHeaderRow,
    MatHeaderRowDef,
    MatIcon,
    MatIconButton,
    MatInput,
    MatLabel,
    MatPaginator,
    MatRow,
    MatRowDef,
    MatTable,
    NgIf,
    MatHeaderCellDef,
    MatButton
  ],
  templateUrl: './enrollment-feature.component.html',
  styleUrl: './enrollment-feature.component.css'
})
export class EnrollmentFeatureComponent implements OnInit{
  private readonly enrollmentService = inject(EnrollmentService);
  private readonly destroyRef = inject(DestroyRef);
  enrollments: EnrollmentDetailDto[] = []
  dataSource = new MatTableDataSource<EnrollmentDetailDto>();
  displayedColumns: string[] = ['studentName', 'studentGrade', 'courseName', 'courseMaxStudents'] ;

  ngOnInit() {
    this.enrollmentService.getEnrollments().pipe(takeUntilDestroyed(this.destroyRef)).subscribe({
      next: val => {
        this.enrollments = val;
        this.dataSource.data = this.enrollments;
      }
    })
  }

  getResults() {
    const courseGroups = {};
    this.enrollments.forEach(enrollment => {

      if (!courseGroups[enrollment.courseName]) {
        courseGroups[enrollment.courseName] = [];
      }
      courseGroups[enrollment.courseName].push(enrollment);
    });


    const transformedEnrollments: any[][] = [];
    Object.keys(courseGroups).forEach(courseName => {
      const courseMaxStudents = courseGroups[courseName][0].courseMaxStudents;
      const sortedStudents = courseGroups[courseName].sort((a, b) => b.studentGrade - a.studentGrade);
      sortedStudents.forEach((student: { studentName: any; studentGrade: any; }, index: number) => {
        const status = index < courseMaxStudents ? 'ACCEPTED' : 'REJECTED';
        transformedEnrollments.push([student.studentName, student.studentGrade, courseName, status]);
      });
    });

    console.log(transformedEnrollments);
    transformedEnrollments.sort((a, b) => a[0].localeCompare(b[0]));

    const doc = new jsPDF()
    autoTable(doc, { html: '#my-table' })
    autoTable(doc, {
      head: [['Name', 'Grade', 'Course', 'Status']],
      body: transformedEnrollments
    })
    doc.save('results.pdf')
  }
}
