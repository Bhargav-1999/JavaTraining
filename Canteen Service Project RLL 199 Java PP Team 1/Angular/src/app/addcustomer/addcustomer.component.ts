import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-addcustomer',
  templateUrl: './addcustomer.component.html',
  styleUrls: ['./addcustomer.component.css']
})
export class AddcustomerComponent implements OnInit {

  addcus:Customer;
  cus:Observable<Customer[]>
  price:number;
  msg: string;
    addcustomer() {
      this._customerService.addcustomer(this.addcus).subscribe(x => {
      this.msg = x;
      })
     
    }
      constructor(private _customerService:CustomerService) {
        this.addcus= new Customer();
       }
  ngOnInit(): void {
  }

}
