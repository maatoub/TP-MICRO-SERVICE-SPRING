package com.app.tp1service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.tp1service.DTOs.CustomerDTO;
import com.app.tp1service.model.Customer;

@Service
public class CustomerMapper {
    private ModelMapper mapper = new ModelMapper();

    public CustomerDTO toCustomerDTO(Customer customer) {
        return mapper.map(customer, CustomerDTO.class);
    }

    public Customer toCustomer(CustomerDTO customerDTO) {
        return mapper.map(customerDTO, Customer.class);
    }
}
