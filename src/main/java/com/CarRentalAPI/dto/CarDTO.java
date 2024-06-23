package com.CarRentalAPI.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
//@Table(name="car")
public class CarDTO {
	
	@Id
	private String plateNumber;
	@Column(name="carname")
	private String name;
	@Column
	private String brand;
	@Column
	private int pricePerDay;
	@Column
	private int costPrice;
	@Column
	private String color;
	
	public CarDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public CarDTO(String plateNumber, String name, String brand, int pricePerDay, int costPrice, String color) {
		super();
		this.plateNumber = plateNumber;
		this.name = name;
		this.brand = brand;
		this.pricePerDay = pricePerDay;
		this.costPrice = costPrice;
		this.color = color;
	}

	@Override
	public String toString() {
		return "CarDTO [plateNumber=" + plateNumber + ", name=" + name + ", brand=" + brand + ", pricePerDay="
				+ pricePerDay + ", costPrice=" + costPrice + ", color=" + color + "]";
	}
	
	
}
