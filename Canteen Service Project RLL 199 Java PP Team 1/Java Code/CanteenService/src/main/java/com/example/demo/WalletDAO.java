package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class WalletDAO {
	@Autowired  
    JdbcTemplate jdbc;
	
	 public String generatecustid() {
	    	String cmd = "select max(WAL_ID) mid from Wallet";
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
	         String stockId = String.format("W%03d", tempId);
	         return stockId;
		}
	
	 public String addwallet(Wallet wal) {
	    	String id =generatecustid();
	    	wal.setWal_id(id);
	    	String cmd = "insert into Wallet(CUS_ID,WAL_ID,WAL_AMOUNT,WAL_SOURCE) values(?,?,?,?)";
	    	 jdbc.update(cmd,wal.getCus_id(),wal.getWal_id(),wal.getWal_amount(),
	    			 wal.getWal_source()); 
	    	 return "Wallet added Succesfully";
	    	
	    }
	 
	 public String refundWallet(String custId, String walType, double walAmount) {
			String cmd = "Update Wallet set WAL_AMOUNT=WAL_AMOUNT+? "
					+ " WHERE CUS_ID=? AND WAL_SOURCE=?";
			jdbc.update(cmd, new Object[] {walAmount,custId,walType});
			return "Amount Debited from Wallet...";
		}
	
	public List<Wallet> showCustomerWallet(String custId) {
		String cmd = "select * from Wallet where  CUS_ID=?";
		List<Wallet> walletList=null;
		walletList=jdbc.query(cmd,new Object[] {custId}, new RowMapper<Wallet>() {

			@Override
			public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
				Wallet wallet = new Wallet();
				wallet.setWal_id(rs.getString("wal_id"));
				wallet.setCus_id(rs.getString("Cus_id"));
				wallet.setWal_amount(rs.getDouble("wal_amount"));
				wallet.setWal_source(rs.getString("wal_source"));
				return wallet;
			}
			
		});
		return walletList;
	}
	public String updateWallet(String custId, String walType, double walAmount) {
        String cmd = "Update Wallet set WAL_AMOUNT=WAL_AMOUNT-? "
                + " WHERE CUS_ID=? AND WAL_SOURCE=?";
        jdbc.update(cmd, new Object[] {walAmount,custId,walType});
        return "Amount Debited from Wallet...";
    }
	public Wallet showWallet(String custId, String waltSrc) {
		String cmd = "select * from Wallet where  CUS_ID=?"+"AND WAL_SOURCE=?";
		List<Wallet> walletList=null;
		walletList=jdbc.query(cmd,new Object[] {custId,waltSrc}, new RowMapper<Wallet>() {

			@Override
			public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
				Wallet wallet = new Wallet();
				wallet.setWal_id(rs.getString("wal_id"));
				wallet.setCus_id(rs.getString("Cus_id"));
				wallet.setWal_amount(rs.getDouble("wal_amount"));
				wallet.setWal_source(rs.getString("wal_source"));
				return wallet;
			
		}
		});
		return walletList.get(0);
		}
}
