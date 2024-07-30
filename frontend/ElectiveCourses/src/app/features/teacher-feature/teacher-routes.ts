import {Routes} from "@angular/router";
import {TeacherFeatureComponent} from "./teacher-feature.component";
import {TeacherPageComponent} from "./pages/teacher-page/teacher-page.component";


export const teacherRoutes: Routes = [
  {
    path: '',
    component: TeacherFeatureComponent,
    children:[{

      path: '',
      component: TeacherPageComponent
      },

    ]
  }
]
