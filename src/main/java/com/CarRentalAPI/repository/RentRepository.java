package com.CarRentalAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CarRentalAPI.dto.RentDTO;

@Repository
public interface RentRepository extends JpaRepository<RentDTO, String> {

	@Query(value = "SELECT * FROM Rent r WHERE r.customer_license_number = :customerLicenseNumber", nativeQuery = true)
	//@Query(value = "SELECT customer_name, customer_license_number, car_plate_number FROM Rent r join customer c WHERE r.customer_license_number = c.license_number and r.customer_license_number= :customerLicenseNumber", nativeQuery = true)
	List<RentDTO> findByCustomerLicense(String customerLicenseNumber);
}
