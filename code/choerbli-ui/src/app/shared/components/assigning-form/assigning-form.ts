import {Component, inject, OnInit} from '@angular/core';
import {ChoerbliStore} from '../../stores/choerbli-store';
import {Accordion, AccordionContent, AccordionHeader, AccordionPanel} from 'primeng/accordion';
import {Item} from '../../models/choerbli.model';
import {Card} from 'primeng/card';
import {Checkbox} from 'primeng/checkbox';
import {FormsModule} from '@angular/forms';
import {Badge} from 'primeng/badge';
import {ItemDescriptionApiService} from '../../services/item-description-api.service';
import {UserStore} from '../../stores/user-store';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-assigning-form',
  imports: [
    AccordionContent,
    AccordionHeader,
    AccordionPanel,
    Accordion,
    Card,
    Checkbox,
    FormsModule,
    Badge,
    NgClass
  ],
  templateUrl: './assigning-form.html',
  styleUrl: './assigning-form.scss'
})
export class AssigningForm implements OnInit {
  readonly choerbliStore = inject(ChoerbliStore);
  readonly userStore = inject(UserStore);
  readonly itemDescriptionApiService = inject(ItemDescriptionApiService);
  ngOnInit(): void {
    this.choerbliStore.getSummary(this.choerbliStore.choerbli().id);
  }

  getAllItemCategories(items: any): string[] {
    let categories: Set<string> = new Set<string>();
    items.forEach((item: any): void => {
      categories.add(item.itemDescription.category.name);
    })
    return Array.from(categories).sort((a: any, b: any) => {

      const nameA = a.toUpperCase(); // ignore upper and lowercase
      const nameB = b.toUpperCase(); // ignore upper and lowercase
      if (nameA < nameB) {
        return -1;
      }
      if (nameA > nameB) {
        return 1;
      }

      // names must be equal
      return 0;});
  }

  getAllItemsByCategory(category: string): Item[] {
    let items = this.choerbliStore.summary().items;
    return items.filter((item: any) => item.itemDescription.category.name === category).sort((a: any, b: any) => {

      const nameA = a.itemDescription.name.toUpperCase(); // ignore upper and lowercase
      const nameB = b.itemDescription.name.toUpperCase(); // ignore upper and lowercase
      if (nameA < nameB) {
        return -1;
      }
      if (nameA > nameB) {
        return 1;
      }

      // names must be equal
      return 0;});
  }

  checkItem(item: Item) {
    if(!item.user) {
      this.itemDescriptionApiService.setUserToItem(item.id, this.userStore.user().id).subscribe(() => {
        this.choerbliStore.getSummary(this.choerbliStore.choerbli().id)
      });
    }
  }
}
