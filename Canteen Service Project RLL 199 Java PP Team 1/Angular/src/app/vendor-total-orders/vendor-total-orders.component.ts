import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Orders } from '../orders';
import { OrdersService } from '../orders.service';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-total-orders',
  templateUrl: './vendor-total-orders.component.html',
  styleUrls: ['./vendor-total-orders.component.css']
})
export class VendorTotalOrdersComponent implements OnInit {

  user:string
  vendor : Observable<Vendor>
  ven : Vendor
  orderarr : Observable<Orders[]>
  
  constructor(private _service : OrdersService) { 
    this.user = localStorage.getItem("user1")
    this.ven = localStorage.getItem('customerdata1')?JSON.parse(localStorage.getItem('customerdata1')):[]
    //alert(this.ven.ven_id)
    this.orderarr = this._service.vendorOrder(this.ven.ven_ID)
  }

  ngOnInit(): void {
  }

}
