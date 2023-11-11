package io.dave.service.impl;

import java.util.List;
import java.util.Optional;

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

	public Company updateCompany(Company company) {
		
		return repo.findById(company.getId())
		.map(companyExisting -> {
			return repo.save(companyExisting);
		}).orElseThrow(() -> new CompanyNotFoundException("Company with ID " + company.getId()+ " not found"));
	}

	@Override
	public Company getOneCompany(Long id) {
		return repo.findById(id)
	            .orElseThrow(() -> new CompanyNotFoundException("Company with ID " + id + " not found"));
	}

	@Override
	public List<Company> getAllCompanies() {
		return Optional.ofNullable(repo.findAll()).filter(companies -> !companies.isEmpty())
				.orElseThrow(() -> new CompanyNotFoundException("No companies found."));
	}
	
}
