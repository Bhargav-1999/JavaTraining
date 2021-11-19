package com.example.demo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Orders {
	
	private String ord_id;
	private String Cus_id;
	private String VEN_ID;
	private String wal_source;
	private String MEN_ID;
	private Date ord_date;
	private int ord_quantity;
	private double ord_billamount;
	private String ord_status;
	private String ord_comments;
	
	@Id
	public String getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}
	public String getCus_id() {
		return Cus_id;
	}
	public void setCus_id(String cus_id) {
		Cus_id = cus_id;
	}
	public String getVEN_ID() {
		return VEN_ID;
	}
	public void setVEN_ID(String vEN_ID) {
		VEN_ID = vEN_ID;
	}
	public String getWal_source() {
		return wal_source;
	}
	public void setWal_source(String wal_source) {
		this.wal_source = wal_source;
	}
	public String getMEN_ID() {
		return MEN_ID;
	}
	public void setMEN_ID(String mEN_ID) {
		MEN_ID = mEN_ID;
	}
	public Date getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(Date ord_date) {
		this.ord_date = ord_date;
	}
	public int getOrd_quantity() {
		return ord_quantity;
	}
	public void setOrd_quantity(int ord_quantity) {
		this.ord_quantity = ord_quantity;
	}
	public double getOrd_billamount() {
		return ord_billamount;
	}
	public void setOrd_billamount(double ord_billamount) {
		this.ord_billamount = ord_billamount;
	}
	public String getOrd_status() {
		return ord_status;
	}
	public void setOrd_status(String ord_status) {
		this.ord_status = ord_status;
	}
	public String getOrd_comments() {
		return ord_comments;
	}
	public void setOrd_comments(String ord_comments) {
		this.ord_comments = ord_comments;
	}
	
}