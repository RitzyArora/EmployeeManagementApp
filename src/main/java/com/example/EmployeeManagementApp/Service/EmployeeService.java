package com.example.EmployeeManagementApp.Service;

import com.example.EmployeeManagementApp.Dto.AddressRequest;
import com.example.EmployeeManagementApp.Dto.EmployeeRequest;
import com.example.EmployeeManagementApp.Dto.EmployeeResponse;
import com.example.EmployeeManagementApp.Entity.Address;
import com.example.EmployeeManagementApp.Entity.Employee;
import com.example.EmployeeManagementApp.Exception.EmployeeAlreadyExistsException;
import com.example.EmployeeManagementApp.Exception.EmployeeNotFoundException;
import com.example.EmployeeManagementApp.Repository.EmployeeRepository;
import com.example.EmployeeManagementApp.Util.RequestContext;
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
    private RequestContext requestContext;
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees()
    {
        //System.out.println("Current Request Id :"+requestContext.getRequestId());
        return employeeRepository.findAll();
    }

//    public Employee save(Employee employee){
//
//        return employeeRepository.save(employee);
//
//    }

    public EmployeeResponse save(EmployeeRequest request)
    {
        if(employeeRepository.findByEmail(request.getEmail()).isPresent())
        {
            throw new EmployeeAlreadyExistsException("Employee already exists with email : "+request.getEmail());
        }
        logger.info("Creating an Employee : {}",request.getName());
        Employee employee=new Employee();
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());
        employee.setDesignation(request.getDesignation());
        employee.setEmail(request.getEmail());
        AddressRequest addressRequest=request.getAddress();
        if(addressRequest!=null)
        {
            Address address=new Address();
            address.setCity(addressRequest.getCity());
            address.setState(addressRequest.getState());
            address.setCountry(addressRequest.getCountry());
            address.setPincode(addressRequest.getPincode());
            employee.setAddress(address);
            address.setEmployee(employee);
        }
        logger.info("Address={}",request.getAddress());
        Employee savedEmployee=employeeRepository.save(employee);
        logger.info("Employee Created Successfully");
        return new EmployeeResponse(
                savedEmployee.getEmployeeId(),
                savedEmployee.getName(),
                savedEmployee.getEmail(),
                savedEmployee.getSalary(),
                savedEmployee.getDesignation(),
                savedEmployee.getAddress()
        );

    }

    public Employee getEmployeeById(Long id)
    {
        return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with Id "+id+" not found"));
    }

    public Employee updateEmployee(Long id,Employee updatedEmployee)
    {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with Id "+id+" not found"));
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

    public List<Employee> getEmployeeByDesignation(String designation)
    {
        return employeeRepository.findByDesignation(designation);
    }
}
