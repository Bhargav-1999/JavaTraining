import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-search',
  templateUrl: './vendor-search.component.html',
  styleUrls: ['./vendor-search.component.css']
})
export class VendorSearchComponent implements OnInit {

  topic : string;
  vendors : string;
  vendor : Observable<Vendor>;
  vendor1 : Vendor;
  constructor(private _service : VendorService) { 
    this.vendors=localStorage.getItem("user1");
    this.vendor1 = localStorage.getItem('customerdata1')? JSON.parse(localStorage.getItem('customerdata1')):[];
    
    this.vendor=this._service.showvendorAuthen(this.vendors);
  }

  ngOnInit(): void {
  }

}
