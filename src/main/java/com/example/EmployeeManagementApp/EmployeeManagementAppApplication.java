package com.example.EmployeeManagementApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EmployeeManagementAppApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(EmployeeManagementAppApplication.class, args);
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin1234"));
		System.out.println(encoder.encode("user1234"));
	}

}
