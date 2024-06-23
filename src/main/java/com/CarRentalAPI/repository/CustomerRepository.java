package com.CarRentalAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CarRentalAPI.dto.CustomerDTO;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDTO, String>{

}
