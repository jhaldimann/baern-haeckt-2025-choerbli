import {Component, inject} from '@angular/core';
import {ChoerbliStore} from '../../stores/choerbli-store';
import {JsonPipe} from '@angular/common';
import {Accordion, AccordionContent, AccordionHeader, AccordionPanel} from 'primeng/accordion';

@Component({
  selector: 'app-assigning-form',
  imports: [
    JsonPipe,
    AccordionContent,
    AccordionHeader,
    AccordionPanel,
    Accordion
  ],
  templateUrl: './assigning-form.html',
  styleUrl: './assigning-form.scss'
})
export class AssigningForm {
  readonly choerbliStore = inject(ChoerbliStore);

}
