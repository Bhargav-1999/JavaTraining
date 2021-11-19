
import { Component, OnInit } from '@angular/core';

import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';
import { Orders } from '../orders';
import { OrdersService } from '../orders.service';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';
import { Wallet } from '../wallet';
import { WalletService } from '../wallet.service';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {
customer1:Customer;
orderdetails:Orders;
menu:Observable<Menu[]>;
menufound:Menu;
price:number;
vendor:Observable<Vendor[]>;
wallet:Observable<Wallet[]>;
msg:string;

placeOrder() {
  
  this.orderdetails.ord_billamount=this.orderdetails.ord_quantity*this.price;
  this._orderService.placeOrder(this.orderdetails).subscribe(x => {
    this.msg = x;
  })
  alert("Order Placed Succesfully");
}
constructor(private _menuService:MenuService, private _vendorService:VendorService, private _walletService:WalletService,private _orderService:OrdersService) {
  this.orderdetails= new Orders();
 
  this.customer1 = localStorage.getItem('customerdata')?JSON.parse(localStorage.getItem('customerdata')):[]
  
  this.orderdetails.cus_id=this.customer1.cus_id;
  this.menu=this._menuService.showMenu();
  this.vendor= this._vendorService.showVendor();
  this.wallet= this._walletService.customerWallet(this.customer1.cus_id);

 }
 showAmount(){
  
  this._menuService.searchMenu(this.orderdetails.men_ID).subscribe(x => {
    this.menufound = x;
    this.price= x.men_PRICE;

    
  });
 }

 

  ngOnInit(): void {
    this.getDate();
  }

  todayDate : any
  todayDate1 : any

    getDate() {

      var date:any = new Date();
     
      var toDate:any = date.getDate();
      var toDate1:any = date.getDate();
     
      if(toDate < 10) {
     
      toDate = '0' + toDate;
     
      }
     
      var month: any  = date.getMonth() + 1;
      var months: any  = date.getMonth() + 1;
      if(month < 10){
     
      month= '0' + month;
     
      }
     
      var year = date.getFullYear();
      var year1 = date.getFullYear() ;
     
      this.todayDate = year + "-" + month + "-" +toDate
      this.todayDate1 = year1 + "-" + months + "-" +toDate1
      console.log(this.todayDate)
      console.log(this.todayDate1)
  }
  }


