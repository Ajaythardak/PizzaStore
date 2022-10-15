// import { HttpClient } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginClass } from './login-class';
// import { LoginComponent } from './login/login.component';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  // 
  constructor(private httpClient: HttpClient) { }
  loggedin:boolean=false;
  redirectURL:string="";

  url = "http://localhost:8085/api/v1";
  isUserLoggedIn(){
    // if(this.loginComponent.isClicked){
    //   return true;
    // }else{
    //   return false;
    // }
    return this.loggedin;
  }

    loginCheck(data: LoginClass){
      return this.httpClient.post<any>(this.url + "/login", data);
    }
    
    
    
  }

