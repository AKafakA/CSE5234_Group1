package edu.osu.cse5234.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="SHIPPING_INFO") 
public class ShippingInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")	
	private int id;
	
	@Transient
	private String name;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ADDRESS1")
	private String addressLine1;
	
	@Column(name = "ADDRESS2")
	private String addressLine2;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;

	@Column(name = "ZIP")
	private String zip;
	
	@Column(name = "UPS_SHIPPING_REF")
	private int shippingRefNumber;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		
		return email;
	}

	public int getShippingReferenceNumber() {
		return shippingRefNumber;
	}

	public void setShippingReferenceNumber(int shippingRefNumber) {
		this.shippingRefNumber = shippingRefNumber;
	}

}
