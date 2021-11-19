package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@Autowired
	private CustomerService customerservice;
	@Autowired
	private MenuService menuservice;
	@Autowired
	private VendorService vendorservice;
	@Autowired
    private OrdersService service;
	@Autowired
    private WalletService service1;
	
	
	@RequestMapping("/")
	public String hello() {
	    return "hello";
	}
	
	@RequestMapping(value="/showcustomer")
    public List<Customer> list() {
        return customerservice.showCustomer();
    }
	
	 @GetMapping("/customer/{id}")
	    public ResponseEntity<Customer> get(@PathVariable String id) {
	        try {
	            Customer customer = customerservice.get(id);
	            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	        }      
	    }
	 @PostMapping("/customers")
	    public String addcustomer(@RequestBody Customer customer) {
	        return customerservice.addcustomer(customer);
	    }
	
	 @RequestMapping("/customerAuthenticate/{user}/{pwd}")
	    public String customerAutneticateion(@PathVariable String user, @PathVariable String pwd) {
	        return customerservice.authenticate(user, pwd);
	    }
	
	 @RequestMapping(value="/showmenu")
	    public List<Menu> list1() {
	        return menuservice.showMenu();
	    }
	 
	 @GetMapping("/menu/{id}")
	    public ResponseEntity<Menu> get1(@PathVariable String id) {
	        try {
	            Menu menu = menuservice.get(id);
	            return new ResponseEntity<Menu>(menu, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
	        }      
	    }

	
	 @PostMapping("/addmenu")
	    public String addmenu(@RequestBody Menu menu) {
	       return menuservice.addmenu(menu);
	    }
	 
	 @RequestMapping(value="/showvendor")
	    public List<Vendor> list2() {
	        return vendorservice.showVendor();
	    }
	 
	 @GetMapping("/vendor/{id}")
	    public ResponseEntity<Vendor> get2(@PathVariable String id) {
	        try {
	            Vendor vendor = vendorservice.get(id);
	            return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
	        }      
	    }
	 
	
	 @PostMapping("/vendors")
	    public String addvendor(@RequestBody Vendor vendor) {
	        return vendorservice.addvendor(vendor);
	    }
	 @RequestMapping("/vendorAuthenticate/{user}/{pwd}")
	    public String autneticateion(@PathVariable String user, @PathVariable String pwd) {
	        return vendorservice.authenticate(user, pwd);
	        
	    }
	 @RequestMapping("/customerAuthen/{user}")
	   public Customer authen(@PathVariable String user) {
	       return customerservice.authen(user);
	   }
	 @RequestMapping("/vendorAuthen/{user}")
	   public Vendor authenv(@PathVariable String user) {
	       return vendorservice.authenv(user);
	   }
	 
	 @RequestMapping(value="/showorder")
	    public List<Orders> list3() {
	        return service.showOrders();
	    }
	 
	 @GetMapping("/orders/{id}")
	    public ResponseEntity<Orders> get3(@PathVariable String id) {
	        try {
	            Orders orders = service.get(id);
	            return new ResponseEntity<Orders>(orders, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
	        }      
	    }
	   @PostMapping("/placeOrder")
	    public String add(@RequestBody Orders orders) {
	        return service.placeOrder(orders);
	    }
	   
	   @PostMapping("/acceptOrRejectOrder/{ordId}/{venId}/{status}")
		public String acceptOrReject(@PathVariable String ordId,@PathVariable String venId, 
				@PathVariable String status) {
			return service.acceptOrRejectOrder(ordId, venId, status);
		}
	   
		@RequestMapping(value="/customerPendingOrders/{cid}")
		public List<Orders> customerPendingOrders(@PathVariable String cid) {
			return service.showCustomerPendingOrders(cid);
		} 

		
		@RequestMapping(value="/customerOrders/{cid}")
		public List<Orders> customerOrders(@PathVariable String cid) {
			return service.showCustomerOrders(cid);
		}
		
		
		@RequestMapping(value="/vendorPendingOrders/{vid}")
		public List<Orders> vendorPendingOrders(@PathVariable String vid) {
			return service.showVendorPendingOrders(vid);
		}
		 
		
		@RequestMapping(value="/vendorOrders/{vid}")
		public List<Orders> vendorOrders(@PathVariable String vid) {
			return service.showVendorOrders(vid);
		}
		
		@RequestMapping(value="/customerWallet/{cid}")
		public List<Wallet> customerWallet(@PathVariable String cid) {
			return service1.showCustomerWallet(cid);
		}
		
		@RequestMapping(value="/Wallet/{cid}/{walsrc}")
		public Wallet wallet(@PathVariable String cid,@PathVariable String walsrc) {
			return service1.showWallet(cid,walsrc);
		}
		@PostMapping("/addwallet")
	    public String addwallet(@RequestBody Wallet wallet) {
	        return service1.addwallet(wallet);
	    }
}
