package edu.assingment.employee_management_system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.assingment.employee_management_system.entity.Company;
import edu.assingment.employee_management_system.entity.Employee;

public interface CompanyRepo extends JpaRepository<Company, Integer>{
      
	 @Query(value = "select c.employees from Company c where c.companyId=?1")
	 public Optional<List<Employee>> getEmployees(int companyId );
	 
}
