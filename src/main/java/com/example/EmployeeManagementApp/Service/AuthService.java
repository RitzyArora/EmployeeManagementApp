package com.example.EmployeeManagementApp.Service;

import com.example.EmployeeManagementApp.Dto.RegisterRequest;
import com.example.EmployeeManagementApp.Entity.AppUser;
import com.example.EmployeeManagementApp.Entity.Role;
import com.example.EmployeeManagementApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    public String register(RegisterRequest request)
    {
        if(repository.findByUsername(request.getUsername()).isPresent())
        {
            throw new RuntimeException("Username already exists");
        }
        AppUser user=new AppUser();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);
        repository.save(user);
        return "User Registered Successfully!!";
    }
}
