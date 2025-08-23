import {Component, inject} from '@angular/core';
import {Step, StepList, StepPanel, StepPanels, Stepper} from 'primeng/stepper';
import {NgClass} from '@angular/common';
import {Button, ButtonDirective} from 'primeng/button';
import {ChoerbliForm} from '../../shared/components/choerbli-form/choerbli-form';
import {UserForm} from '../../shared/components/user-form/user-form';
import {Router} from '@angular/router';
import {Popover} from 'primeng/popover';
import {InputGroup} from 'primeng/inputgroup';
import {InputGroupAddon} from 'primeng/inputgroupaddon';
import {InputText} from 'primeng/inputtext';
import {LottieAnimation} from '../../shared/components/lottie-animation/lottie-animation';
import {UserStore} from '../../shared/stores/user-store';
import {ChoerbliStore} from '../../shared/stores/choerbli-store';
import {Choerbli} from '../../shared/models/choerbli.model';
import {User} from '../../shared/models/user.model';
import {Consequence} from '../../shared/models/consequence.model';
import {ConsequenceStep} from '../../shared/components/consequence-step/consequence-step';
import {ConsequenceApiService} from '../../shared/services/consequence-api.service';

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
    ButtonDirective,
    LottieAnimation,
    ConsequenceStep
  ],
  providers: [UserStore],
  templateUrl: './choerbli-creation.html',
  styleUrl: './choerbli-creation.scss'
})
export class ChoerbliCreation {

  choerbli: Choerbli = {
    consequences: [],
    state: undefined,
    items: [], votes: [], id: '', description: '', endDate: new Date(), name: '', startDate: new Date()
  };
  user: User = {email: '', id: '', name: '', choerbliId: ''};
  activeStep: number = 1;
  punishments: Consequence[] = [];
  rewards: Consequence[] = [];
  private router: Router = inject(Router);
  members = [
    {name: 'Amy Elsner', image: 'amyelsner.png', email: 'amy@email.com', role: 'Owner'},
    {name: 'Bernardo Dominic', image: 'bernardodominic.png', email: 'bernardo@email.com', role: 'Editor'},
    {name: 'Ioni Bowcher', image: 'ionibowcher.png', email: 'ioni@email.com', role: 'Viewer'}
  ];
  readonly choerbliStore = inject(ChoerbliStore);
  readonly userStore = inject(UserStore);
  readonly consequenceApiService = inject(ConsequenceApiService);

  get link(): string {
    const baseURL = 'http://localhost:4200/';
    return baseURL + 'choerbli/' + this.choerbliStore.choerbli()?.id
  }

  navigateToChoerbli(): void {
    this.router.navigate(['/choerbli', this.choerbliStore.choerbli()?.id])
      .then(() => {
        window.location.reload();
      });
  }

  copyLinkToClipboard(): void {
    navigator.clipboard.writeText(this.link);
  }

  createChoerbli() {
    this.choerbliStore.createChoerbli(this.choerbli);
    this.activeStep = 2;
  }

  createConsequences() {
    const consequences = [...this.rewards,...this.punishments];
    this.consequenceApiService.createConsequences(consequences).subscribe();
    this.activeStep = 3;
  }

  createUser() {
    this.user.choerbliId = this.choerbliStore.choerbli()?.id ?? '';
    this.userStore.createUser(this.user);
    this.activeStep = 4;
  }
}
