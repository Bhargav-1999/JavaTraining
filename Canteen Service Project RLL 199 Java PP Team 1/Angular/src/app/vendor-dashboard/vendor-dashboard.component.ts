import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-dashboard',
  templateUrl: './vendor-dashboard.component.html',
  styleUrls: ['./vendor-dashboard.component.css']
})
export class VendorDashboardComponent implements OnInit {

  topic : string;
  customers : string;
  customer : Observable<Vendor>;
  cust : Vendor;

  constructor(private _service : VendorService,private router:Router)
  { 
    this. customers =localStorage.getItem("user1");
    this._service.showvendorAuthen(this. customers ).subscribe(x=>{
      this.cust=x;
      localStorage.setItem('customerdata1', JSON.stringify(x));
    })
  //  this.customer=this._service.showcustomerAuthen(this.customers);
 //   localStorage.setItem('customerdata', JSON.stringify(this.customer));
  }

  ngOnInit(): void {
  }

}
