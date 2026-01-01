package com.axl.backend.controller;

import com.axl.backend.model.User;
import com.axl.backend.service.UserService;
import org.apache.coyote.Response;
import com.axl.backend.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //Crear usuario
    @PostMapping("/crearUsuario")
    public ResponseEntity<?> createUser(@RequestBody UserDTO user){
        try {
            User savedUser = userService.createUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/obtenerTodosUsuarios")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        try{
            User savedUser = userService.deleteUser(id);
            return  ResponseEntity.ok(savedUser);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/obtenerUsuarioId/{id}")
    public ResponseEntity<User> getUserId(@PathVariable Long id){
        try{
            User savedUser = userService.getUserId(id);
            return ResponseEntity.ok(savedUser);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
        }
    }

}
