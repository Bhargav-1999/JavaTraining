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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdersService {
	
	 @Autowired
	    private OrdersRepository repo;
	 @Autowired
	    private OrdersDAO dao;
	 @Autowired 
	    private MenuDAO mdao;
	    
	    @Autowired 
	    private WalletDAO wdao;
	    
	    @Autowired  
	    JdbcTemplate jdbc;
	    
		 public String generatecustid() {
		    	String cmd = "select max(ORD_ID) mid from Orders";
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
		         String stockId = String.format("O%03d", tempId);
		         return stockId;
			}
	    
	    
	    public String placeOrder(Orders order) {
	    	String id =generatecustid();
	    	order.setOrd_id(id);
	        Menu menu = mdao.searchMenu(order.getMEN_ID());
	        Wallet wallet = wdao.showWallet(order.getCus_id(), order.getWal_source());
	        double balance = wallet.getWal_amount();
	        double billAmount = order.getOrd_quantity()*menu.getMEN_PRICE();
	        System.out.println(balance);
	        System.out.println(billAmount);
	        if (balance-billAmount > 0) {
	            order.setOrd_status("PENDING");
	            order.setOrd_billamount(billAmount);
	            repo.save(order);
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
	                message.setSubject("Testing RLL");
	                message.setText("Your Order Placed from PIGGY,"
	                        + "\n\n Enjoy your Meal...!");

	                Transport.send(message);

	                System.out.println("Done");

	            } catch (MessagingException e) {
	                e.printStackTrace();
	            }
	            wdao.updateWallet(order.getCus_id(), order.getWal_source(), billAmount);
	            return "Order Placed Successfully...and Amount Debited";
	        }
	        return "Insufficient Funds...";
	    }
	    
	    public String acceptOrRejectOrder(String ordId,String venId,String status) {
			Orders orders = dao.searchByOrderId(ordId);
			String vid = orders.getVEN_ID().trim();
			System.out.println(vid);
			System.out.println(venId);
			String cid = orders.getCus_id();
			String walType = orders.getWal_source();
			double billAmount = orders.getOrd_billamount();
			if(vid.equals(venId)) {
				if (status.toUpperCase().equals("YES")) {
					dao.updateStatus(ordId,"ACCEPTED");
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
		                message.setSubject("ORDER STATUS");
		                message.setText("Your is Accepted from the Vendor,"
		                        + "\n\n Enjoy your Meal...!");

		                Transport.send(message);

		                System.out.println("Done");

		            } catch (MessagingException e) {
		                e.printStackTrace();
		            }
					return "Order Accepted...";
				} else {
					dao.updateStatus(ordId, "DENIED");
					wdao.refundWallet(cid, walType, billAmount);
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
		                message.setSubject("ORDER STATUS");
		                message.setText("Your Order is Denied Place the order the again and ,"
		                        + "\n\n Enjoy your Meal...!");

		                Transport.send(message);

		                System.out.println("Done");

		            } catch (MessagingException e) {
		                e.printStackTrace();
		            }
					return "Order Rejected and Amount Refunded...";
				}
			}
			return "You are an unauthorized Vendor";
			
		}

	
		public List<Orders> showOrders() {
	        return repo.findAll();
	    }
		 public Orders get(String id) {
		     return repo.findById(id).get();
		    
		 }
		   public List<Orders> showCustomerPendingOrders(String custId) {
				// TODO Auto-generated method stub
				return dao.showCustomerPendingOrders(custId);
			}
			public List<Orders> showCustomerOrders(String custId) {
				// TODO Auto-generated method stub
				return dao.showCustomerOrders(custId);
			}
			public List<Orders> showVendorPendingOrders(String venId) {
				// TODO Auto-generated method stub
				return dao.showVendorPendingOrders(venId);
			}
			public List<Orders> showVendorOrders(String venId) {
				// TODO Auto-generated method stub
				return dao.showVendorOrders(venId);
			}
		
}
