package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class CustomerService {
	 @Autowired
	    private CustomerRepository repo;
	 @Autowired
	    private CustomerDAO dao;
	    
	    public List<Customer> showCustomer() {
	        return repo.findAll();
	    }
	    
	    public Customer get(String id) {
         return repo.findById(id).get();
        
     }
	   
		public String authenticate(String user, String pwd) {
			// TODO Auto-generated method stub
			return dao.authenticate(user, pwd);
		}

		public Customer authen(String user) {
			// TODO Auto-generated method stub
			return dao.authen(user);
		}

		public String addcustomer(Customer customer) {
			// TODO Auto-generated method stub
			return dao.addcustomer(customer);
		}
		
}

