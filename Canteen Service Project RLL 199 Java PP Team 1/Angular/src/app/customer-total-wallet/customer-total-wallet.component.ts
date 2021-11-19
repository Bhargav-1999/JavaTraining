import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { Wallet } from '../wallet';
import { WalletService } from '../wallet.service';

@Component({
  selector: 'app-customer-total-wallet',
  templateUrl: './customer-total-wallet.component.html',
  styleUrls: ['./customer-total-wallet.component.css']
})
export class CustomerTotalWalletComponent implements OnInit {

  user:string
  customer : Observable<Customer>
  cus : Customer
  walletarr : Observable<Wallet[]>
  
  constructor(private _service : WalletService) { 
    this.user = localStorage.getItem("user")
    this.cus = localStorage.getItem('customerdata')?JSON.parse(localStorage.getItem('customerdata')):[]
    //alert(this.ven.ven_id)
    this.walletarr = this._service.customerWallet(this.cus.cus_id)

   //this.vendor = this._service.searchVendor(this.ven.ven_id)
   

  }

  ngOnInit(): void {
  }

}
