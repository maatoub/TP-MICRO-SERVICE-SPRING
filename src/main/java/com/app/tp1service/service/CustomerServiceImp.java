package com.app.tp1service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.tp1service.DTOs.CustomerDTO;
import com.app.tp1service.Exception.EmailAlreadyUsedException;
import com.app.tp1service.mapper.CustomerMapper;
import com.app.tp1service.model.Customer;
import com.app.tp1service.repositories.CustomerRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

    private CustomerRepo customerRepo;
    private CustomerMapper mapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) throws EmailAlreadyUsedException {

        if (customerRepo.existsByEmail(customerDTO.getEmail())) {
            throw new EmailAlreadyUsedException("This email already exists");
        }
        Customer customer = mapper.toCustomer(customerDTO);
        Customer customerSaved = customerRepo.save(customer);
        return mapper.toCustomerDTO(customerSaved);
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow();
        return mapper.toCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> allCustomers() {
        return customerRepo.findAll().stream().map(cus -> mapper.toCustomerDTO(cus)).collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

}
