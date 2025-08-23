import {ChangeDetectionStrategy, Component, effect, inject, Signal} from '@angular/core';
import {NgOptimizedImage} from '@angular/common';
import {Menubar} from 'primeng/menubar';
import {Avatar} from 'primeng/avatar';
import {RouterLink} from '@angular/router';
import {UserStore} from '../../stores/user-store';

@Component({
  selector: 'app-header',
  imports: [
    NgOptimizedImage,
    Menubar,
    Avatar,
    RouterLink
  ],
  templateUrl: './header.html',
  styleUrl: './header.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class Header {
  readonly userStore = inject(UserStore);
  get userName(): string {
    return this.userStore.user.name();
  }
}
