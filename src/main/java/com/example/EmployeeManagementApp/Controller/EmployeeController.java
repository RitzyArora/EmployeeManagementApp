package com.example.EmployeeManagementApp.Controller;

import com.example.EmployeeManagementApp.Dto.ApiResponse;
import com.example.EmployeeManagementApp.Dto.EmployeeRequest;
import com.example.EmployeeManagementApp.Dto.EmployeeResponse;
import com.example.EmployeeManagementApp.Entity.Employee;
import com.example.EmployeeManagementApp.Service.EmployeeService;
import com.example.EmployeeManagementApp.Util.EmployeeCounter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeCounter counterOne;
    @Autowired
    private EmployeeCounter counterTwo;
    @Autowired
    private EmployeeService employeeService;
//@GetMapping
//    public List<Employee> getEmployees()
//{
//    return employeeService.getAllEmployees();
//}
@GetMapping
public ResponseEntity<ApiResponse<List<Employee>>> getEmployees()
{

    List<Employee> employees =
            employeeService.getAllEmployees();

    return ResponseEntity.ok(
            new ApiResponse<>(
                    true,
                    "Employees fetched successfully",
                    employees));
}
//    @PostMapping
//    public Employee saveEmployees(@RequestBody Employee employee)
//    {
//        return employeeService.save(employee);
//    }

//    @PostMapping
//    public ApiResponse<EmployeeResponse> saveEmployees(@Valid @RequestBody EmployeeRequest employee)
//    {
//        EmployeeResponse response= employeeService.save(employee);
//        return new ApiResponse<>(
//                true,
//                "Employee created successfully",
//                response
//        );
//    }

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> saveEmployees(@Valid @RequestBody EmployeeRequest employee)
    {
        EmployeeResponse response= employeeService.save(employee);
        ApiResponse<EmployeeResponse> res =new ApiResponse<>(
                true,
                "Employee created successfully",
                response
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
//    @GetMapping("/{id}")
//    public ApiResponse<Employee> getEmployeeById(@PathVariable Long id)
//
//    {
//        Employee employee= employeeService.getEmployeeById(id);
//        return new ApiResponse<>(
//                true,
//        "Employee Found",
//        employee
//                );
//    }
@GetMapping("/{id}")
public ResponseEntity<ApiResponse<Employee>> getEmployee(
        @PathVariable Long id)
{

    Employee employee = employeeService.getEmployeeById(id);

    return ResponseEntity.ok(
            new ApiResponse<>(
                    true,
                    "Employee Found",
                    employee));
}
//    @PutMapping("/{id}")
//    public ApiResponse<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee)
//    {
//        employeeService.updateEmployee(id,employee);
//        return new ApiResponse<>(
//                true,
//         "Employee updated Successfully",
//                employee
//         );
//    }
//@PutMapping("/{id}")
//public ResponseEntity<ApiResponse<Employee>> updateEmployee(
//        @PathVariable Long id,
//        @RequestBody Employee employee)
//{
//
//    Employee updated =
//            employeeService.updateEmployee(id, employee);
//
//    return ResponseEntity.ok(
//            new ApiResponse<>(
//                    true,
//                    "Employee Updated Successfully",
//                    updated));
//}
@PutMapping("/{id}")
public ResponseEntity<ApiResponse<Employee>> updateEmployee(
        @PathVariable Long id,
        @RequestBody Employee employee)
{

    Employee updated =
            employeeService.updateEmployee(id, employee);

    return ResponseEntity.ok(
            new ApiResponse<>(
                    true,
                    "Employee Updated Successfully",
                    updated));
}
//    @DeleteMapping("/{id}")
//    public ApiResponse<String> deleteEmployee(@PathVariable Long id)
//    {
//        employeeService.deleteEmployee(id);
//        return new ApiResponse<>(
//                true,
//                "Employee Deleted Successfully",
//                null
//        );
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteEmployee(
            @PathVariable Long id)
    {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Employee Deleted Successfully",
                        null));
    }

    @GetMapping("/designation")
    public ApiResponse<List<Employee>> getByDesignation(@RequestParam String designation)
    {
        List<Employee> employees=employeeService.getEmployeeByDesignation(designation);
        return new ApiResponse<>(
                true,
                "Successfully fetched",
                employees
        );
    }

    @GetMapping("/scope")
    public String testScope()
    {
        return counterOne.hashCode()+" "+counterTwo.hashCode();
    }
}
