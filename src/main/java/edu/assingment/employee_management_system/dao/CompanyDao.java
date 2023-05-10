package edu.assingment.employee_management_system.dao;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.assingment.employee_management_system.entity.Company;
import edu.assingment.employee_management_system.repository.CompanyRepo;

@Repository
public class CompanyDao {
	
      @Autowired
      private CompanyRepo companyRepo;
      
      public Company saveCompany(Company company) {
    	return companyRepo.save(company);
      }
      public Company findCompanyById(int companyId) {
    	  Optional<Company> optional = companyRepo.findById(companyId);
    	  if (optional.isEmpty()) {
			return null;
		}else {
			Company company = optional.get();
			return company;
		}
      }
      public Company updateCompanyById(int companyId, Company company) {
    	  Optional<Company> optional = companyRepo.findById(companyId);
    	  if (optional.isEmpty()) {
			return null;
		}else {
			company.setCompanyId(companyId);
			return companyRepo.save(company);
		}
      }
      public Company deleteCompanyById(int companyId) {
    	Optional<Company> optional = companyRepo.findById(companyId);
    	if (optional.isEmpty()) {
			return null;
		}else {
			companyRepo.deleteById(companyId);
			return optional.get();
		}
    	 
      }
}
