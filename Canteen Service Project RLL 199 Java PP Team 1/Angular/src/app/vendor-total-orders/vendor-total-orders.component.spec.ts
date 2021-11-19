import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorTotalOrdersComponent } from './vendor-total-orders.component';

describe('VendorTotalOrdersComponent', () => {
  let component: VendorTotalOrdersComponent;
  let fixture: ComponentFixture<VendorTotalOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VendorTotalOrdersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorTotalOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
