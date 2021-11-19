
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-search',
  templateUrl: './customer-search.component.html',
  styleUrls: ['./customer-search.component.css']
})
export class CustomerSearchComponent implements OnInit {

  topic : string;
  customers : string;
  customer : Observable<Customer>;
  customer1 : Customer;
  constructor(private _service : CustomerService) { 
    this.customers=localStorage.getItem("user");
    this.customer1 = localStorage.getItem('customerdata')? JSON.parse(localStorage.getItem('customerdata')):[];
    
    this.customer=this._service.showcustomerAuthen(this.customers);
  }

  ngOnInit(): void {
}
  }


