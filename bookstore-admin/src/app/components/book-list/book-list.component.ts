import { Component, OnInit } from '@angular/core';
import {Book} from "../../models/book";
import {Router} from "@angular/router";
import {GetBookListService} from '../../services/get-book-list.service';
import {MatDialog, MatDialogRef} from "@angular/material";
import {RemoveBookService} from "../../services/remove-book.service";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  private selectBook : Book;
  private checked: boolean;
  private bookList: Book[];
  private allChecked: boolean;
  private removeBookList: Book[] = new Array();


  constructor(private getBookListService: GetBookListService,
              private router: Router,
              private removeBookService: RemoveBookService,
              public dialog: MatDialog

              ) { }

  ngOnInit() {
    this.getBookList();
  }

  getBookList() {
      this.getBookListService.getBookList().subscribe(
          res => {
              console.log(res.json());
              this.bookList = res.json();
          },
          error => {
              console.log(error);
          }
      )
  }

  onSelect(book: Book) {
      this.selectBook = book;
      this.router.navigate(['/book/view', this.selectBook.id]);
  }

  updateRemoveBookList(checked: boolean, book: Book) {
      if(checked) {
          this.removeBookList.push(book);
      } else {

            this.removeBookList.splice(this.removeBookList.indexOf(book), 1);
      }
  }

    updateSelected(checked: boolean) {
        if (checked) {
            this.allChecked = true;
            this.removeBookList = this.bookList.slice();
        } else {
            this.allChecked = false;
            this.removeBookList = [];
        }
    }


  removeSelectedBooks() {
      let dialogRef = this.dialog.open(DialogResultExampleDialog);
      dialogRef.afterClosed().subscribe(
          result => {
              if(result == "yes") {
                  for(let book of this.removeBookList) {
                      this.removeBookService.deleteBook(book.id).subscribe(
                          res=> {

                          },
                          err => {

                          }
                      )
                  }

                  this.getBookList()

              }
          }
      )
  }

  openDialog(book: Book) {
        let dialogRef = this.dialog.open(DialogResultExampleDialog);
        dialogRef.afterClosed().subscribe(
            result => {
                if(result == "yes") {
                    this.removeBookService.deleteBook(book.id).subscribe(
                        res=> {
                            this.getBookList()
                        },
                        err => {
                            console.log(err);
                        }
                    )
                }
            }
        )
  }

}


@Component({
            selector: 'dialog-result-example-dialog',
            templateUrl: './dialog-result-example-dialog.html'
    })

export class DialogResultExampleDialog {
    constructor(public dialogRef: MatDialogRef<DialogResultExampleDialog>) {}
}
