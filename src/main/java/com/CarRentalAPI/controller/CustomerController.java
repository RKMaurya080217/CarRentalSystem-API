package com.CarRentalAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalAPI.dto.CustomerDTO;
import com.CarRentalAPI.repository.CarRepository;
import com.CarRentalAPI.repository.CustomerRepository;
import com.CarRentalAPI.repository.RentRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	RentRepository rent_repo;
	@Autowired
	CarRepository car_repo;
	@Autowired
	CustomerRepository customer_repo;
	
	@PostMapping("/add_customer")
	public ResponseEntity<CustomerDTO> addCar(@RequestBody CustomerDTO cutomerdto) {
		customer_repo.save(cutomerdto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cutomerdto);

	}
	
	@GetMapping("/get_all_customer")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customer_repo.findAll();
        return ResponseEntity.ok(customers);
    }	

	
}
