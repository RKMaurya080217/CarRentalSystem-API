package com.CarRentalAPI.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerDTO {
	@Id
	private String licenseNumber;
	@Column
	private String customerName;
	@Column
	private int customerAge;
	@Column
	private String nationalIDNumber;
	
	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getNationalIDNumber() {
		return nationalIDNumber;
	}

	public void setNationalIDNumber(String nationalIDNumber) {
		this.nationalIDNumber = nationalIDNumber;
	}

	public CustomerDTO(String licenseNumber, String customerName, int customerAge, String nationalIDNumber) {
		super();
		this.licenseNumber = licenseNumber;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.nationalIDNumber = nationalIDNumber;
	}

	@Override
	public String toString() {
		return "CustomerDTO [licenseNumber=" + licenseNumber + ", customerName=" + customerName + ", customerAge="
				+ customerAge + ", nationalIDNumber=" + nationalIDNumber + "]";
	}
	
	
	
}
