package com.axl.backend.service;

import com.axl.backend.model.User;
import com.axl.backend.model.Role;
import com.axl.backend.dto.UserDTO;
import com.axl.backend.repository.RoleRepository;
import com.axl.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createUser(UserDTO dto){

        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        User user = new User(
                dto.getUsername(),
                dto.getEmail(),
                dto.getPassword(),
                role
        );

        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
        return user;
    }

    public User getUserId(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }

}
