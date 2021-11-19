import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Wallet } from './wallet';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  constructor(private _http : Http) { }
  addwallet(wallet : Wallet) : Observable<string> {
    return this._http.post("http://localhost:8080/addwallet/",wallet).
    map((res : Response) => res.text());
  }
  customerWallet(cus_id : String) : Observable<Wallet[]> {
    return this._http.get("http://localhost:8080/customerWallet/"+cus_id)
    .map((res: Response) => res.json());
  }
  wallet(cus_id : String,wal_source:string) : Observable<Wallet> {
    return this._http.get("http://localhost:8080/Wallet/"+cus_id+"/"+wal_source)
    .map((res: Response) => res.json());
  }
}
