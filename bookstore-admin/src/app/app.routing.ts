import {ModuleWithProviders} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {AddNewBookComponent} from "./components/add-new-book/add-new-book.component";
import {BookListComponent} from "./components/book-list/book-list.component";
import {ViewBookComponent} from "./components/view-book/view-book.component";

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }, {
    path: 'login',
    component: LoginComponent

  }, {
    path: 'book/add',
    component: AddNewBookComponent
  }, {
        path: 'book/list',
        component: BookListComponent
  }, {
        path: 'book/view/:id',
        component: ViewBookComponent
  }
  /*{
    path: '',
    redirectTo: '',
    pathMatch: ''
  },*/
];

export const routing: ModuleWithProviders =  RouterModule.forRoot(appRoutes);
