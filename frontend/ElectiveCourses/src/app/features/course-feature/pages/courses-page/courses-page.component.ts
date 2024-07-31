import {AfterViewInit, Component, DestroyRef, inject, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CourseDto} from "../../../../core/dto/course/CourseDto";
import {CourseService} from "../../../../core/services/http/course.service";
import {JsonPipe} from "@angular/common";
import {MatButton, MatIconButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow, MatHeaderRowDef,
  MatRow, MatRowDef,
  MatTable, MatTableDataSource
} from "@angular/material/table";
import {MatIcon} from "@angular/material/icon";
import {takeUntilDestroyed} from "@angular/core/rxjs-interop";
import {MatPaginator} from "@angular/material/paginator";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";

@Component({
  selector: 'app-courses-page',
  standalone: true,
  imports: [
    JsonPipe,
    MatButton,
    RouterLink,
    MatTable,
    MatColumnDef,
    MatHeaderCell,
    MatCell,
    MatHeaderRow,
    MatRow,
    MatCellDef,
    MatHeaderCellDef,
    MatHeaderRowDef,
    MatRowDef,
    MatIconButton,
    MatIcon,
    MatPaginator,
    MatFormField,
    MatInput,
    MatLabel
  ],
  templateUrl: './courses-page.component.html',
  styleUrl: './courses-page.component.css'
})
export class CoursesPageComponent implements OnInit, AfterViewInit {
    private readonly courseService = inject(CourseService);
    private readonly destroyRef  = inject(DestroyRef)
    courses : CourseDto[] = []
    dataSource = new MatTableDataSource<CourseDto>();
    displayedColumns: string[] = ['name', 'dayOfWeek', 'yearOfStudy', 'maxStudents', 'actions'];
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
    onDelete(id: number) {
      this.courseService.deleteCourse(id).pipe(takeUntilDestroyed(this.destroyRef)).subscribe({
        next: value => {
          this.courses = this.courses.filter(c => {
            if(c.id == id) {
              return false
            } else {
              return true;
            }
          })
          this.dataSource.data = this.courses;
        }
      })
    }
}
