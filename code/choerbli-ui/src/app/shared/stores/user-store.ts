import {User} from '../models/user.model';
import {patchState, signalStore, signalStoreFeature, withHooks, withMethods, withState} from '@ngrx/signals';
import {inject} from '@angular/core';
import {LocalStorageService} from '../services/local-storage.service';
import {UserApiService} from '../services/user-api.service';
import {finalize} from 'rxjs';
import {Choerbli} from '../models/choerbli.model';
import {ChoerbliStore} from './choerbli-store';


type UserState = {
  user: User | undefined;
  isLoading: boolean;
};

const initialState: UserState = {
  user: undefined,
  isLoading: false,
};

const USER_KEY = 'USER'

export const UserStore = signalStore(
  { providedIn: 'root' },
  withState(initialState),
  withUserMethods(),
  withHooks({
    onInit: (store) => {
      store.loadUserFromLocalStorage();
    },
  })
);

export function withUserMethods() {
  return signalStoreFeature(
    withMethods((store, storageService = inject(LocalStorageService), userApiService = inject(UserApiService)) => ({
          loadUserFromLocalStorage() {
            const state: UserState | null = storageService.getItem(USER_KEY);
            patchState(store, { ...state });
          },
          createUser(user: User) {
            patchState(store, {isLoading: true})
            userApiService.createUser(user).pipe(
              finalize(() => patchState(store, {isLoading: false})),
            ).subscribe((response: User) => {
                patchState(store, {user: response})
                storageService.setItem(USER_KEY, user);
              }
            )
          }
        }
      )
    ))
}
