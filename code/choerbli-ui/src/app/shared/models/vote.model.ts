import {ItemDescription} from './item-description.model';
import {Choerbli} from './choerbli.model';
import {User} from './user.model';

export type Vote = {
  user: User,
  choerbli: Choerbli,
  itemDescription: ItemDescription,
  factor: number
}
