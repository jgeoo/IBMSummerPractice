import {Routes} from "@angular/router";
import {AdminFeatureComponent} from "./admin-feature.component";
import {testRoutes} from "../test-feature/test.routes";
import {teacherRoutes} from "../teacher-feature/teacher-routes";
import {EnrollmentFeatureComponent} from "../enrollment-feature/enrollment-feature.component";


export const adminRoutes: Routes = [
    {
        path: '',
        component: AdminFeatureComponent,
        children: [
            {
                path: 'courses',
                loadChildren: () => import("../course-feature/course.routes").then(m => m.courseRoutes)
            },
            {
                path: 'teachers',
                children: [...teacherRoutes]
            },
          {
            path: 'enrollments',
            component: EnrollmentFeatureComponent
          }
        ]
    }
]
