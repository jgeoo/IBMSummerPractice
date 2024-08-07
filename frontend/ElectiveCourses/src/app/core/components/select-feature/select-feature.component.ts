import {Component} from '@angular/core';
import {MatButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-select-feature',
  standalone: true,
  imports: [
    MatButton,
    RouterLink
  ],
  templateUrl: './select-feature.component.html',
  styleUrl: './select-feature.component.css'
})
export class SelectFeatureComponent {

}
