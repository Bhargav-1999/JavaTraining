package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuService {
	@Autowired
    private MenuRepository repo;
	 @Autowired
	    private MenuDAO dao;
    
    public List<Menu> showMenu() {
        return repo.findAll();
    }
    
    public Menu get(String id) {
     return repo.findById(id).get();
    
 }
  

	public String addmenu(Menu menu) {
		// TODO Auto-generated method stub
		return dao.addmenu(menu);
	}

}
