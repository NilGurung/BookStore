import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http'
import {Book} from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class RemoveBookService {

  constructor(private http: Http) { }

    deleteBook(bookId: Number) {
        let url = "http://localhost:8181/book/delete";

        let headers = new Headers ({
            'Content-Type': 'application/json',
            'x-auth-token': localStorage.getItem('xAuthToken')
        })


        return this.http.post(url, JSON.stringify(bookId),  {headers: headers});
    }
}
