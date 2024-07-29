import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-course-feature',
  standalone: true,
    imports: [
        RouterOutlet
    ],
  templateUrl: './course-feature.component.html',
  styleUrl: './course-feature.component.css'
})
export class CourseFeatureComponent {

}
