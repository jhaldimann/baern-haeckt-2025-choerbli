import {Choerbli} from '../models/choerbli.model';
import {patchState, signalStore, signalStoreFeature, withMethods, withState} from '@ngrx/signals';
import {inject} from '@angular/core';
import {ChoerbliApiService} from '../services/choerbli-api.service';
import {finalize} from 'rxjs';

type ChoerbliState = {
  choerbli: Choerbli | undefined;
  isLoading: boolean;
  isSaved: boolean;
};

const initialState: ChoerbliState = {
  choerbli: undefined,
  isLoading: false,
  isSaved: false,
};

export const ChoerbliStore = signalStore(
  {providedIn: 'root'},
  withState(initialState),
  withChoerbliMethods(),
);

export function withChoerbliMethods() {
  return signalStoreFeature(
    withMethods((store, choerbliApiService = inject(ChoerbliApiService)) => ({
          loadChoerbli(id: string) {
            const choerbli: Choerbli = {description: '', endDate: new Date(), name: '', startDate: new Date()}; // TODO: get choerbli from BE
            patchState(store, {...choerbli});
          },
          createChoerbli(choerbli: Choerbli): void {
            patchState(store, {isLoading: true})
            choerbliApiService.createChoerbli(choerbli).pipe(
              finalize(() => patchState(store, {isLoading: false, isSaved: true})),
            ).subscribe(() => {
                patchState(store, {choerbli, isSaved: true})
              }
            )

          }
        }
      )
    ))
}

