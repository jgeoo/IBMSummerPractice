import {Component, DestroyRef, inject} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {DialogData} from "../../pages/electives-page/electives-page.component";
import {takeUntilDestroyed} from "@angular/core/rxjs-interop";
import {EnrollmentService} from "../../../../core/services/http/enrollment.service";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-enroll-dialog',
  standalone: true,
  imports: [
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButton
  ],
  templateUrl: './enroll-dialog.component.html',
  styleUrl: './enroll-dialog.component.css'
})
export class EnrollDialogComponent {
  private readonly enrollmentService = inject(EnrollmentService);
  private readonly destroyRef  = inject(DestroyRef)
  readonly dialogRef = inject(MatDialogRef<EnrollDialogComponent>);
  readonly data = inject<DialogData>(MAT_DIALOG_DATA);

  onNoClick(): void {
    this.dialogRef.close();
  }

  enroll() {
    this.enrollmentService.createEnrollment({
      courseId: this.data.course.id,
      status: 0,
      studentId: this.data.studentId
    }).pipe(takeUntilDestroyed(this.destroyRef)).subscribe({
      next:(val) => {
        this.dialogRef.close(val);
      }
    })
  }
}
