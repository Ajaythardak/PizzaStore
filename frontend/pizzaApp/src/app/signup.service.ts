import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SignupClass } from './signup-class';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private httpClient:HttpClient) { }

  userRegUrl: string = "http://localhost:8089/api/v2";

  registerUser(data: SignupClass) {
    console.log("register user is working");
    
    return this.httpClient.post<any>(this.userRegUrl+"/register", data);
  }

}
