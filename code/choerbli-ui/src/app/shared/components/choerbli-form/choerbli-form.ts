import {Component} from '@angular/core';
import {DatePicker} from "primeng/datepicker";
import {InputText} from "primeng/inputtext";
import {Textarea} from "primeng/textarea";

@Component({
  selector: 'app-choerbli-form',
  imports: [
    DatePicker,
    InputText,
    Textarea
  ],
  templateUrl: './choerbli-form.html',
  styleUrl: './choerbli-form.scss'
})
export class ChoerbliForm {

}
