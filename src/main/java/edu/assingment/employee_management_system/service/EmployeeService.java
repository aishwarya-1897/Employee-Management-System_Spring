package edu.assingment.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.assingment.employee_management_system.dao.CompanyDao;
import edu.assingment.employee_management_system.dao.EmployeeDao;
import edu.assingment.employee_management_system.entity.Company;
import edu.assingment.employee_management_system.entity.Employee;

@Service
public class EmployeeService {
     
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired 
	private CompanyDao companyDao;
	
	public Employee saveEmployee(Employee employee, int companyId) {
		 
		 Company company = companyDao.findCompanyById(companyId);
		 List<Employee> employees = company.getEmployees();
		 employees.add(employee);
		 company.setEmployees(employees);
		 Employee employee2 = employeeDao.saveEmployee(employee);
	     companyDao.saveCompany(company);
		 return employee2;
		 
	}
	public Employee findEmployeeById(int employeeId) {
		return employeeDao.findEmployeeById(employeeId);
	}
	public Employee updateEmployeeById(int employeeId, Employee employee) {
		return employeeDao.updateEmployeeById(employeeId, employee);
	}
    public Employee deleteEmployee(int employeeId, int companyId) {
    	Employee employee = employeeDao.findEmployeeById(employeeId);
    	if (employee!=null) {
    		Company company =companyDao.findCompanyById(companyId);
    		if (company!=null) {
				List<Employee> employees = company.getEmployees();
				employees.remove(employee);
				company.setEmployees(employees);
				companyDao.updateCompanyById(companyId, company);
				employeeDao.deleteEmployee(employee);
				return employee;
			}else {
				return null;
			}
			
		}else {
			return null;
		}
    }
    public List<Employee> getEmployees(int companyId) {
    	return employeeDao.getEmployees(companyId);
    }
}
