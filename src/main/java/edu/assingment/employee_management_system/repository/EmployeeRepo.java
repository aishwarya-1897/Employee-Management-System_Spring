package edu.assingment.employee_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.assingment.employee_management_system.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
