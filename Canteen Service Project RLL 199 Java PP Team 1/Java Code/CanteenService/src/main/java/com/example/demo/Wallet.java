package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
private String wal_id;
private String Cus_id;
private double wal_amount;
private String wal_source;

public String getWal_id() {
	return wal_id;
}
public void setWal_id(String wal_id) {
	this.wal_id = wal_id;
}

@Id
public String getCus_id() {
	return Cus_id;
}
public void setCus_id(String cus_id) {
	Cus_id = cus_id;
}
public double getWal_amount() {
	return wal_amount;
}
public void setWal_amount(double wal_amount) {
	this.wal_amount = wal_amount;
}
public String getWal_source() {
	return wal_source;
}
public void setWal_source(String wal_source) {
	this.wal_source = wal_source;
}

}
