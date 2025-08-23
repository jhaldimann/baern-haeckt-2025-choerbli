import {Component, input} from '@angular/core';
import {Input} from 'postcss';

@Component({
  selector: 'app-item',
  imports: [],
  templateUrl: './item.html',
  styleUrl: './item.scss'
})
export class Item {
  name = input('');
}
