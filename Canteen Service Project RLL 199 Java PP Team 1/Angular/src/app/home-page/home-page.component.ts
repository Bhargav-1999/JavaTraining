import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private router:Router) { 

  }
  customerlogin() {
    this.router.navigate(['/CustomerLogin']);
  }
  vendorlogin() {
    this.router.navigate(['/VendorLogin'])
  }

  ngOnInit(): void {
  }

}
