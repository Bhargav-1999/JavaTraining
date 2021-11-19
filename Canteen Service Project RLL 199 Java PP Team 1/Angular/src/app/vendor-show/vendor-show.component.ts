import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-show',
  templateUrl: './vendor-show.component.html',
  styleUrls: ['./vendor-show.component.css']
})
export class VendorShowComponent implements OnInit {

  vendors : Observable<Vendor[]>
  constructor(private _service : VendorService) { 
    this.vendors = this._service.showVendor();
  }


  ngOnInit(): void {
  }

}
