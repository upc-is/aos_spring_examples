import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {AuthenticateRequest} from "../model/authenticate.request";
import {RegisterRequest} from "../model/register.request";

const AUTH_API = 'http://localhost:8080/api/auth/';

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }
  authenticate(request: AuthenticateRequest): Observable<any> {
    return this.http.post(AUTH_API + 'sign-in', request, HTTP_OPTIONS);
  }
  register(request: RegisterRequest): Observable<any> {
    return this.http.post(AUTH_API + 'sign-up', request, HTTP_OPTIONS);
  }
}
