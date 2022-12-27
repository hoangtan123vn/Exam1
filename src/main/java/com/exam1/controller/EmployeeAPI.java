package com.exam1.controller;

import com.exam1.entity.Developer;
import com.exam1.entity.Employee;
import com.exam1.entity.Tester;
import com.exam1.repository.DevRepository;
import com.exam1.repository.EmpRepository;
import com.exam1.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeAPI {

    @Autowired
    private DevRepository devRepository;

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private TestRepository testRepository;


    //2 CREATE 5 DEVELOPER OBJECTS AND SAVE THEM INTO THE DATABASE
    @PostMapping("/addDev")
    public String addDev(){
        Employee employee1 = new Developer("java","Hoang","Tien",220.0);
        Employee employee2 = new Developer("c++","Tien","Bip",240.0);
        Employee employee3 = new Developer("c#","Hehe","Haha",200.0);
        Employee employee4 = new Developer("python","Nguyen Van","A",200.0);
        Employee employee5 = new Developer("javascript","Nguyen Van","B",200.0);
        empRepository.save(employee1);
        empRepository.save(employee2);
        empRepository.save(employee3);
        empRepository.save(employee4);
        empRepository.save(employee5);
        return "add Dev success";
    }
    //3 CREATE 5 TESTER OBJECTS AND SAVE THEM INTO THE DATABASE
    @PostMapping("/addTester")
    public String addTester(){
        Employee employee1 = new Tester(true,"Nguyen","Thuan",300.0);
        Employee employee2 = new Tester(false,"Hong","Thai",250.0);
        Employee employee3 = new Tester(true,"Hong","Thang",200.0);
        Employee employee4 = new Tester(false,"Nguyen Tan","Toi",100.0);
        Employee employee5 = new Tester(true,"Le Hoang","Tien",150.0);
        empRepository.save(employee1);
        empRepository.save(employee2);
        empRepository.save(employee3);
        empRepository.save(employee4);
        empRepository.save(employee5);
        return "add Tester success";
    }

    //4 FETCH ALL EMPLOYEEES (5 DEVELOPERS AND 5 TESTERS) FROM THE DATABASE AND DISPLAY EACH OBJECT'S YEARLY SALARY
    @GetMapping("/getList5Emp")
    public List<Employee> getList5Emp(){
        List<Employee> ListDev = empRepository.findEmployeesDev();
        List<Employee> ListTester = empRepository.findEmployeesTester();
        List<Employee> employeeList = new ArrayList<Employee>();
        for(int i = 0 ; i < 5 ; i ++ ) {

            double salaryDev = ListDev.get(i).getSalary_month() * 12;
            ListDev.get(i).setYearly_salary(salaryDev);

            double salaryTester = ListTester.get(i).getSalary_month()* 12;
            ListTester.get(i).setYearly_salary(salaryTester);

            employeeList.add(ListDev.get(i));
            employeeList.add(ListTester.get(i));
        }
        return employeeList;
    }


    //5 GIVE EACH EMPLOYEE A 10% RAISE ANDS SAVE THEM INTO THE DATABASE AGAIN
    @PostMapping("/raise10Emp")
    public List<Employee> raise10Emp(){
        List<Employee> employeeList = empRepository.findAll();
        for(Employee employee : employeeList){
            double salaryraise10 = employee.getSalary_month()*0.1 + employee.getSalary_month();
            double yearly_salary = employee.getSalary_month()*12;
            employee.setYearly_salary(yearly_salary);
            employee.setSalary_month(salaryraise10);
            empRepository.save(employee);
        }
        return employeeList;
    }

    //6 DELETE 2 EMPLOYEES THAT HAVE THE LOWEST MONTHLY SALARY FROM THE DATABASE
    @PostMapping("/deleteEmp")
    public String deleteEmp(){
        List<Employee> employeeList = empRepository.find2EmployeesLowest();
        for(int i = 0 ; i < 2 ; i ++ ){
            empRepository.delete(employeeList.get(i));
        }
        return "delete success";
    }

    //7 FETCH ALL EMPLOYEES FROM THE DATABASE AND DISPLAY EACH OBJECT'S YEARLY SALARY
    @GetMapping("/getlistEmp")
    public List<Employee> getlistEmployee(){
        List<Employee> employeeList = empRepository.findAll();
        for(Employee employee : employeeList){
            double yearly_salary = employee.getSalary_month()*12;
            employee.setYearly_salary(yearly_salary);
        }
        return employeeList;
    }





}
