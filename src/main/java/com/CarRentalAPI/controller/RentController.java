package com.CarRentalAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalAPI.dto.CarDTO;
import com.CarRentalAPI.dto.CustomerDTO;
import com.CarRentalAPI.dto.RentDTO;
import com.CarRentalAPI.repository.CarRepository;
import com.CarRentalAPI.repository.CustomerRepository;
import com.CarRentalAPI.repository.RentRepository;

@RestController
@RequestMapping("/rent")
public class RentController {
	@Autowired
	RentRepository rent_repo;
	@Autowired
	CarRepository car_repo;
	@Autowired
	CustomerRepository customer_repo;

	@PostMapping("/rent_car")
	public ResponseEntity<String> rentCar(@RequestBody RentDTO rentdto) {
		Optional<CarDTO> carOptional = Optional.ofNullable(car_repo.findByPlateNumber(rentdto.getCarPlateNumber()));
		if (carOptional.isPresent()) {
			Optional<CustomerDTO> customerOptional = customer_repo.findById(rentdto.getCustomerLicenseNumber());
			if (customerOptional.isPresent()) {
				RentDTO rentdto1 = new RentDTO();
				rentdto1.setCarPlateNumber(rentdto.getCarPlateNumber());
				rentdto1.setCustomerLicenseNumber(rentdto.getCustomerLicenseNumber());
				rent_repo.save(rentdto1);
				return ResponseEntity.ok("Car rented successfully to " + customerOptional.get().getCustomerName());
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found!");
		}
	}
	
	
	@GetMapping("/{licenseNumber}")
    public ResponseEntity<List<RentDTO>> getCustomerRentDetails(@PathVariable String licenseNumber) {
        List<RentDTO> rents = rent_repo.findByCustomerLicense(licenseNumber);
        if (rents != null && !rents.isEmpty()) {
            return ResponseEntity.ok(rents);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
