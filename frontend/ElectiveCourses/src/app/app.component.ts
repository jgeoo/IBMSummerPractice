import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-root',
  standalone: true,
    imports: [RouterOutlet, MatButton, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ElectiveCourses';
}
