import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import 'rxjs/add/operator/map';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {


  constructor(private _http : Http) {
    
   }

   addcustomer(customer : Customer) : Observable<string> {
    return this._http.post("http://localhost:8080/customers/",customer).
    map((res : Response) => res.text());
  }

  loginCustomer(username : string,password:string) : Observable<string>{
    return this._http.get("http://localhost:8080/customerAuthenticate/"+username +"/"+password)
    .map((res: Response) => res.json());
  }


  searchCustomer(uid : string) : Observable<Customer> {
    return this._http.get("http://localhost:8080/customer/"+uid)
    .map((res: Response) => res.json());
  }
  showCustomer() : Observable<Customer[]> {
    return this._http.get("http://localhost:8080/showcustomer")
    .map((res: Response) => res.json());

  }
  showcustomerAuthen(uusername : string) : Observable<Customer> {
    return this._http.get("http://localhost:8080/customerAuthen/"+uusername)
    .map((res: Response) => res.json());
  }
 
}
