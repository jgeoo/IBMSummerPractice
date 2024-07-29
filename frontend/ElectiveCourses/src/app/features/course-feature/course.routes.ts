import {Routes} from "@angular/router";
import {CourseFeatureComponent} from "./course-feature.component";
import {CoursesPageComponent} from "./pages/courses-page/courses-page.component";
import {AddCoursePageComponent} from "./pages/add-course-page/add-course-page.component";

export const courseRoutes: Routes = [
    {
        path: '',
        component: CourseFeatureComponent,
        children: [
            {
                path: '',
                component: CoursesPageComponent
            },
            {
                path: 'add',
                component: AddCoursePageComponent
            }
        ]
    }
]