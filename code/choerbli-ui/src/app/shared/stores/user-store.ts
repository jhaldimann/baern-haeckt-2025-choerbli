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
          clearUser() {
            storageService.clear();
            patchState(store, { user: initialState.user });
          },
          createUser(user: User): void {
            userApiService.createUser(user).subscribe((response: any): void => {
              let user: User = {name: response.name, id: response.id,
                  email: response.email,
                  choerbliId: response.choerbli.id}

              storageService.setItem(USER_KEY, user);
              patchState(store, {user: user});
              }
            )
          }
        }
      )
    ))
}
