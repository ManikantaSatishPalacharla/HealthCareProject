package com.health.boot.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class DiagnosticCenter {
	@Id
	@Column(name="id")
	private int id;
	private String name;
	private String contactNo;
	private String address;
	private String contactEmail;
//	private List<String> servicesOffered;
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="dt_dc",
	  joinColumns = {@JoinColumn(name = "dc_id")}, 
	  inverseJoinColumns = {@JoinColumn(name = "dt_id")})

	private Set<DiagnosticTest> tests = new HashSet<>();
	
	public DiagnosticCenter() {
		super();
		
	}

	public DiagnosticCenter(int id, String name, String contactNo, String address, String contactEmail, Set<DiagnosticTest> tests) {
		super();
		this.id = id;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.contactEmail = contactEmail;
		//this.servicesOffered = servicesOffered;
		this.tests = tests;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

//	public List<String> getServicesOffered() {
//		return servicesOffered;
//	}

	//public void setServicesOffered(List<String> servicesOffered) {
	//	this.servicesOffered = servicesOffered;
	//}

	public Set<DiagnosticTest> getTests() {
		return tests;
	}

	public void setTests(Set<DiagnosticTest> tests) {
		this.tests = tests;
	}

	
	
	

	
}
