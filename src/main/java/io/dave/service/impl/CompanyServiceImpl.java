package io.dave.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.dave.entity.Company;
import io.dave.exception.CompanyNotFoundException;
import io.dave.repo.CompanyRepository;
import io.dave.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private CompanyRepository repo;

	@Override
	public Long createCompany(Company company) {
		return repo.save(company).getId();
	}

	@Override
	public Company updateCompany(Company company) {
		return repo.findById(company.getId()).map(existingCompany -> repo.save(existingCompany))
				.orElseThrow(() -> new CompanyNotFoundException("Company not found with ID: " + company.getId()));
	}

	@Override
	public Company getOneCompany(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new CompanyNotFoundException("Company with ID " + id + " not found"));
	}

	@Override
	public List<Company> getAllCompanies() {
		return repo.findAll();

	}

}
