package com.axl.backend.model;
import jakarta.persistence.*;


@Entity //le decimos a JPA que esto es una entidad
@Table(name = "roles") //Indica el nombre de la tabla en la BD
public class Role {
    @Id//con esto indicamos que será la PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indicamos que es autoincremental y el valor lo genera la BD
    private Long id; //Usamos siempre Long, no int

    @Column(nullable = false, unique = true) //indicamos que esta columan no puede ser nula, y es unica
    private String rol; //en la bd será varchar, aca es string

    // 🔹 Constructor vacío (OBLIGATORIO para JPA), Hibernate crea obj por reflexion, sin esto no arranca
    public Role() {
    }

    public Role(String rol) {
        this.rol = rol;
    } //constructor útil (opcional pero recomendado)
    //esto sirve para crear objectos fácil en código con 'new Role("ADMIN")'

    // 🔹 Getters & Setters. Spring, Jackson y Hibernate los usan, sirven para serializar JSON, para escribir y leer datos
    public Long getId() {
        return id;
    }

    public String getRol() {
        return rol;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
