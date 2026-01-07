package com.axl.backend.service;

import com.axl.backend.dto.CustomerDTO;
import com.axl.backend.model.Customer;
import com.axl.backend.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerDTO dto){
        Customer customer = new Customer(
                dto.getName(),
                dto.getEmail(),
                dto.getPhone()
        );

        return customerRepository.save(customer);

    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerId(Long id){
       Customer customer =  customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
       return customer;
    }

    public Customer deleteCustomer(Long id){
        Customer customer = this.getCustomerId(id);
        customerRepository.deleteById(customer.getId());
        return customer;
    }


}
