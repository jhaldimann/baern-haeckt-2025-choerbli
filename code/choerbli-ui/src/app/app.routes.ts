import {Routes} from '@angular/router';
import {Dashboard} from './pages/dashboard/dashboard';
import {ChoerbliCreation} from './pages/choerbli-creation/choerbli-creation';
import {Choerbli} from './pages/choerbli/choerbli';

export const routes: Routes = [
  { path: 'creation', component: ChoerbliCreation },
  { path: 'choerbli/:id', component: Choerbli },
  { path: '', component: Dashboard },
];
