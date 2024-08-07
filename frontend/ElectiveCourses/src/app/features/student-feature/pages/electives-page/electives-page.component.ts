import {AfterViewInit, Component, DestroyRef, inject, OnInit, ViewChild} from '@angular/core';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow,
  MatRowDef,
  MatTable,
  MatTableDataSource
} from "@angular/material/table";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatIcon} from "@angular/material/icon";
import {MatIconButton} from "@angular/material/button";
import {MatInput} from "@angular/material/input";
import {MatPaginator} from "@angular/material/paginator";
import {RouterLink} from "@angular/router";
import {CourseService} from "../../../../core/services/http/course.service";
import {CourseDto} from "../../../../core/dto/course/CourseDto";
import {takeUntilDestroyed} from "@angular/core/rxjs-interop";
import {StudentStateService} from "../../services/student-state.service";
import {AsyncPipe, JsonPipe, NgIf} from "@angular/common";
import {EnrollmentService} from "../../../../core/services/http/enrollment.service";
import {MatDialog} from "@angular/material/dialog";
import {EnrollDialogComponent} from "../../components/enroll-dialog/enroll-dialog.component";

export interface TableData {
  dto: CourseDto,
  enrolled: boolean,
  enrollmentId: number
}

export interface DialogData {
  course: CourseDto,
  studentId: number
}

@Component({
  selector: 'app-electives-page',
  standalone: true,
  imports: [
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
    RouterLink,
    MatHeaderCellDef,
    AsyncPipe,
    JsonPipe,
    NgIf
  ],
  templateUrl: './electives-page.component.html',
  styleUrl: './electives-page.component.css'
})
export class ElectivesPageComponent implements OnInit, AfterViewInit {
  readonly dialog = inject(MatDialog);
  student$ = inject(StudentStateService).getAsObservable();
  courses: CourseDto[] = []
  dataSource = new MatTableDataSource<TableData>();
  displayedColumns: string[] = ['name', 'dayOfWeek', 'yearOfStudy', 'maxStudents', 'hours', 'actions'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  private readonly courseService = inject(CourseService);
  private readonly enrollmentService = inject(EnrollmentService);
  private readonly destroyRef = inject(DestroyRef)

  ngOnInit() {
    this.courseService.getAllCourses().pipe(takeUntilDestroyed(this.destroyRef)).subscribe({
      next: value => {
        this.courses = value
        this.dataSource.data = this.courses.map(c => ({
          dto: c,
          enrolled: false,
          enrollmentId: 0
        }));
      }
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  enroll(element: CourseDto, studentId: number) {
    const dialogRef = this.dialog.open(EnrollDialogComponent, {
      data: {course: element, studentId: studentId},
    });

    dialogRef.afterClosed().pipe(takeUntilDestroyed(this.destroyRef)).subscribe(result => {
      console.log('The dialog was closed');
      if (result !== undefined) {
        this.dataSource.data.forEach(c => {
          if (c.dto.id == element.id) {
            c.enrolled = true;
            c.enrollmentId = result.id;
          }
        })
      }
    });

  }

  leave(element: CourseDto, enrollmentId: number) {
    this.enrollmentService.deleteEnrollment(enrollmentId).pipe(takeUntilDestroyed(this.destroyRef)).subscribe({
      next: val => {
        this.dataSource.data.forEach(c => {
          if (c.dto.id == element.id) {
            c.enrolled = false;
          }
        })
      }
    })
  }

}
