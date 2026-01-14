package com.axl.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "attributes")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String data_type;

    public Attribute(){};

    public Attribute(String name, String data_type){
        this.name = name;
        this.data_type = data_type;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getData_type(){
        return data_type;
    }

    public void setData_type(String data_type){
        this.data_type = data_type;
    }


}
