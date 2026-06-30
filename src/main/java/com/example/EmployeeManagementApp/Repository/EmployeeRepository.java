package com.example.EmployeeManagementApp.Repository;

import com.example.EmployeeManagementApp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByDesignation(String designation);
    Optional<Employee> findByEmail(String email);
}
