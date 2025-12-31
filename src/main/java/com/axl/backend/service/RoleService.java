package com.axl.backend.service;

import com.axl.backend.model.Role;
import com.axl.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role deleteRole(Long id) {
        Role role = roleRepository.findById(id) //busca si existe en la bd
                .orElseThrow(() -> new RuntimeException("Role no encontrado")); //si no lo encuentra, devuelve esto
        roleRepository.delete(role); //si lo encuentra lo elimina
        return role; //informa cual fue el que se borro
    }

    public Role getRoleById(Long id){
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role no encontrado"));
    }



}
