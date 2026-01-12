package com.axl.backend.controller;

import com.axl.backend.model.Sales;
import com.axl.backend.dto.SalesDTO;
import com.axl.backend.service.SalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService){
        this.salesService = salesService;
    }

    @PostMapping("/insertarVenta")
    public ResponseEntity<?> addSale(@RequestBody SalesDTO sales){
        try{
            Sales savedSale = salesService.createSale(sales);
            return ResponseEntity.ok(savedSale);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/obtenerTodasLasVentas")
    public ResponseEntity<List<Sales>> getAllSales(){
        return ResponseEntity.ok(this.salesService.getAllSales());
    }

    @GetMapping("/obtenerVentaPorId/{id}")
    public ResponseEntity<?> getSaleById(@PathVariable Long id){
        try{
            Sales savedSale = salesService.getSaleById(id);
            return ResponseEntity.ok(savedSale);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarVenta/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable Long id){
        try{
            Sales savedSale = salesService.deleteSale(id);
            return ResponseEntity.ok(savedSale);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

}
