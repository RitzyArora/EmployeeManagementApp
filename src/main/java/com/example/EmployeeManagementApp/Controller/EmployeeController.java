package com.example.EmployeeManagementApp.Controller;

import com.example.EmployeeManagementApp.Dto.EmployeeRequest;
import com.example.EmployeeManagementApp.Dto.EmployeeResponse;
import com.example.EmployeeManagementApp.Entity.Employee;
import com.example.EmployeeManagementApp.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
@GetMapping
    public List<Employee> getEmployees()
{
    return employeeService.getAllEmployees();
}

//    @PostMapping
//    public Employee saveEmployees(@RequestBody Employee employee)
//    {
//        return employeeService.save(employee);
//    }

    @PostMapping
    public EmployeeResponse saveEmployees(@Valid @RequestBody EmployeeRequest employee)
    {
        return employeeService.save(employee);
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee)
    {
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
        return "Employee Deleted Successfully!!";
    }
}
