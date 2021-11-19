import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerShowComponent } from './customer-show/customer-show.component';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
import { VendorShowComponent } from './vendor-show/vendor-show.component';
import { VendorSearchComponent } from './vendor-search/vendor-search.component';
import { VendorDashboardComponent } from './vendor-dashboard/vendor-dashboard.component';
import { VendorLoginComponent } from './vendor-login/vendor-login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CustomerPendingOrdersComponent } from './customer-pending-orders/customer-pending-orders.component';
import { CustomerTotalOrdersComponent } from './customer-total-orders/customer-total-orders.component';
import { VendorPendingOrdersComponent } from './vendor-pending-orders/vendor-pending-orders.component';
import { VendorTotalOrdersComponent } from './vendor-total-orders/vendor-total-orders.component';
import { CustomerTotalWalletComponent } from './customer-total-wallet/customer-total-wallet.component';
import { CustomerWalletComponent } from './customer-wallet/customer-wallet.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { AddcustomerComponent } from './addcustomer/addcustomer.component';
import { AddvendorComponent } from './addvendor/addvendor.component';
import { AddmenuComponent } from './addmenu/addmenu.component';
import { AddwalletComponent } from './addwallet/addwallet.component';
import { SearchMenuComponent } from './search-menu/search-menu.component';
import { ShowMenuComponent } from './show-menu/show-menu.component';
import { AcceptRejectComponent } from './accept-reject/accept-reject.component';




const appRoutes: Routes=
[
  {path:'' ,component:HomePageComponent},
  {path:'HomePage' ,component:HomePageComponent},
  {path: 'addcustomer',component:AddcustomerComponent},
  {path: 'addvendor',component:AddvendorComponent},
  {path: 'CustomerDashboard',component:CustomerDashboardComponent},
  {path: 'CustomerDashboard',component:CustomerDashboardComponent,children : [
    {path: 'customer-show',component:CustomerShowComponent,outlet : "mphasis"},
    {path: 'customer-search',component:CustomerSearchComponent,outlet : "mphasis"},
    {path: 'customertotalorders',component:CustomerTotalOrdersComponent,outlet : "mphasis"},
    {path: 'customerpendingorders',component:CustomerPendingOrdersComponent,outlet : "mphasis"},
    {path: 'customertotalwallets',component:CustomerTotalWalletComponent,outlet : "mphasis"},
    {path: 'customerwallet',component:CustomerWalletComponent,outlet : "mphasis"},
    {path: 'placeorder',component:PlaceOrderComponent,outlet : "mphasis"},
    {path: 'addcustomer',component:AddcustomerComponent,outlet : "mphasis"},
    {path: 'addwallet',component:AddwalletComponent,outlet : "mphasis"},
    {path: 'menushow',component:ShowMenuComponent,outlet : "mphasis"},
    {path: 'menusearch',component:SearchMenuComponent,outlet : "mphasis"},
  ]},

  {path: 'VendorDashboard',component:VendorDashboardComponent},
  {path: 'VendorDashboard',component:VendorDashboardComponent,children : [
    {path: 'vendor-show',component:VendorShowComponent,outlet : "mphasis"},
    {path: 'vendor-search',component:VendorSearchComponent,outlet : "mphasis"},
    {path: 'vendortotalorders',component:VendorTotalOrdersComponent,outlet : "mphasis"},
    {path: 'vendorpendingorders',component:VendorPendingOrdersComponent,outlet : "mphasis"},
    {path: 'addvendor',component:AddvendorComponent,outlet : "mphasis"},
    {path: 'addmenu',component:AddmenuComponent,outlet : "mphasis"},
    {path: 'acceptreject',component:AcceptRejectComponent,outlet : "mphasis"},
   
  ]},

  {path:'CustomerLogin',component:CustomerLoginComponent},
  {path:'VendorLogin',component:VendorLoginComponent}

]

@NgModule({
  declarations: [
    AppComponent,
    CustomerShowComponent,
    CustomerSearchComponent,
    CustomerDashboardComponent,
    CustomerLoginComponent,
    VendorShowComponent,
    VendorSearchComponent,
    VendorDashboardComponent,
    VendorLoginComponent,
    HomePageComponent,
    CustomerPendingOrdersComponent,
    CustomerTotalOrdersComponent,
    VendorPendingOrdersComponent,
    VendorTotalOrdersComponent,
    CustomerTotalWalletComponent,
    CustomerWalletComponent,
    PlaceOrderComponent,
    AddcustomerComponent,
    AddvendorComponent,
    AddmenuComponent,
    AddwalletComponent,
    SearchMenuComponent,
    ShowMenuComponent,
    AcceptRejectComponent,
   
  
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }