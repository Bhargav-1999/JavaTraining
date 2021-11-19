import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Menu } from './menu';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  
  constructor(private _http : Http) { }

  addmenu(menu : Menu) : Observable<string> {
    return this._http.post("http://localhost:8080/addmenu/",menu).
    map((res : Response) => res.text());
  }


  showMenu() : Observable<Menu[]> {
    return this._http.get("http://localhost:8080/showmenu/")
    .map((res: Response) => res.json());
  }
  searchMenu(men_ID:string) : Observable<Menu> {
    return this._http.get("http://localhost:8080/menu/"+men_ID)
    .map((res: Response) => res.json());
  }
}
