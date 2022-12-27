package com.exam1;

import com.exam1.entity.Developer;
import com.exam1.entity.Employee;
import com.exam1.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exam1Application {

    public static void main(String[] args) {
        SpringApplication.run(Exam1Application.class, args);
    }

}
