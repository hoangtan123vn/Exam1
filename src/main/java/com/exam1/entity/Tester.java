package com.exam1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tester")
@AllArgsConstructor
@NoArgsConstructor
public class Tester extends Employee{
    private Boolean automated;

    public Tester(Boolean automated,String firstname,String lastname,double salary_month){
        super(firstname, lastname, salary_month);
        this.automated = automated;
    }
}
