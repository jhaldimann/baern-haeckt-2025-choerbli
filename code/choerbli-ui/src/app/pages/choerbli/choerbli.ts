import {Component, inject, OnInit} from '@angular/core';
import {Item} from './item/item';
import {AsyncPipe, LowerCasePipe} from '@angular/common';
import {ItemDescriptionApiService} from '../../shared/services/item-description-api.service';
import {BehaviorSubject, Observable, of, take} from 'rxjs';
import {ItemDescription} from '../../shared/models/item-description.model';

@Component({
  selector: 'app-choerbli',
  imports: [
    Item,
    LowerCasePipe,
    AsyncPipe
  ],
  templateUrl: './choerbli.html',
  styleUrl: './choerbli.scss'
})
export class Choerbli implements OnInit {
  itemDescriptionApiService: ItemDescriptionApiService = inject(ItemDescriptionApiService);
  items: BehaviorSubject<ItemDescription[]> = new BehaviorSubject<ItemDescription[]>([]);
  id: string = '';

  ngOnInit(): void {
    this.id = window.location.pathname.split('/')[2];
    this.itemDescriptionApiService.getItemDescription().pipe(take(1)).subscribe(data => {
      this.items.next(data);
    });
  }

  getAllItemCategories(items: any): Set<string> {
    let categories: Set<string> = new Set<string>();
    items.forEach((item: any): void => {
      categories.add(item.category.name);
    })
    return categories;
  }
}
