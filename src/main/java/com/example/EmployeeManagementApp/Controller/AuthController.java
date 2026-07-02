package com.example.EmployeeManagementApp.Controller;

import com.example.EmployeeManagementApp.Dto.RegisterRequest;
import com.example.EmployeeManagementApp.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request)
    {
        return service.register(request);
    }
}
