package com.example.EmployeeManagementApp.Entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String email;
    private Double salary;
    private String designation;

    public Employee(String name, String email, Double salary, String designation) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.designation = designation;
    }

    public Employee() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Double getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
