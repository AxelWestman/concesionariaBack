package com.axl.backend.repository;

import com.axl.backend.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Long>  {
}
