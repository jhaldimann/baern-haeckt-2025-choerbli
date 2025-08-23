import {User} from '../models/user.model';
import {patchState, signalStore, signalStoreFeature, withHooks, withMethods, withState} from '@ngrx/signals';
import {inject} from '@angular/core';
import {LocalStorageService} from '../services/local-storage.service';
import {UserApiService} from '../services/user-api.service';
import {finalize} from 'rxjs';


type UserState = {
  user: User;
  isLoading: boolean;
};

const initialState: UserState = {
  user: {
    id: "",
    name: "",
    email: "",
    choerbliId: ""
  },
  isLoading: false,
};

const USER_KEY = 'USER'

export const UserStore = signalStore(
  { providedIn: 'root' },
  withState(initialState),
  withUserMethods(),
  withHooks({
    onInit: (store): void => {
      store.loadUserFromLocalStorage();
    },
  })
);

export function withUserMethods() {
  return signalStoreFeature(
    withMethods((store, storageService = inject(LocalStorageService), userApiService = inject(UserApiService)) => ({
          loadUserFromLocalStorage() {
            const state: UserState | null = storageService.getItem(USER_KEY);
            if (state) {
              patchState(store, { user: state });
            }
          },
          createUser(user: User): void {
            patchState(store, {isLoading: true})
            userApiService.createUser(user).pipe(
              finalize((): void => patchState(store, {isLoading: false})),
            ).subscribe((response: User): void => {
                patchState(store, {user: response});
                storageService.setItem(USER_KEY, response);
              }
            )
          }
        }
      )
    ))
}
