import {AfterViewInit, Component, DestroyRef, inject, OnInit, ViewChild} from '@angular/core';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow, MatRowDef, MatTable, MatTableDataSource
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
import {AsyncPipe, JsonPipe} from "@angular/common";

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
    JsonPipe
  ],
  templateUrl: './electives-page.component.html',
  styleUrl: './electives-page.component.css'
})
export class ElectivesPageComponent implements OnInit, AfterViewInit{
  private readonly courseService = inject(CourseService);
  private readonly destroyRef  = inject(DestroyRef)
   student$ = inject(StudentStateService).getAsObservable();
  courses : CourseDto[] = []
  dataSource = new MatTableDataSource<CourseDto>();
  displayedColumns: string[] = ['name', 'dayOfWeek', 'yearOfStudy', 'maxStudents', 'hours', 'actions'] ;
  ngOnInit() {
    this.courseService.getAllCourses().pipe(takeUntilDestroyed(this.destroyRef)).subscribe({
      next: value => {
        this.courses = value
        this.dataSource.data = this.courses;
      }
    })
  }
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
}
