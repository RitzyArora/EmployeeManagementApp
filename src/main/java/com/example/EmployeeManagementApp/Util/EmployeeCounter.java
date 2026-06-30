package com.example.EmployeeManagementApp.Util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class EmployeeCounter {
    public EmployeeCounter() {
        System.out.println("EmployeeCounter Object created");
    }
}
