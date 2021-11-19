package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDAO {
	@Autowired  
    JdbcTemplate jdbc;
	


	public Orders searchByOrderId(String ordId) {
        String cmd = "select * from Orders where ORD_ID=?";
        List<Orders> ordersList=null;
        ordersList=jdbc.query(cmd,new Object[] {ordId}, new RowMapper<Orders>() {
            @Override
            public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Orders orders = new Orders();
				orders.setOrd_id(rs.getString("ord_id"));
				orders.setCus_id(rs.getString("Cus_id"));
				orders.setVEN_ID(rs.getString("VEN_ID"));
				orders.setWal_source(rs.getString("wal_source"));
				orders.setMEN_ID(rs.getString("MEN_ID"));
				orders.setOrd_date(rs.getDate("ord_date"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ord_billamount"));
				orders.setOrd_status(rs.getString("ord_status"));
				orders.setOrd_comments(rs.getString("ord_comments"));
				return orders;
			}
            
        });
        return ordersList.get(0);
    }
	
	public String updateStatus(String ordId,String ordStatus) {
		String cmd = "Update Orders set ORD_STATUS=? WHERE ORD_ID=?";
		jdbc.update(cmd, new Object[] {ordStatus,ordId});
		return "Order Accepted...";
	}
	
	public List<Orders> showVendorPendingOrders(String venId) {
		String cmd = "select * from Orders where ORD_STATUS='PENDING' AND VEN_ID=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {venId}, new RowMapper<Orders>() {

			@Override
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getString("ord_id"));
				orders.setCus_id(rs.getString("Cus_id"));
				orders.setVEN_ID(rs.getString("VEN_ID"));
				orders.setWal_source(rs.getString("wal_source"));
				orders.setMEN_ID(rs.getString("MEN_ID"));
				orders.setOrd_date(rs.getDate("ord_date"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ord_billamount"));
				orders.setOrd_status(rs.getString("ord_status"));
				orders.setOrd_comments(rs.getString("ord_comments"));
				return orders;
			}
			
		});
		return ordersList;
	}
	
	public List<Orders> showVendorOrders(String venId) {
		String cmd = "select * from Orders where VEN_ID=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {venId}, new RowMapper<Orders>() {

			@Override
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getString("ord_id"));
				orders.setCus_id(rs.getString("Cus_id"));
				orders.setVEN_ID(rs.getString("VEN_ID"));
				orders.setWal_source(rs.getString("wal_source"));
				orders.setMEN_ID(rs.getString("MEN_ID"));
				orders.setOrd_date(rs.getDate("ord_date"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ord_billamount"));
				orders.setOrd_status(rs.getString("ord_status"));
				orders.setOrd_comments(rs.getString("ord_comments"));
				return orders;
			}
			
		});
		return ordersList;
	}
	
	public List<Orders> showCustomerOrders(String custId) {
		String cmd = "select * from Orders where  CUS_ID=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {custId}, new RowMapper<Orders>() {

			@Override
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getString("ord_id"));
				orders.setCus_id(rs.getString("Cus_id"));
				orders.setVEN_ID(rs.getString("VEN_ID"));
				orders.setWal_source(rs.getString("wal_source"));
				orders.setMEN_ID(rs.getString("MEN_ID"));
				orders.setOrd_date(rs.getDate("ord_date"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ord_billamount"));
				orders.setOrd_status(rs.getString("ord_status"));
				orders.setOrd_comments(rs.getString("ord_comments"));
				return orders;
			}
			
		});
		return ordersList;
	}
	public List<Orders> showCustomerPendingOrders(String custId) {
		String cmd = "select * from Orders where ORD_STATUS='PENDING' AND CUS_ID=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {custId}, new RowMapper<Orders>() {

			@Override
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getString("ord_id"));
				orders.setCus_id(rs.getString("Cus_id"));
				orders.setVEN_ID(rs.getString("VEN_ID"));
				orders.setWal_source(rs.getString("wal_source"));
				orders.setMEN_ID(rs.getString("MEN_ID"));
				orders.setOrd_date(rs.getDate("ord_date"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ord_billamount"));
				orders.setOrd_status(rs.getString("ord_status"));
				orders.setOrd_comments(rs.getString("ord_comments"));
				return orders;
			
		}
		});
		return ordersList;
		}
}
