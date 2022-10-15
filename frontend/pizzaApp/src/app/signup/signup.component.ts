import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SignupClass } from '../signup-class';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupform:any;
  signupdata: SignupClass |any ;
  
  constructor(private router:Router, private singupService:SignupService) {
    this.signupform={
      userId:'',
      userName:'',
      userEmail:'',
      password:'',
      address:'',
      phoneNo:''
    }
   }

  ngOnInit(): void {
  }

  onSubmit(data:any){
    console.log(data);
    this.signupdata=data;
    console.log(this.signupdata);
    console.log("on submit is working");
    
    this.singupService.registerUser(this.signupdata).subscribe(
      a=>{
        this.router.navigateByUrl("/login");
        console.log("User Registerd");
        window.localStorage.setItem('userId',this.signupdata.userId);
        confirm("User registration Successful");
        alert("Account Successfully created.")
        
      },
      error => {
        console.log(error);
        alert("signup failed");
      });
    
    // alert("Account Successfully created.")
    // this.router.navigateByUrl("/login");
  }

    
  
    
  
}

