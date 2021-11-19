package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VendorService {
	@Autowired
    private VendorRepository repo;
	@Autowired
    private VendorDAO dao;
    
    public List<Vendor> showVendor() {
        return repo.findAll();
    }
    
    public Vendor get(String id) {
     return repo.findById(id).get();
    
 }
   

	public String authenticate(String user, String pwd) {
		// TODO Auto-generated method stub
		return dao.authenticate(user, pwd);
	}

	public Vendor authenv(String user) {
		// TODO Auto-generated method stub
		return dao.authenv(user);
	}

	public String addvendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return dao.addvendor(vendor);
	}
}
