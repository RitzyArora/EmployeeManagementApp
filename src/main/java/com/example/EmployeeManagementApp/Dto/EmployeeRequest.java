package com.example.EmployeeManagementApp.Dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class EmployeeRequest {
    @NotBlank(message="Name cannot be empty")
    private String name;
    @NotBlank(message="Email Cannot be empty")
    @Email(message="Enter valid email")
    private String email;
    @Positive(message="Salary must be greater than zero")
    private Double salary;
    @NotBlank(message="Designation cannot be empty")
    private String designation;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, String email, Double salary, String designation) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
