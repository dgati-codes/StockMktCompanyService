package io.dave.rest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dave.entity.Company;
import io.dave.exception.CompanyNotFoundException;
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
	  
		return Optional.ofNullable(service.createCompany(company))
	            .map(id -> {
	                log.info("COMPANY IS CREATED {}.", id);
	                log.info("ABOUT TO LEAVE SAVE METHOD");
	                return ResponseEntity.ok("CREATED WITH ID : " + id);
	            })
	            .orElseGet(() -> {
	                log.error("Failed to create company");
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating company");
	            });
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<List<Company>> getAllCompanies() {
	        log.info("ENTERED INTO FETCH METHOD");

	        List<Company> list = Optional.ofNullable(service)
	                .map(ICompanyService::getAllCompanies)
	                .orElseGet(() -> {
	                    log.error("Service is null");
	                    return Collections.emptyList();
	                });

	        log.info("FETCH METHOD IS SUCCESS");
	        log.info("ABOUT TO LEAVE FETCH ALL METHOD");
	        return ResponseEntity.ok(list);
	    }
	 
	 @GetMapping("/fetch/{id}")
	 public ResponseEntity<Company> getOneCompany(@PathVariable Long id) {
	     log.info("ENTERED INTO FETCH ONE METHOD");

	     return Optional.ofNullable(service.getOneCompany(id))
	             .map(cob -> ResponseEntity.ok(cob))
	             .orElseThrow(() -> {
	                 log.error("Company with ID {} not found", id);
	                 return new CompanyNotFoundException("Company with ID " + id + " not found");
	             });
	 }
	
}
