import {Vote} from './vote.model';

export type RemainingVotes = Record<string, number>;

export interface UserVoteInfo {
  userId: string;
  votes: Vote[];
  remainingVotes: RemainingVotes; // or Map<string, number> if you convert it
}
