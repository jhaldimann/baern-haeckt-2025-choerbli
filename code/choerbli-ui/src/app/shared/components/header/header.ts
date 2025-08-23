import {Component} from '@angular/core';
import {NgOptimizedImage} from '@angular/common';
import {Menubar} from 'primeng/menubar';
import {Avatar} from 'primeng/avatar';
import {MenuItem} from 'primeng/api';
import {InputText} from 'primeng/inputtext';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [
    NgOptimizedImage,
    Menubar,
    Avatar,
    InputText,
    RouterLink
  ],
  templateUrl: './header.html',
  styleUrl: './header.scss'
})
export class Header {
  items: MenuItem[] = [];

}
