import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-addmenu',
  templateUrl: './addmenu.component.html',
  styleUrls: ['./addmenu.component.css']
})
export class AddmenuComponent implements OnInit {

  addmen:Menu;
  men:Observable<Menu[]>
  msg: string;
    addmenu() {
      this._menuService.addmenu(this.addmen).subscribe(x => {
      this.msg = x;
      })
     
    }
      constructor(private _menuService:MenuService) {
        this.addmen= new Menu();
       }

  ngOnInit(): void {
  }

}
