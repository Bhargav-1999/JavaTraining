package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Customer {
	private String Cus_id;
	private String Cus_Name;
	private String Cus_Phn_No;
	private String Cus_Username;
	private String Cus_Password;
	private String Cus_Email;
	
	@Id
	public String getCus_id() {
		return Cus_id;
	}
	public void setCus_id(String cus_id) {
		Cus_id = cus_id;
	}
	public String getCus_Name() {
		return Cus_Name;
	}
	public void setCus_Name(String cus_Name) {
		Cus_Name = cus_Name;
	}
	public String getCus_Phn_No() {
		return Cus_Phn_No;
	}
	public void setCus_Phn_No(String cus_Phn_No) {
		Cus_Phn_No = cus_Phn_No;
	}
	public String getCus_Username() {
		return Cus_Username;
	}
	public void setCus_Username(String cus_Username) {
		Cus_Username = cus_Username;
	}
	public String getCus_Password() {
		return Cus_Password;
	}
	public void setCus_Password(String cus_Password) {
		Cus_Password = cus_Password;
	}
	public String getCus_Email() {
		return Cus_Email;
	}
	public void setCus_Email(String cus_Email) {
		Cus_Email = cus_Email;
	}
	
	
}
