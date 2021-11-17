import {Component, OnInit} from '@angular/core';
import {StorageService} from "../../../shared/services/storage.service";
import {AuthenticateResponse} from "../../model/authenticate.response";
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  form: any = {};

  isLoggedIn = false;

  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private service: AuthenticationService, private storage: StorageService) {
  }

  ngOnInit(): void {
    if (this.storage.getToken()) {
      this.isLoggedIn = true;
      let user = this.storage.getUser();
      if (user) {
        this.roles = user.roles;
      }
    }
  };

  onSubmit(): void {
    this.service.authenticate(this.form).subscribe(
      (response: AuthenticateResponse) => {
        this.storage.saveToken(response.token);
        this.storage.saveUser(response);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        let user = this.storage.getUser();
        this.roles = user ? user.roles : [];
      });
  }

  reloadPage(): void {
    window.location.reload();
  }

}
