package com.example.EmployeeManagementApp.Service;

import com.example.EmployeeManagementApp.Dto.EmployeeRequest;
import com.example.EmployeeManagementApp.Dto.EmployeeResponse;
import com.example.EmployeeManagementApp.Entity.Employee;
import com.example.EmployeeManagementApp.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private static final Logger logger= LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

//    public Employee save(Employee employee){
//
//        return employeeRepository.save(employee);
//
//    }

    public EmployeeResponse save(EmployeeRequest request)
    {
        logger.info("Creating an Employee : {}",request.getName());
        Employee employee=new Employee();
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());
        employee.setDesignation(request.getDesignation());
        employee.setEmail(request.getEmail());
        Employee savedEmployee=employeeRepository.save(employee);
        logger.info("Employee Created Successfully");
        return new EmployeeResponse(
                savedEmployee.getEmployeeId(),
                savedEmployee.getName(),
                savedEmployee.getEmail(),
                savedEmployee.getSalary(),
                savedEmployee.getDesignation()
        );

    }

    public Employee getEmployeeById(Long id)
    {
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found"));
    }

    public Employee updateEmployee(Long id,Employee updatedEmployee)
    {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found"));
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setSalary(updatedEmployee.getSalary());
        employee.setDesignation(updatedEmployee.getDesignation());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id)
    {
        employeeRepository.deleteById(id);
    }
}
