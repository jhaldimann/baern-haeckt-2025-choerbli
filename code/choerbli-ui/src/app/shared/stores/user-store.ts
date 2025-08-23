import {User} from '../models/user.model';
import {patchState, signalStore, signalStoreFeature, withHooks, withMethods, withState} from '@ngrx/signals';
import {inject} from '@angular/core';
import {LocalStorageService} from '../services/local-storage.service';


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
    withMethods((store, storageService = inject(LocalStorageService)) => ({
          loadUserFromLocalStorage() {
            const state: UserState | null = storageService.getItem(USER_KEY);
            patchState(store, { ...state });
          },
          saveUserToLocalStorage(user: User) {
            storageService.setItem(USER_KEY, user);
          }
        }
      )
    ))
}
