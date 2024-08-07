import {Routes} from '@angular/router';
import {StudentFeatureComponent} from "./student-feature.component";
import {ElectivesPageComponent} from "./pages/electives-page/electives-page.component";
import {CreateStudentPageComponent} from "./pages/create-student-page/create-student-page.component";

export const studentRoutes: Routes = [
  {
    path: '',
    component: StudentFeatureComponent,
    children: [
      {
        path: '',
        component: CreateStudentPageComponent
      },
      {
        path: 'electives',
        component: ElectivesPageComponent
      }
    ]
  }
]
