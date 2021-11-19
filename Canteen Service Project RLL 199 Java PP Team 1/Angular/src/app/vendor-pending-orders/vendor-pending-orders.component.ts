import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Orders } from '../orders';
import { OrdersService } from '../orders.service';
import { Vendor } from '../vendor';


@Component({
  selector: 'app-vendor-pending-orders',
  templateUrl: './vendor-pending-orders.component.html',
  styleUrls: ['./vendor-pending-orders.component.css']
})
export class VendorPendingOrdersComponent implements OnInit {

  vorders : Observable<Orders[]>;
  user:string
  vendor : Observable<Vendor>
  ven : Vendor
  orderarr : Observable<Orders[]>

oid : string;
status(ordId : string) {
this.oid = ordId;

localStorage.setItem("oid",this.oid.toString());
this._router.navigate(['../acceptreject'], {relativeTo: this._route});
}
  
  constructor(private _service : OrdersService, private _router:Router,private _route:ActivatedRoute) { 
    this.user = localStorage.getItem("user1")
    this.ven = localStorage.getItem('customerdata1')?JSON.parse(localStorage.getItem('customerdata1')):[]
    //alert(this.ven.ven_id)
    this.orderarr = this._service.vendorPendingOrder(this.ven.ven_ID)
  }


  ngOnInit(): void {
  }

}
