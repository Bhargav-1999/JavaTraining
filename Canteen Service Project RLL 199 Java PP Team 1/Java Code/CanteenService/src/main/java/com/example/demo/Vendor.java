package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {
 private String VEN_ID;
 private String VEN_NAME;
 private String VEN_PHONE;
 private String VEN_USERNAME;
 private String VEN_PASSWORD;
 private String VEN_EMAIL;
 
@Id
public String getVEN_ID() {
	return VEN_ID;
}
public void setVEN_ID(String vEN_ID) {
	VEN_ID = vEN_ID;
}
public String getVEN_NAME() {
	return VEN_NAME;
}
public void setVEN_NAME(String vEN_NAME) {
	VEN_NAME = vEN_NAME;
}
public String getVEN_PHONE() {
	return VEN_PHONE;
}
public void setVEN_PHONE(String vEN_PHONE) {
	VEN_PHONE = vEN_PHONE;
}
public String getVEN_USERNAME() {
	return VEN_USERNAME;
}
public void setVEN_USERNAME(String vEN_USERNAME) {
	VEN_USERNAME = vEN_USERNAME;
}
public String getVEN_PASSWORD() {
	return VEN_PASSWORD;
}
public void setVEN_PASSWORD(String vEN_PASSWORD) {
	VEN_PASSWORD = vEN_PASSWORD;
}
public String getVEN_EMAIL() {
	return VEN_EMAIL;
}
public void setVEN_EMAIL(String vEN_EMAIL) {
	VEN_EMAIL = vEN_EMAIL;
}
 
 
 
}
