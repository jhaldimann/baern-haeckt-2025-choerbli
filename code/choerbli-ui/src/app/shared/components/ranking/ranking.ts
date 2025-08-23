import {Component, inject, OnInit} from '@angular/core';
import {ChoerbliStore} from '../../stores/choerbli-store';
import {SummaryItem} from '../../models/choerbli.model';
import {TableModule} from 'primeng/table';
import {Card} from 'primeng/card';


@Component({
  selector: 'app-ranking',
  imports: [
    TableModule,
    Card
  ],
  templateUrl: './ranking.html',
  styleUrl: './ranking.scss'
})
export class Ranking implements OnInit {
  readonly choerbliStore = inject(ChoerbliStore);

  ngOnInit(): void {
    this.choerbliStore.getSummary(this.choerbliStore.choerbli().id);
  }

  get sortedSummaries(): SummaryItem[] {
    return this.choerbliStore.summary().userSummaries.sort((a, b) => a.rank - b.rank);
  }
}
