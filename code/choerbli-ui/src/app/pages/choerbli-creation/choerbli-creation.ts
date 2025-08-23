import {Component, inject} from '@angular/core';
import {Step, StepList, StepPanel, StepPanels, Stepper} from 'primeng/stepper';
import {NgClass} from '@angular/common';
import {Button, ButtonDirective} from 'primeng/button';
import {ChoerbliForm} from '../../shared/components/choerbli-form/choerbli-form';
import {UserForm} from '../../shared/components/user-form/user-form';
import {ActivatedRoute, Router} from '@angular/router';
import {Popover} from 'primeng/popover';
import {InputGroup} from 'primeng/inputgroup';
import {InputGroupAddon} from 'primeng/inputgroupaddon';
import {InputText} from 'primeng/inputtext';

@Component({
  selector: 'app-choerbli-creation',
  imports: [
    Stepper,
    StepList,
    Step,
    NgClass,
    StepPanels,
    StepPanel,
    Button,
    ChoerbliForm,
    UserForm,
    Popover,
    InputGroup,
    InputGroupAddon,
    InputText,
    ButtonDirective
  ],
  templateUrl: './choerbli-creation.html',
  styleUrl: './choerbli-creation.scss'
})
export class ChoerbliCreation {
  constructor() {}
  activeStep: number = 1;
  choerbliId: string = 'randomUUID12356';
  private router = inject(Router);
  members = [
    { name: 'Amy Elsner', image: 'amyelsner.png', email: 'amy@email.com', role: 'Owner' },
    { name: 'Bernardo Dominic', image: 'bernardodominic.png', email: 'bernardo@email.com', role: 'Editor' },
    { name: 'Ioni Bowcher', image: 'ionibowcher.png', email: 'ioni@email.com', role: 'Viewer' }
  ];

  get link(): string{
    const baseURL = 'http://localhost:4200/';
    return baseURL+'/choerbli/'+this.choerbliId
  }

  navigateToChoerbli() {
    this.router.navigate(['/choerbli', this.choerbliId]);
  }
}
