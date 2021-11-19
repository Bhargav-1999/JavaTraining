package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDAO {
    @Autowired  
    JdbcTemplate jdbc;  
    
    public String generatecustid() {
    	String cmd = "select max(MEN_ID) mid from Menu";
        List str=jdbc.query(cmd, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	return rs.getString("mid");
            }
            
        });
        String id= str.get(0).toString();
        id = id.substring(1);
         int tempId = Integer.parseInt(id);
         tempId += 1;
         String stockId = String.format("M%03d", tempId);
         return stockId;
	}
    
    public String addmenu(Menu men) {
    	String id =generatecustid();
    	men.setMEN_ID(id);
    	String cmd = "insert into Menu(MEN_ID,MEN_ITEM,MEN_PRICE,MEN_CALORIES,MEN_SPECIALITY) values(?,?,?,?,?)";
    	 jdbc.update(cmd,men.getMEN_ID(),men.getMEN_ITEM(),
    			 men.getMEN_PRICE(), 
    			 men.getMEN_CALORIES(),men.getMEN_SPECIALITY());
    	 return "Menu added Succesfully";
    	
    }
    
    public Menu searchMenu(String menuId) {
        String cmd = "select * from Menu where MEN_ID=?";
        List<Menu> menuList=jdbc.query(cmd,new Object[] {menuId}, new RowMapper<Menu>() {
            @Override
            public Menu mapRow(ResultSet rs, int arg1) throws SQLException {
                Menu menu = new Menu();
                menu.setMEN_ID(rs.getString("mEN_ID"));
                menu.setMEN_ITEM(rs.getString("mEN_ITEM"));
                menu.setMEN_PRICE(rs.getDouble("mEN_PRICE"));
                menu.setMEN_CALORIES(rs.getInt("mEN_CALORIES"));
                menu.setMEN_SPECIALITY(rs.getString("mEN_SPECIALITY"));
                return menu;
            }
            
        });
        return menuList.get(0);
    }
}