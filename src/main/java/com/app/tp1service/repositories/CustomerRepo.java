package com.app.tp1service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tp1service.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Boolean existsByEmail(String email);
}