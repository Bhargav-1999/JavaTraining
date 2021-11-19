import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {

  uusername : string;
  upassword : string;
  isFormSubmitted : boolean;
  status : Observable<string>;
  sign1() {
    this.router.navigate(['/addcustomer']);
  }
  login(loginForm : NgForm) {
    //  this.isFormSubmitted = false;
      if (loginForm.invalid) {
        return;
      }
      this.isFormSubmitted = true;
    this._service.loginCustomer(this.uusername,this.upassword).subscribe(x=>{
      if(x=="1") {
        localStorage.setItem("user",this.uusername)
        this.router.navigate(['/CustomerDashboard'])
        
      }
      else {
        alert("Invalid Credentials")
      }
    })
  }
  
  constructor(private _service : CustomerService,private router : Router) 
  { 
    this.uusername="";
    this.upassword="";
    this.isFormSubmitted=false;
  }
  ngOnInit(): void {
  }

}
