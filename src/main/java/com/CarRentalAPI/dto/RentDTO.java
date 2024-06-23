package com.CarRentalAPI.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rent")
public class RentDTO {
	@Id
	private String customerLicenseNumber;
	@Column
	private String carPlateNumber;

	private String custName;
	
	public String getCustomerLicenseNumber() {
		return customerLicenseNumber;
	}
	public void setCustomerLicenseNumber(String customerLicenseNumber) {
		this.customerLicenseNumber = customerLicenseNumber;
	}
	public String getCarPlateNumber() {
		return carPlateNumber;
	}
	public void setCarPlateNumber(String carPlateNumber) {
		this.carPlateNumber = carPlateNumber;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	
}
