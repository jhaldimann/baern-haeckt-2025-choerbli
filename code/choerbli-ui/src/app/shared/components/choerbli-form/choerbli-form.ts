import {Component, Input} from '@angular/core';
import {DatePicker} from "primeng/datepicker";
import {InputText} from "primeng/inputtext";
import {Textarea} from "primeng/textarea";
import {Choerbli} from '../../models/choerbli.model';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-choerbli-form',
  imports: [
    DatePicker,
    InputText,
    Textarea,
    FormsModule
  ],
  templateUrl: './choerbli-form.html',
  styleUrl: './choerbli-form.scss'
})
export class ChoerbliForm {
  @Input() choerbli!: Choerbli;

}
