package io.dave.entity;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="company")
@DynamicUpdate
public class Company {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="com_name")
	private String companyName;
	
	@Column(name="com_regid")
	private String companyRegId;
	
	@Column(name="com_type")
	private String companyType;
	
	@Column(name="com_parent")
	private String companyParentOrg;
	
	@Column(name="mode_of_operation")
	private String modeOfOperation;
	
	@Column(name="service_code")
	private String serviceCode;
	
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	@JoinColumn(name="aidFk")
	private List<Address> addr;
		
}

