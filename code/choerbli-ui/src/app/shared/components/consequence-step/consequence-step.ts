import {Component, Input} from '@angular/core';
import {FloatLabel} from "primeng/floatlabel";
import {InputText} from "primeng/inputtext";
import {ReactiveFormsModule} from "@angular/forms";
import {Consequence} from '../../models/consequence.model';
import {ConsequenceForm} from '../consequence-form/consequence-form';

@Component({
  selector: 'app-consequence-step',
  imports: [
    ReactiveFormsModule,
    ConsequenceForm
  ],
  templateUrl: './consequence-step.html',
  styleUrl: './consequence-step.scss'
})
export class ConsequenceStep {
  @Input() rewards!: Consequence[];
  @Input() punishments!: Consequence[];

}
