package io.dave.service;

import java.util.List;

import io.dave.entity.Company;

public interface ICompanyService {

	Long createCompany(Company cob);
	Company updateCompany(Company cob);
	Company getOneCompany(Long id);
	List<Company> getAllCompanies();
}
