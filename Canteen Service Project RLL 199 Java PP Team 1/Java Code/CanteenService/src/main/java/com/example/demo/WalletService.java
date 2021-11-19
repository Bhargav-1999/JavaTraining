package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WalletService {
	 @Autowired
	    private WalletRepository repo;
	 @Autowired
	    private WalletDAO dao;
	 
	public List<Wallet> showCustomerWallet(String custId) {
		// TODO Auto-generated method stub
		return dao.showCustomerWallet(custId);
	}

	public Wallet showWallet(String custId, String waltSrc) {
		// TODO Auto-generated method stub
		return dao.showWallet(custId,waltSrc);
	}

	public String addwallet(Wallet wallet) {
		// TODO Auto-generated method stub
		return dao.addwallet(wallet);
	}

	
	
}
