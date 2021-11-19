import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-addvendor',
  templateUrl: './addvendor.component.html',
  styleUrls: ['./addvendor.component.css']
})
export class AddvendorComponent implements OnInit {

  addven:Vendor;
  ven:Observable<Vendor[]>
  msg: string;
    addvendor() {
      this._vendorService.addvendor(this.addven).subscribe(x => {
      this.msg = x;
      })
      
    }
      constructor(private _vendorService:VendorService) {
        this.addven= new Vendor();
       }

  ngOnInit(): void {
  }

}
