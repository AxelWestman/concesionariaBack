package com.axl.backend.service;
import com.axl.backend.model.Customer;
import com.axl.backend.repository.CustomerRepository;
import com.axl.backend.repository.SalesRepository;
import com.axl.backend.model.Sales;
import com.axl.backend.dto.SalesDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalesService {

    private final SalesRepository salesRepository;
    private final CustomerRepository customerRepository;

    public SalesService(SalesRepository salesRepository, CustomerRepository customerRepository){
        this.salesRepository = salesRepository;
        this.customerRepository = customerRepository;
    }

    public Sales createSale(SalesDTO dto){

        Customer customer = customerRepository.findById(dto.getCustomer_id()).orElseThrow(() -> new RuntimeException("Customer no encontrado"));

        Sales sale = new Sales(
                customer,
                dto.getTotal()
        );

        return salesRepository.save(sale);

    }

    public Sales getSaleById(Long id){
        Sales sale = salesRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        return sale;
    }

    public List<Sales> getAllSales(){ return salesRepository.findAll(); }

    public Sales deleteSale(Long id){
        Sales sale = this.getSaleById(id);
        salesRepository.deleteById(sale.getId());
        return sale;
    }

}
