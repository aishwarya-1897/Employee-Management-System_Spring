package edu.assingment.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.assingment.employee_management_system.entity.Employee;
import edu.assingment.employee_management_system.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee, @RequestParam int companyId) {
		return employeeService.saveEmployee(employee, companyId);
	}
	@GetMapping
	public Employee findEmployeeById(@RequestParam int employeeId) {
	    return employeeService.findEmployeeById(employeeId);
	}
	@PutMapping
	public Employee updateEmployeeById(@RequestParam int employeeId,@RequestBody Employee employee) {
		return employeeService.updateEmployeeById(employeeId, employee);
	}
	@DeleteMapping
	public Employee deleteEmployee(@RequestParam int employeeId, @RequestParam int companyId ) {
		return employeeService.deleteEmployee(employeeId, companyId);
	}
	@GetMapping("/company")
	public List<Employee> getEmployees(@RequestParam int companyId) {
		return employeeService.getEmployees(companyId);
	}
	
}


