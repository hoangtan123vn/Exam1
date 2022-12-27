package com.exam1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employee;
    private String firstname;
    private String lastname;
    private double salary_month;
    @Transient
    private double yearly_salary;

    public Employee(String firstname,String lastname,double salary_month){
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary_month = salary_month;
    }
}
