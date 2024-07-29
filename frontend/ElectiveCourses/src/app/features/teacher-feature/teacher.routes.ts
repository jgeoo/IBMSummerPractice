import {Routes} from "@angular/router";
import {TeacherPageComponent} from "./pages/teacher-page/teacher-page.component";
import {AddTeacherPageComponent} from "./pages/add-teacher-page/add-teacher-page.component";
import {TeacherFeatureComponent} from "./teacher-feature.component";


export const teacherRoutes: Routes = [
  {
    path: '',
    component: TeacherFeatureComponent,
  }
]
