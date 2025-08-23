import {Component, inject, Input} from '@angular/core';
import {Consequence, ConsequenceType} from '../../models/consequence.model';
import {ChoerbliStore} from '../../stores/choerbli-store';
import {FormsModule} from '@angular/forms';
import {InputText} from 'primeng/inputtext';
import {Button} from 'primeng/button';
import {InputGroup} from 'primeng/inputgroup';
import {InputGroupAddon} from 'primeng/inputgroupaddon';

@Component({
  selector: 'app-consequence-form',
  imports: [
    FormsModule,
    InputText,
    Button,
    InputGroup,
    InputGroupAddon
  ],
  templateUrl: './consequence-form.html',
  styleUrl: './consequence-form.scss'
})
export class ConsequenceForm {
  @Input() consequences!: Consequence[];
  @Input() title!: string;
  readonly choerbliStore = inject(ChoerbliStore);
  description: string = '';

  get sortedConsequences(): Consequence[] {
    return this.consequences.sort((a, b) => {
      return a.orderOfApplication - b.orderOfApplication;
    })
  }

  addItem(): void {
    this.consequences.push({
      choerbliId: this.choerbliStore.choerbli()?.id,
      description: this.description,
      id: '',
      orderOfApplication: this.consequences.length + 1,
      type: ConsequenceType.REWARD
    });
    this.description = '';
  }

  removeItem(consequence: Consequence) {
    let index = this.consequences.indexOf(consequence)
    this.consequences.splice(
      index, 1
    );
    this.consequences.forEach((consequence: Consequence) => {
      if (consequence.orderOfApplication > index + 1) {
        consequence.orderOfApplication--;
      }
    })
  }
}
