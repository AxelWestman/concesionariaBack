package com.axl.backend.controller;

import com.axl.backend.model.Customer;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import com.axl.backend.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.axl.backend.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping ("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/anadirComprador")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customer){
        try{
            Customer savedCostumer = customerService.createCustomer(customer);
            return ResponseEntity.ok(savedCostumer);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/obtenerCompradores")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/obtenerCompradorPorId/{id}")
    public ResponseEntity<?> getCustomerWithId(@PathVariable Long id){
        try{
            Customer savedCustomer = customerService.getCustomerId(id);
            return ResponseEntity.ok(savedCustomer);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarComprador/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        try{
            Customer savedCustomer = customerService.deleteCustomer(id);
            return ResponseEntity.ok(savedCustomer);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }


}
