import {Component} from '@angular/core';
import {NgOptimizedImage} from '@angular/common';
import {Menubar} from 'primeng/menubar';
import {Avatar} from 'primeng/avatar';
import {MenuItem} from 'primeng/api';
import {InputText} from 'primeng/inputtext';

@Component({
  selector: 'app-header',
  imports: [
    NgOptimizedImage,
    Menubar,
    Avatar,
    InputText
  ],
  templateUrl: './header.html',
  styleUrl: './header.scss'
})
export class Header {
  items: MenuItem[] = [];

}
