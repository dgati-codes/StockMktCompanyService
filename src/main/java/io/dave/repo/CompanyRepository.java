package io.dave.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.dave.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
