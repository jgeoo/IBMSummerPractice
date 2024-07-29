import {Routes} from "@angular/router";
import {AdminFeatureComponent} from "./admin-feature.component";
import {TeacherFeatureComponent} from "../teacher-feature/teacher-feature.component";
import {teacherRoutes} from "../teacher-feature/teacher.routes";

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

            }
        ]
    }
]
