package com.example.EmployeeManagementApp.Repository;

import com.example.EmployeeManagementApp.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
