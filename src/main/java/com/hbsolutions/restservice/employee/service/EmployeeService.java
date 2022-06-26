package com.hbsolutions.restservice.employee.service;

import com.hbsolutions.restservice.employee.model.Employee;
import com.hbsolutions.restservice.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    // CREATE
    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    // READ
    public Employee[] getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // DELETE
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = employeeRepository.findById(empId);
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());

        return employeeRepository.update(emp);
    }
}
