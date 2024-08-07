import {Routes} from '@angular/router';

export const routes: Routes = [
  {
    path: 'student',
    loadChildren: () => import("./features/student-feature/student.routes").then(m => m.studentRoutes)
  },
  {
    path: 'admin',
    loadChildren: () => import("./features/admin-feature/admin.routes").then(m => m.adminRoutes)
  }
];
