import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-show',
  templateUrl: './customer-show.component.html',
  styleUrls: ['./customer-show.component.css']
})
export class CustomerShowComponent implements OnInit {
  customers : Observable<Customer[]>;
  constructor(private _service : CustomerService) {
    this.customers = this._service.showCustomer();
   }

  ngOnInit(): void {
  }

}
