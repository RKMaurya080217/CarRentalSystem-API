package com.CarRentalAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CarRentalAPI.dto.CarDTO;

@Repository
public interface CarRepository extends JpaRepository<CarDTO, String> {

	CarDTO findByPlateNumber(String plateNumber);

	@Query(nativeQuery = true, value = "SELECT * FROM CarDTO c WHERE c.plate_number NOT IN (SELECT r.car_plate_number FROM Rent r)")
	    List<CarDTO> findAvailableCars();

	List<CarDTO> findByBrand(String brand);
	
	 @Query(nativeQuery = true, value ="SELECT DISTINCT c.brand FROM CarDTO c")
	    List<String> findAllBrands();

}
