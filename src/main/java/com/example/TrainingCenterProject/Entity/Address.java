package com.example.TrainingCenterProject.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	private String address;
	private String city;
	private String state;
	private String pincode;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Address(String address, String city, String state, String pincode) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

}
