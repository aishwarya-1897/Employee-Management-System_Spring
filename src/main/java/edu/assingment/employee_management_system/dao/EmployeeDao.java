package edu.assingment.employee_management_system.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.assingment.employee_management_system.entity.Employee;
import edu.assingment.employee_management_system.repository.CompanyRepo;
import edu.assingment.employee_management_system.repository.EmployeeRepo;

@Repository
public class EmployeeDao {
  
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private CompanyRepo companyRepo;
	 
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	 public Employee findEmployeeById(int employeeId) {
	 Optional<Employee> optional = employeeRepo.findById(employeeId);
	  if (optional.isEmpty()) {
		return null;
	}else {
		Employee employee = optional.get();
		return employee;
	}
 }
	 public Employee updateEmployeeById(int employeeId, Employee employee) {
   	  Optional<Employee> optional = employeeRepo.findById(employeeId);
   	  if (optional.isEmpty()) {
			return null;
		}else {
			employee.setEmployeeId(employeeId);
			return employeeRepo.save(employee);
		}
     }
	 public Employee deleteEmployee(Employee employee) {
		 employeeRepo.delete(employee);
		 return employee;
	 }
	 public List<Employee> getEmployees(int companyId) {
		Optional<List<Employee>> optional = companyRepo.getEmployees(companyId);
		if (optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	 }
}