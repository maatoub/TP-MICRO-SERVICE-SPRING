package com.app.tp1service.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.tp1service.DTOs.CustomerDTO;
import com.app.tp1service.Exception.EmailAlreadyUsedException;
import com.app.tp1service.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")

public class CustomerController {

    private CustomerService service;

    @GetMapping("/")
    public List<CustomerDTO> listCustomerDTOs() {
        return service.allCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        return service.getCustomer(id);
    }

    @PostMapping("/save")
    public CustomerDTO addCustomerDTO(@RequestBody CustomerDTO customerDTO) throws EmailAlreadyUsedException {
        return service.saveCustomer(customerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}
