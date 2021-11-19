package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
	 private String MEN_ID;
	    private String MEN_ITEM;
	    private double MEN_PRICE;
	    private double MEN_CALORIES;
	    private String MEN_SPECIALITY;
	    
	    @Id
		public String getMEN_ID() {
			return MEN_ID;
		}
		public void setMEN_ID(String mEN_ID) {
			MEN_ID = mEN_ID;
		}
		public String getMEN_ITEM() {
			return MEN_ITEM;
		}
		public void setMEN_ITEM(String mEN_ITEM) {
			MEN_ITEM = mEN_ITEM;
		}
		public double getMEN_PRICE() {
			return MEN_PRICE;
		}
		public void setMEN_PRICE(double mEN_PRICE) {
			MEN_PRICE = mEN_PRICE;
		}
		public double getMEN_CALORIES() {
			return MEN_CALORIES;
		}
		public void setMEN_CALORIES(double mEN_CALORIES) {
			MEN_CALORIES = mEN_CALORIES;
		}
		public String getMEN_SPECIALITY() {
			return MEN_SPECIALITY;
		}
		public void setMEN_SPECIALITY(String mEN_SPECIALITY) {
			MEN_SPECIALITY = mEN_SPECIALITY;
		}
	    
	    
}
