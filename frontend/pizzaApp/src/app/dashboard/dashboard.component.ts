import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  pizzaform:any;
  constructor(private dashboardService:DashboardService) {
    
    

    this.pizzaform={
      pizzId:'',
      pizzaName:'',
      topping:'',
      size:'',
      quantity:''
    }
   }

  ngOnInit(): void {
  }

  addedPizza:any;

  onPlaceOrder(data:any){
    console.log(data);
    alert("Order Placed Successfully.")
    console.log("add content is working");
    // console.log(pizzaform);

    this.dashboardService.addPizza(data).subscribe(
      a=>{
        this.addedPizza=a;
        confirm("Pizza Added");
        window.localStorage.setItem('pizzaId',this.pizzaform.pizzaId);
        console.log(a);
        // this.getAllContent();
      },(error)=>{
        console.log(error);
        
      }
    )
  };

  pizzas:any;

  getAllPizzas(){
    
    console.log("Showing user orders");
    // console.log("what your are printing12->",localStorage.getItem("emailId"));
   this.dashboardService.getAllPizzas().subscribe(
    a=>{
      this.pizzas=a;
      
      console.log("your order details",a);
    },
    (error)=>{
      console.log(error);
      
    }
   )
  };
 
  
  logout(){
    window.localStorage.clear();
    confirm("Succesfully LogOut")
  }

}
