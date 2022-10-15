import { Injectable } from '@angular/core';
import { HttpHeaders,HttpClient } from '@angular/common/http';
import { SignupService } from './signup.service';
import { SignupClass } from './signup-class';
import { SignupComponent } from './signup/signup.component';
// import { SignupComponent } from './signup/signup.component';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private httpClient: HttpClient) { }

  url : string="http://localhost:8089/api/v2/order/";

reqHeader =new HttpHeaders().set('Authorization','Bearer '+window.localStorage.getItem('token'));

getAllPizzas(){
  // console.log(this.signupService.userId);
  console.log(localStorage.getItem("userId"));
  console.log("getallPizzas from ts is working");
    return this.httpClient.get<any>(this.url+localStorage.getItem("userId")+"/pizzas",{'headers':this.reqHeader});
  }


  addPizza(data:any){
    console.log();
    
    console.log(localStorage.getItem("userId"));
    return this.httpClient.post<any>(this.url+localStorage.getItem("userId")+"/pizza",data,{'headers':this.reqHeader});
  }


  deletePizza(data:any){
    console.log("deleted");
    console.log(localStorage.getItem("pizzaList.pizzaId"));
    return this.httpClient.delete<any>(this.url+localStorage.getItem("userId")+"/"+localStorage.getItem("pizzaId"),{'headers':this.reqHeader});

  }
  
}
