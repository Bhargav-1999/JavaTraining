import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Orders } from './orders';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private _http : Http) { }
  placeOrder(orders : Orders) : Observable<string> {
    return this._http.post("http://localhost:8080/placeOrder/",orders).
    map((res : Response) => res.text());
  }
  acceptrejectorders(oid:string,vid:string,status:string) : Observable<string> {
    return this._http.post("http://localhost:8080/acceptOrRejectOrder/"+oid+"/"+vid+"/"+status,null)
    .map((res : Response) => res.text());
  }
  vendorOrder(ven_ID : String) : Observable<Orders[]> {
    return this._http.get("http://localhost:8080/vendorOrders/"+ven_ID)
    .map((res: Response) => res.json());
  }
  vendorPendingOrder(ven_ID : String) : Observable<Orders[]> {
    return this._http.get("http://localhost:8080/vendorPendingOrders/"+ven_ID)
    .map((res: Response) => res.json());
  }
  customerOrder(cus_id : String) : Observable<Orders[]> {
    return this._http.get("http://localhost:8080/customerOrders/"+cus_id)
    .map((res: Response) => res.json());
  }
  customerPendingOrder(cus_id : String) : Observable<Orders[]> {
    return this._http.get("http://localhost:8080/customerPendingOrders/"+cus_id)
    .map((res: Response) => res.json());
  }
}
