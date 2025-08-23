export enum ChoerbliStatus {
  VOTING = 'VOTING',
  ASSIGNING = 'ASSIGNING',
  DONE = 'DONE',
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
}
