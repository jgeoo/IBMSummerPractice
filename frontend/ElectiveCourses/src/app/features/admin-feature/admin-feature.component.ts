import {Component} from '@angular/core';
import {RouterLink, RouterOutlet} from "@angular/router";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-admin-feature',
  standalone: true,
  imports: [
    RouterOutlet,
    MatButton,
    RouterLink
  ],
  templateUrl: './admin-feature.component.html',
  styleUrl: './admin-feature.component.css'
})
export class AdminFeatureComponent {

}
