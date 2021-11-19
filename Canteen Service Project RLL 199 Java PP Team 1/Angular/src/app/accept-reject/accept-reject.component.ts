import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../orders.service';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-accept-reject',
  templateUrl: './accept-reject.component.html',
  styleUrls: ['./accept-reject.component.css']
})
export class AcceptRejectComponent implements OnInit {

  ven : Vendor;
  oid:string;
  venId:string;
  ord_status:string;
  result:string;
  constructor(private _orderservice:OrdersService) {
    this.ven = localStorage.getItem('customerdata1')?JSON.parse(localStorage.getItem('customerdata1')):[]
    this.venId= this.ven.ven_ID;
    this.oid= localStorage.getItem("oid");
   }
   acceptReject(){
    this._orderservice.acceptrejectorders(this.oid,this.venId,this.ord_status).subscribe
    (x=>{
      this.result=x;
    })
   }

  ngOnInit(): void {
  }

}
