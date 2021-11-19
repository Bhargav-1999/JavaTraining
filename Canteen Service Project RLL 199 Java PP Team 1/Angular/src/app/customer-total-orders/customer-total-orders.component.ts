import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { Orders } from '../orders';
import { OrdersService } from '../orders.service';

@Component({
  selector: 'app-customer-total-orders',
  templateUrl: './customer-total-orders.component.html',
  styleUrls: ['./customer-total-orders.component.css']
})
export class CustomerTotalOrdersComponent implements OnInit {

  user:string
  customer : Observable<Customer>
  cus : Customer
  orderarr : Observable<Orders[]>
  
  constructor(private _service : OrdersService) { 
    this.user = localStorage.getItem("user")
    this.cus = localStorage.getItem('customerdata')?JSON.parse(localStorage.getItem('customerdata')):[]
    //alert(this.ven.ven_id)
    this.orderarr = this._service.customerOrder(this.cus.cus_id)

   //this.vendor = this._service.searchVendor(this.ven.ven_id)
   

  }

  ngOnInit(): void {
  }

}
