import { Injectable } from '@angular/core';
import {Http, Headers} from  '@angular/http';
//mport {Observable} from 'rxjs/Observable'

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: Http) {

  }

  // login api call

  sendCredential(username: string, password: string) {
    let url = "http://localhost:8181/token";
    let encodedCredentials = btoa(username+":" + password);
    let basicHeader = "Basic " + encodedCredentials;

    let headers = new Headers ({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Authorization' : basicHeader
    })

    return this.http.get(url, {headers: headers});
  }


  // session set or not

  checkSession() {
    console.log(localStorage.getItem("xAuthToken"));
    if(localStorage.getItem("xAuthToken") !== null) {
      return true;
    }
    return false;
  }

  //logout api call

  logout() {
    let url = "http://localhost:8181/user/logout";

    let headers = new Headers ({
      'x-auth-token': localStorage.getItem('xAuthToken')
    })

    localStorage.removeItem('xAuthToken');

    return this.http.post(url, '',  {headers: headers});
  }
}
