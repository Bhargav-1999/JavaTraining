import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-login',
  templateUrl: './vendor-login.component.html',
  styleUrls: ['./vendor-login.component.css']
})
export class VendorLoginComponent implements OnInit {


  uusername : string;
  upassword : string;
  isFormSubmitted : boolean;
  status : Observable<string>;
  sign1() {
    this.router.navigate(['/addvendor']);
  }
  login(loginForm : NgForm) {
    //  this.isFormSubmitted = false;
      if (loginForm.invalid) {
        return;
      }
      this.isFormSubmitted = true;
    this._service.loginVendor(this.uusername,this.upassword).subscribe(x=>{
      if(x=="1") {
        localStorage.setItem("user1",this.uusername)
        this.router.navigate(['/VendorDashboard'])
        
      }
      else {
        alert("Invalid Credentials")
      }
    })
  }
  constructor(private _service : VendorService,private router : Router) 
  { 
    this.uusername="";
    this.upassword="";
    this.isFormSubmitted=false;
  }
  ngOnInit(): void {
  }

}
