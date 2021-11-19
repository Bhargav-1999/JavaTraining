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
public class VendorDAO {

	@Autowired  
    JdbcTemplate jdbc;  
	
	 public String generatecustid() {
	    	String cmd = "select max(VEN_ID) mid from Vendor";
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
	         String stockId = String.format("V%03d", tempId);
	         return stockId;
		}
	
	 public String addvendor(Vendor ven) {
		 String id =generatecustid();
		 ven.setVEN_ID(id);
	    	String cmd = "insert into Vendor(VEN_ID,VEN_NAME,VEN_PHONE,VEN_USERNAME,VEN_PASSWORD,VEN_EMAIL) values(?,?,?,?,?,?)";
	    	 jdbc.update(cmd,ven.getVEN_ID(),ven.getVEN_NAME(),ven.getVEN_PHONE(),
	    			 ven.getVEN_USERNAME(), 
	    			 ven.getVEN_PASSWORD(),ven.getVEN_EMAIL());
	    	 final String username = "mphasisjavagrouprll@gmail.com";
	            final String password = "Azby@1029";

	            Properties prop = new Properties();
	            prop.put("mail.smtp.host", "smtp.gmail.com");
	            prop.put("mail.smtp.port", "587");
	            prop.put("mail.smtp.auth", "true");
	            prop.put("mail.smtp.starttls.enable", "true"); //TLS
	            
	            Session session = Session.getInstance(prop,
	                    new javax.mail.Authenticator() {
	                        protected PasswordAuthentication getPasswordAuthentication() {
	                            return new PasswordAuthentication(username, password);
	                        }
	                    });

	            try {

	                Message message = new MimeMessage(session);
	                message.setFrom(new InternetAddress("mphasisjavagrouprll@gmail.com"));
	                message.setRecipients(
	                        Message.RecipientType.TO,
	                        InternetAddress.parse("sivanipeddapothula05@gmail.com, nagachaithanyajuturu@gmail.com")
	                );
	                message.setSubject("Account Details");
	                message.setText("Account Created Succesfully,"
	                        + "\n\n Let your Franchise shine...!");

	                Transport.send(message);

	                System.out.println("Done");

	            } catch (MessagingException e) {
	                e.printStackTrace();
	            }
	    	 return "Account Created Succesfully";
	    	
	    }
    
    public String authenticate(String user,String pwd) {
        String cmd = "select count(*) cnt from Vendor where  VEN_USERNAME=? "
                + " AND VEN_PASSWORD=?";
        List str=jdbc.query(cmd,new Object[] {user,pwd}, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                return rs.getInt("cnt");
            }
            
        });
        return str.get(0).toString();
    }
    public Vendor authenv(String user) {
    	 String cmd = "select * from vendor where  VEN_USERNAME=? ";
        List<Vendor> str=jdbc.query(cmd,new Object[] {user}, new RowMapper<Vendor>() {
            @Override
            public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	Vendor c=new Vendor();
				c.setVEN_ID(rs.getString("VEN_ID"));
				c.setVEN_NAME(rs.getString("VEN_NAME"));
				c.setVEN_PHONE(rs.getString("VEN_PHONE"));
				c.setVEN_USERNAME(rs.getString("VEN_USERNAME"));
				c.setVEN_PASSWORD(rs.getString("VEN_PASSWORD"));
				c.setVEN_EMAIL(rs.getString("VEN_EMAIL"));
				return c;
            }
            
        });
        return str.get(0);
	}
	
}
