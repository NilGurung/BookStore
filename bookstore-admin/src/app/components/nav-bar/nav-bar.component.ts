import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  private title = 'Login Secion';
  private loggedIn = false;

  logout() {

    this.loginService.logout().subscribe(
      res => {
          location.reload();


      },
      error => {
          console.log(error);
      }
    )
    this.router.navigate(['/']);
  }

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {

    this.loggedIn = this.loginService.checkSession();
    this.title = this.loggedIn ? 'Admin Dashboard' : 'Login Secion';
    //console.log(this.loggedIn);

  }




}
