import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    MatToolbarModule,
    MatGridListModule,
    MatFormFieldModule,
    MatSelectModule,
    MatSlideToggleModule, MatListModule, MatDialogModule
} from "@angular/material";
import {MatInputModule} from '@angular/material/input';


//custom appRouting
import {routing} from './app.routing'
import 'hammerjs';

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { LoginComponent } from './login/login.component';
import { AddNewBookComponent } from './components/add-new-book/add-new-book.component';

import {LoginService} from "./services/login.service";
import {HttpModule} from "@angular/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule} from "@angular/forms";

import {AddBookService} from "./services/add-book.service";
import {UploadImageService} from "./services/upload-image.service";
import { BookListComponent, DialogResultExampleDialog } from './components/book-list/book-list.component';
import {GetBookListService} from "./services/get-book-list.service";
import { ViewBookComponent } from './components/view-book/view-book.component';
import {GetBookService} from "./services/get-book.service";
import { EditBookComponent } from './components/edit-book/edit-book.component';
import {EditBookService} from "./services/edit-book.service";
import {RemoveBookService} from "./services/remove-book.service";

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginComponent,
    AddNewBookComponent,
    BookListComponent,
    ViewBookComponent,
    EditBookComponent,
    DialogResultExampleDialog

  ],
    entryComponents: [DialogResultExampleDialog],
  imports: [
    BrowserModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    MatToolbarModule,
    HttpModule,
    routing,
    MatInputModule,
    MatGridListModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    FormsModule,
    MatSelectModule,
    MatSlideToggleModule,
      MatListModule,
      MatDialogModule



  ],
  providers: [
    LoginService,
    AddBookService,
    UploadImageService,
      GetBookListService,
      GetBookService,
      EditBookService,
      RemoveBookService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
