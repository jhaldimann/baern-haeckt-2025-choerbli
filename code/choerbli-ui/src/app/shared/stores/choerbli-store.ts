import {Choerbli} from '../models/choerbli.model';
import {patchState, signalStore, signalStoreFeature, withMethods, withState} from '@ngrx/signals';

type ChoerbliState = {
    choerbli: Choerbli | undefined;
    isLoading: boolean;
  };

  const initialState: ChoerbliState = {
    choerbli: undefined,
    isLoading: false,
  };

  export const ChoerbliStore = signalStore(
    { providedIn: 'root' },
    withState(initialState),
    withChoerbliMethods(),
  );

  export function withChoerbliMethods() {
    return signalStoreFeature(
      withMethods((store) => ({
            loadChoerbli(id: string) {
              const choerbli:Choerbli = {description: '', endDate: new Date(), name: '', startDate: new Date()}; // TODO: get choerbli from BE
              patchState(store, { ...choerbli });
            },
            createChoerbli(choerbli: Choerbli) {
              // TODO: api call to BE to create Choerbli
            }
          }
        )
      ))
  }

