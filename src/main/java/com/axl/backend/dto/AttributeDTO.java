package com.axl.backend.dto;

public class AttributeDTO {

    private String name;
    private String data_type;

    public AttributeDTO(String name, String data_type){
        this.name = name;
        this.data_type = data_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }
}
