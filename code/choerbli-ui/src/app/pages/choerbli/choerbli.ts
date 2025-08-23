import {Component, OnInit} from '@angular/core';
import {Item} from './item/item';
import {LowerCasePipe} from '@angular/common';

@Component({
  selector: 'app-choerbli',
  imports: [
    Item,
    LowerCasePipe
  ],
  templateUrl: './choerbli.html',
  styleUrl: './choerbli.scss'
})
export class Choerbli implements OnInit {
  id: string = '';
  items: any = [
    {
      itemId: 1,
      itemName: 'Beer',
      category: 'Drinks'
    },
    {
      itemId: 2,
      itemName: 'Chips',
      category: 'Snacks'
    },
    {
      itemId: 3,
      itemName: 'Apple',
      category: 'Fruits'
    },
    {
      itemId: 4,
      itemName: 'Flipps',
      category: 'Snacks'
    },
    {
      itemId: 5,
      itemName: 'Juice',
      category: 'Drinks'
    },
    {
      itemId: 6,
      itemName: 'Pears',
      category: 'Fruits'
    },
    {
      itemId: 3,
      itemName: 'Strawberries',
      category: 'Fruits'
    }
  ];

  ngOnInit(): void {
    this.id = window.location.pathname.split('/')[2];
  }

  getAllItemCategories(items: any): Set<string> {
    let categories: Set<string> = new Set<string>();
    items.forEach((item: any): void => {
      categories.add(item.category);
    })
    return categories;
  }
}
