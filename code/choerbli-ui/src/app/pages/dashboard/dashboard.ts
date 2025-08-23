import {Component, inject} from '@angular/core';
import {Panel} from 'primeng/panel';
import {NgOptimizedImage} from '@angular/common';
import {Accordion, AccordionContent, AccordionHeader, AccordionPanel} from 'primeng/accordion';
import {Button} from 'primeng/button';
import {Router} from '@angular/router';

@Component({
  selector: 'app-dashboard',
  imports: [
    Panel,
    NgOptimizedImage,
    Accordion,
    AccordionPanel,
    AccordionHeader,
    AccordionContent,
    Button
  ],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss'
})
export class Dashboard {
  private router = inject(Router);

  navigateToCreation() {
    this.router.navigate(['/creation']);
  }
}
