package com.hbsolutions.restservice.employee.repository;

import com.hbsolutions.restservice.employee.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//TODO: DBChange to @Repository
@Service
public class EmployeeRepository {

    List<Employee> employeeList;

    //TODO: DBChange make DBconnection
    @PostConstruct
    public void initializeEmployees(){
        employeeList = new ArrayList<Employee>();
        Employee employee1 = new Employee(1010L, "Ethan","Klein","ek@gmail.com");
        Employee employee2 = new Employee(1011L, "Mallory","Klein","mk@gmail.com");
        Employee employee3 = new Employee(1012L, "Kevin","P","kp@gmail.com");
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        //TODO: DBChange Initialize connection information
    }

    //TODO: DBChange use database to save employee information
    public Employee save(Employee employee){
        Long lastID = employeeList.get(employeeList.size()-1).getId()+1;
        employee.setId(lastID);
        employeeList.add(employee);
        return employee;
    }


    public Employee update(Employee employee){
        Employee emp = findById(employee.getId());
        if(emp!=null){
            deleteById(employee.getId());
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setEmailId(employee.getEmailId());
            employeeList.add(employee);
            return employee;
        }
        return new Employee(0L,"","","");
    }




    public Employee findById(Long empID){
        for(Employee employee : employeeList){
            if(employee.getId().equals(empID)){
                return employee;
            }
        }
        return new Employee(0L,"","","");
    }

    public Employee[] findAll(){
        /*Employee[] employees = new Employee[employeeList.size()];
        employeeList.toArray(employees);
        return employees;*/
        return employeeList.toArray(new Employee[0]);
    }

    public void deleteById(Long empId){
        for(int i =0; i < employeeList.size();i++) {
            if (employeeList.get(i).getId().equals(empId)) {
                employeeList.remove(i);
                System.out.println("Item " + empId + " removed");
                return;
            }
        }
        System.out.println("Employee " + empId + " not found");
    }
}
