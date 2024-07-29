import {Routes} from "@angular/router";
import {StudentFeatureComponent} from "./student-feature.component";

export const studentRoutes: Routes = [
    {
        path: '',
        component: StudentFeatureComponent,
        children: []
    }
]