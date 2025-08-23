import {Consequence} from './consequence.model';
import {User} from './user.model';
import {ItemDescription} from './item-description.model';

export enum ChoerbliStatus {
  VOTING = 'VOTING',
  ASSIGNING = 'ASSIGNING',
  DONE = 'DONE',
}

export type SummaryItem = {
  user: User;
  rank: number;
  consequence: Consequence;
}
export type Item = {
  id: string;
  choerbli: Choerbli;
  user: User;
  points: number;
  price: number;
  itemDescription: ItemDescription;
}

export type Summary = {
  choerbli: Choerbli;
  userSummaries: SummaryItem[]
  items: Item[],
}


export type Choerbli = {
  name: string;
  description: string;
  startDate: Date | undefined;
  endDate: Date | undefined;
  id: string;
  votes: [],
  items: []
  state: ChoerbliStatus | undefined;
  consequences: Consequence[];
}
