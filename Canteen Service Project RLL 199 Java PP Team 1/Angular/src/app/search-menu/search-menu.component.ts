import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-search-menu',
  templateUrl: './search-menu.component.html',
  styleUrls: ['./search-menu.component.css']
})
export class SearchMenuComponent implements OnInit {

  umid : string;
  menu : Observable<Menu>;

  search() {
    this.menu=this._menuService.searchMenu(this.umid);
  }
  constructor(private _menuService : MenuService) { 
   
  }

  ngOnInit(): void {
  }

}
