package com.exam1.repository;

import com.exam1.entity.Developer;
import com.exam1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT emp FROM Employee emp,Developer dev WHERE emp.id_employee = dev.id_employee")
    List<Employee> findEmployeesDev();

    @Query("SELECT emp FROM Employee emp,Tester t WHERE emp.id_employee = t.id_employee")
    List<Employee> findEmployeesTester();

    @Query("SELECT emp FROM Employee emp ORDER BY emp.salary_month ASC ")
    List<Employee> find2EmployeesLowest();
}
