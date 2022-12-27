package com.exam1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="developer")
@AllArgsConstructor
@NoArgsConstructor
public class Developer extends Employee{
    private String programming_language;

    public Developer(String programming_language,String firstname,String lastname,double salary_month){
        super(firstname, lastname, salary_month);
        this.programming_language = programming_language;
    }
}
