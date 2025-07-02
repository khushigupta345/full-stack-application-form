
// import { Injectable } from '@angular/core';
// import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
// import { AuthService } from '../services/auth.service';

// @Injectable()
// export class JwtInterceptor implements HttpInterceptor {
//   constructor(private auth: AuthService) {}

//   intercept(req: HttpRequest<any>, next: HttpHandler) {
//     const token = this.auth.getToken();
//     if (token) {
//       req = req.clone({
//         setHeaders: {
//           Authorization:` Bearer ${token}`
//         }
//       });
//     }
//     return next.handle(req);
//   }
// }
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  constructor(private auth: AuthService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.auth.getToken();

    if (token) {
      //  Token expiry check
      try {
        const payload = JSON.parse(atob(token.split('.')[1]));
        if (Date.now() >= payload.exp * 1000) {
          //  Token expired
          alert("Session expired. Please login again.");
          localStorage.clear();
          window.location.href = '/signup'; //  redirect to signup
          return new Observable<HttpEvent<any>>(); //  Stop further request
        }
      } catch (e) {
        console.error("Invalid token:", e);
        localStorage.clear();
        window.location.href = '/signup';
        return new Observable<HttpEvent<any>>();
      }

      // If token is valid, attach it to headers
      req = req.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });
    }

    return next.handle(req);
  }
}