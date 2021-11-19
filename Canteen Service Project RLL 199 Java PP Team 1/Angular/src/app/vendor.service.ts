import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Vendor } from './vendor';


@Injectable({
  providedIn: 'root'
})
export class VendorService {

  
  constructor(private _http : Http) {
   
   }
   addvendor(vendor : Vendor) : Observable<string> {
    return this._http.post("http://localhost:8080/vendors/",vendor).
    map((res : Response) => res.text());
  }

  loginVendor(username : string,password:string) : Observable<string>{
    return this._http.get("http://localhost:8080/vendorAuthenticate/"+username +"/"+password)
    .map((res: Response) => res.json());
  }

  searchVendor(vid : string) : Observable<Vendor> {
    return this._http.get("http://localhost:8080/vendor/"+vid)
    .map((res: Response) => res.json());
  }
  showVendor() : Observable<Vendor[]> {
    return this._http.get("http://localhost:8080/showvendor")
    .map((res: Response) => res.json());

  }
  showvendorAuthen(uusername : string) : Observable<Vendor> {
    return this._http.get("http://localhost:8080/vendorAuthen/"+uusername)
    .map((res: Response) => res.json());
  }
  }