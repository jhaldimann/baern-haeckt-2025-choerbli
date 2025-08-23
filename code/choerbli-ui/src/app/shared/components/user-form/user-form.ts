import {Component, inject, Input} from '@angular/core';
import {InputText} from "primeng/inputtext";
import {User} from '../../models/user.model';
import {FormsModule} from '@angular/forms';
import {ChoerbliStore} from '../../stores/choerbli-store';

@Component({
  selector: 'app-user-form',
  imports: [
    InputText,
    FormsModule
  ],
  templateUrl: './user-form.html',
  styleUrl: './user-form.scss'
})
export class UserForm {
  @Input() user!: User;

}
