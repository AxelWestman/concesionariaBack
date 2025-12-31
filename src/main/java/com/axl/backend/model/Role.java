package com.axl.backend.model;
import jakarta.persistence.*;


@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rol;

    // 🔹 Constructor vacío (OBLIGATORIO para JPA)
    public Role() {
    }

    // 🔹 Constructor útil
    public Role(String rol) {
        this.rol = rol;
    }

    // 🔹 Getters & Setters
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
