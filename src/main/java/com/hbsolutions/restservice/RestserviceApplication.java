package com.hbsolutions.restservice;

import com.hbsolutions.restservice.employee.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@ComponentScan({"com.hbsolutions.restservice.employee.controller",
		"com.hbsolutions.restservice.employee.service",
		"com.hbsolutions.restservice.employee.model",
		"com.hbsolutions.restservice.employee.repository"})*/
public class RestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}

}
