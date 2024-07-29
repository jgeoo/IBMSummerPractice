import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-student-feature',
  standalone: true,
    imports: [
        RouterOutlet
    ],
  templateUrl: './student-feature.component.html',
  styleUrl: './student-feature.component.css'
})
export class StudentFeatureComponent {

}
