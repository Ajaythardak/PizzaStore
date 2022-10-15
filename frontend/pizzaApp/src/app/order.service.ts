import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from './order';

const httpOptions ={
  headers: new HttpHeaders({'Content-Type':'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }


  createOrder(order: Order): Observable<any>{
    return this.http.post("http://localhost:8025/pg/createOrder",order, httpOptions);
      // name: order.name,
      // emailId: order.email,
      // mobileNo: order.phone,
      // currency:order.currency,
      // amount: order.amount,
      // customerPolicyId: order.policyId,
      // policyType: order.policyType,
      // paymentMode: order.paymentMode,
      // tax: order.tax,
      // discount: order.discount,
      // paymentDate: order.date,
      // paymentTime: order.time
    // }, httpOptions);
  }


}
