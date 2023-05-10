package edu.assingment.employee_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.assingment.employee_management_system.entity.Company;
import edu.assingment.employee_management_system.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
   
	@Autowired
	private CompanyService companyService;
	
	@PostMapping
	public Company saveCompany(@RequestBody Company company) {
		return companyService.saveCompany(company);
	}
	@GetMapping
	public Company findCompanyById(@RequestParam int companyId) {
		return companyService.findCompanyById(companyId);
	}
	@PutMapping
	public Company updateCompanyById(@RequestParam int companyId,@RequestBody Company company) {
		return companyService.updateCompanyById(companyId, company);
	}
	@DeleteMapping
	public Company deleteCompanyById(@RequestParam int companyId) {
		return companyService.deleteCompanyById(companyId);
	}
}
