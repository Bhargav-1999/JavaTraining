import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-show-menu',
  templateUrl: './show-menu.component.html',
  styleUrls: ['./show-menu.component.css']
})
export class ShowMenuComponent implements OnInit {

  menus : Observable<Menu[]>
  constructor(private _menuService : MenuService) { 
    this.menus = this._menuService.showMenu();
  }

  ngOnInit(): void {
  }

}
