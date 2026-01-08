package com.axl.backend.dto;

import java.math.BigDecimal;

public class SalesDTO {

    private Long customerId;
    private BigDecimal total;


    public SalesDTO(Long customer_id, BigDecimal total){
        this.customerId = customer_id;
        this.total = total;
    }

    public Long getCustomer_id() {
        return customerId;
    }

    public void setCustomer_id(Long customer_id) {
        this.customerId = customer_id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
