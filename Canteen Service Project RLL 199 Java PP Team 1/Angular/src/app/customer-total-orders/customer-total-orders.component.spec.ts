import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerTotalOrdersComponent } from './customer-total-orders.component';

describe('CustomerTotalOrdersComponent', () => {
  let component: CustomerTotalOrdersComponent;
  let fixture: ComponentFixture<CustomerTotalOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerTotalOrdersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerTotalOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
