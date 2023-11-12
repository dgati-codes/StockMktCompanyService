package io.dave.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dave.entity.Company;
import io.dave.service.ICompanyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyRestController {

	@Autowired
	private ICompanyService service;

	@PostMapping("/create")
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		Long companyId = service.createCompany(company);
		log.info("Company created with ID: {}", companyId);
		return ResponseEntity.ok("Company created with ID: " + companyId);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Company>> getAllCompanies() {
		log.info("Fetching all companies");

		List<Company> companies = service.getAllCompanies();

		log.info("Fetched {} companies successfully", companies.size());
		return ResponseEntity.ok(companies);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<Company> getOneCompany(@PathVariable Long id) {
		log.info("Fetching company with ID: {}", id);

		Company company = service.getOneCompany(id);

		log.info("Fetched company with ID: {} successfully", id);
		return ResponseEntity.ok(company);
	}
}
