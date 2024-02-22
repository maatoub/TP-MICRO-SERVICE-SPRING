package com.app.tp1service.service;

import java.util.List;

import com.app.tp1service.DTOs.CustomerDTO;
import com.app.tp1service.Exception.EmailAlreadyUsedException;

public interface CustomerService {

    CustomerDTO saveCustomer(CustomerDTO customer) throws EmailAlreadyUsedException;

    List<CustomerDTO> allCustomers();

    void deleteCustomer(Long id);

    CustomerDTO getCustomer (Long id);
}
