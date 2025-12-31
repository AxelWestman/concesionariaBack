package com.axl.backend.controller;

import com.axl.backend.model.Role;
import com.axl.backend.service.RoleService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    //Crear rol
    @PostMapping("/añadirRol")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role savedRole = roleService.createRole(role);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    //Obtener todos los roles
    @GetMapping("/obtenerTodosRoles")
    public ResponseEntity<List<Role>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    //Obtener rol por ID
    @GetMapping("obtenerRolPorId/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @DeleteMapping("eliminarRol/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id) { //el <?> significa que es un comodin genérico en java, algo como un any en ts
        try {
            Role deletedRole = roleService.deleteRole(id);
            return ResponseEntity.ok(deletedRole);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

}
