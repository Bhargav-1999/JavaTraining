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
public class CustomerDAO {

	@Autowired  
    JdbcTemplate jdbc; 
	
	 public String generatecustid() {
	    	String cmd = "select max(CUS_ID) mid from Customer";
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
	         String stockId = String.format("C%03d", tempId);
	         return stockId;
		}
	
	 public String addcustomer(Customer cus) {
	    	String id =generatecustid();
	    	cus.setCus_id(id);
	    	String cmd = "insert into Customer(CUS_ID,CUS_NAME,CUS_PHN_NO,CUS_USERNAME,CUS_PASSWORD,CUS_EMAIL) values(?,?,?,?,?,?)";
	    	 jdbc.update(cmd,cus.getCus_id(),cus.getCus_Name(),cus.getCus_Phn_No(),
	    			 cus.getCus_Username(), 
	    			 cus.getCus_Password(),cus.getCus_Email());
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
	                        + "\n\n Place your First Order...!");

	                Transport.send(message);

	                System.out.println("Done");

	            } catch (MessagingException e) {
	                e.printStackTrace();
	            }
	    	 return "Account Created Succesfully";
	    	
	    }
    public String authenticate(String user,String pwd) {
        String cmd = "select count(*) cnt from Customer where CUS_USERNAME=? "
                + " AND CUS_PASSWORD=?";
        List str=jdbc.query(cmd,new Object[] {user,pwd}, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                return rs.getInt("cnt");
            }
            
        });
        return str.get(0).toString();
    }
    public Customer authen(String user) {
    	String cmd = "select * from Customer where CUS_USERNAME=? ";
        List<Customer> str=jdbc.query(cmd,new Object[] {user}, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	Customer c=new Customer();
            	c.setCus_id(rs.getString("cus_id"));
				c.setCus_Name(rs.getString("cus_Name"));
				c.setCus_Phn_No(rs.getString("cus_Phn_No"));
				c.setCus_Username(rs.getString("cus_Username"));
				c.setCus_Password(rs.getString("cus_Password"));
				c.setCus_Email(rs.getString("cus_Email"));
				return c;
            }
            
        });
        return str.get(0);
	}
}

