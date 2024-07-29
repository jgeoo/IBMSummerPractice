import {Routes} from "@angular/router";
import {AdminFeatureComponent} from "./admin-feature.component";

export const adminRoutes: Routes = [
    {
        path: '',
        component: AdminFeatureComponent,
        children: [
            {
                path: 'courses',
                loadChildren: () => import("../course-feature/course.routes").then(m => m.courseRoutes)
            }
        ]
    }
]