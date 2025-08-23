import {Choerbli} from '../models/choerbli.model';
import {patchState, signalStore, signalStoreFeature, withMethods, withState} from '@ngrx/signals';
import {inject} from '@angular/core';
import {ChoerbliApiService} from '../services/choerbli-api.service';
import {finalize} from 'rxjs';

type ChoerbliState = {
  choerbli: Choerbli;
  isLoading: boolean;
};
const initialState: ChoerbliState = {
  choerbli: {
    name: "",
    description: "",
    startDate: undefined,
    endDate: undefined,
    id: "",
    votes: [],
    items: [],
    state: undefined,
    consequences: []
  },
  isLoading: false,
};

export const ChoerbliStore = signalStore(
  {providedIn: 'root'},
  withState(initialState),
  withChoerbliMethods(),
);

export function withChoerbliMethods() {
  return signalStoreFeature(
    withMethods((store, choerbliApiService = inject(ChoerbliApiService)) => ({
          setChoerbliId(id: string) {
            patchState(store, {choerbli: {id: id}});
          },
        loadChoerbliById(id: string) {
            patchState(store, {isLoading: true})
            choerbliApiService.getChoerbli(id).pipe(
            finalize(() => patchState(store, {isLoading: false})),
          ).subscribe((response: Choerbli) => {
              patchState(store, {choerbli: response})
            }
          )
            patchState(store, {choerbli: {id: id}});
          },
          createChoerbli(choerbli: Choerbli): void {
            patchState(store, {isLoading: true})
            choerbliApiService.createChoerbli(choerbli).pipe(
              finalize(() => patchState(store, {isLoading: false})),
            ).subscribe((response: Choerbli) => {
                patchState(store, {choerbli: response})
              }
            )
          },
        }
      )
    ))
}

