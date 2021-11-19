import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerTotalWalletComponent } from './customer-total-wallet.component';

describe('CustomerTotalWalletComponent', () => {
  let component: CustomerTotalWalletComponent;
  let fixture: ComponentFixture<CustomerTotalWalletComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerTotalWalletComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerTotalWalletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
