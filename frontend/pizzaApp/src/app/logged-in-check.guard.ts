import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class LoggedInCheckGuard implements CanActivate {
  
  constructor(private router: Router, private loginService: LoginService){

  }
  
  canActivate() {
    if(this.loginService.isUserLoggedIn()){
      return true;
    }
    else{
      window.alert("you need to first login to place order.")
      this.router.navigateByUrl("/login");
      return false;
    }
}
  
}
