package com.example.EmployeeManagementApp.Dto;

import com.example.EmployeeManagementApp.Entity.Address;

public class EmployeeResponse {

    Long id;
       private String name;
        private String email;
        private Double salary;
        private String designation;
        private Address address;

        public EmployeeResponse() {
        }

        public EmployeeResponse(Long id,String name, String email, Double salary, String designation,Address address) {
            this.id=id;
            this.name = name;
            this.email = email;
            this.salary = salary;
            this.designation = designation;
            this.address=address;
        }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public Long getId() {
        return id;
    }
}


