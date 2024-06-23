package com.CarRentalAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalAPI.dto.CarDTO;
import com.CarRentalAPI.repository.CarRepository;
import com.CarRentalAPI.repository.CustomerRepository;
import com.CarRentalAPI.repository.RentRepository;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	RentRepository rent_repo;

	@Autowired
	CarRepository car_repo;

	@Autowired
	CustomerRepository customer_repo;

	@PostMapping("/add_car")
	public ResponseEntity<CarDTO> addCar(@RequestBody CarDTO cardto) {
		car_repo.save(cardto);

		return ResponseEntity.status(HttpStatus.CREATED).body(cardto);

	}

	@GetMapping("/get_all_car")
	public ResponseEntity<List<CarDTO>> getAllCars() {
		List<CarDTO> cars = car_repo.findAll();
		return ResponseEntity.ok(cars);
	}

	@GetMapping("/available_cars")
	public ResponseEntity<List<CarDTO>> displayAvailableCars() {
		List<CarDTO> availableCars = car_repo.findAvailableCars();
		return ResponseEntity.ok(availableCars);
	}

	@DeleteMapping("/delete_car")
	public ResponseEntity<String> deleteCar(@RequestParam String plateNumber) {
		CarDTO car = car_repo.findByPlateNumber(plateNumber);
		if (car != null) {
			car_repo.deleteById(car.getPlateNumber());
			return ResponseEntity.ok("Car deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found!");
		}
	}

	@PutMapping("/update_car")
	public ResponseEntity<String> updateCar(@RequestBody CarDTO carDto) {
		Optional<CarDTO> existingCarOptional = Optional.ofNullable(car_repo.findByPlateNumber(carDto.getPlateNumber()));
		if (existingCarOptional.isPresent()) {
			CarDTO existingCar = existingCarOptional.get();
			existingCar.setName(carDto.getName());
			existingCar.setBrand(carDto.getBrand());
			existingCar.setPricePerDay(carDto.getPricePerDay());
			existingCar.setCostPrice(carDto.getCostPrice());
			existingCar.setColor(carDto.getColor());
			car_repo.save(existingCar);
			return ResponseEntity.ok("Car details updated successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found!");
		}
	}

	@GetMapping("/get_a_car_details")
	public ResponseEntity<CarDTO> getCarDetails(@RequestParam String plateNumber) {
		CarDTO car = car_repo.findByPlateNumber(plateNumber);
		if (car != null) {
			return ResponseEntity.ok(car);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/brand/{brand}")
	public ResponseEntity<List<CarDTO>> getCarsByBrand(@PathVariable String brand) {
		List<CarDTO> cars = car_repo.findByBrand(brand);
		if (cars != null && !cars.isEmpty()) {
			return ResponseEntity.ok(cars);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/brands")
	public ResponseEntity<List<String>> getAllBrands() {
		List<String> brands = car_repo.findAllBrands();
		return ResponseEntity.ok(brands);
	}

}
