import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']
})
export class CustomerDashboardComponent implements OnInit {

  topic : string
  customers : string;
  customer : Observable<Customer>;
  cust : Customer;

  constructor(private _service : CustomerService,private router:Router)
  { 
    this.customers=localStorage.getItem("user");
    this._service.showcustomerAuthen(this.customers).subscribe(x=>{
      this.cust=x;
      localStorage.setItem('customerdata', JSON.stringify(x));
    })
  //  this.customer=this._service.showcustomerAuthen(this.customers);
 //   localStorage.setItem('customerdata', JSON.stringify(this.customer));
  }
  ngOnInit(): void {
  }

}
