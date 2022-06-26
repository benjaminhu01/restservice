package com.hbsolutions.restservice.employee.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    @Getter @Setter
    Long id;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String emailId;
}
