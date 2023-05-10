package edu.assingment.employee_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.assingment.employee_management_system.dao.CompanyDao;
import edu.assingment.employee_management_system.entity.Company;
@Service
public class CompanyService {
     
	@Autowired
	private CompanyDao companyDao;
	
	public Company saveCompany(Company company) {
		return companyDao.saveCompany(company);
	}
	public Company findCompanyById(int companyId) {
		return companyDao.findCompanyById(companyId);
	}
	public Company updateCompanyById(int companyId, Company company) {
		return companyDao.updateCompanyById(companyId, company);
	}
	public Company deleteCompanyById(int companyId) {
		Company company = companyDao.findCompanyById(companyId);
		if (company!=null) {
			companyDao.deleteCompanyById(companyId);
			return company;
		}else {
			return null;
		}
	}
}
