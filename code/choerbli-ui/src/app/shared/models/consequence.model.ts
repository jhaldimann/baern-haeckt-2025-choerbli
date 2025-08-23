export enum ConsequenceType {
  PUNISHMENT = 'PUNISHMENT',
  REWARD = 'REWARD',
}

export type Consequence = {
  id: string;
  description: string;
  orderOfApplication: number;
  type: ConsequenceType,
  choerbliId: string;
}
