import {Injectable} from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HTTP_INTERCEPTORS
} from '@angular/common/http';
import {Observable} from 'rxjs';
import {StorageService} from "../../shared/services/storage.service";


const AUTHORIZATION_HEADER_KEY = 'Authorization';

@Injectable()
export class AuthorizationInterceptor implements HttpInterceptor {

  constructor(private storage: StorageService) {
  }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    let authorizationRequest = request;
    const token = this.storage.getToken();
    if (token != null) {
      authorizationRequest = request.clone({
        headers: request.headers.set(AUTHORIZATION_HEADER_KEY, `Bearer ${token}`),
      });
    }
    return next.handle(authorizationRequest);
  }
}

export const authorizationInterceptorProviders = [
  {provide: HTTP_INTERCEPTORS, useClass: AuthorizationInterceptor, multi: true}
];
