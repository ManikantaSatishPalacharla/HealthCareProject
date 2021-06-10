package com.health.boot.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



public class DiagnosticCenter {
	private int id;
	private String name;
	private String contactNo;
	private String address;
	private String contactEmail;
	private List<String> servicesOffered;
	
	@ManyToMany()
	@JoinTable(name="DT_DC",
	  joinColumns = @JoinColumn(name = "dc_id"), 
	  inverseJoinColumns = @JoinColumn(name = "dt_id"))
	private Set<DiagnosticTest> tests = new HashSet<>();
	
	public DiagnosticCenter() {
		super();
		
	}

	public DiagnosticCenter(int id, String name, String contactNo, String address, String contactEmail,
			List<String> servicesOffered, Set<DiagnosticTest> tests) {
		super();
		this.id = id;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.contactEmail = contactEmail;
		this.servicesOffered = servicesOffered;
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

	public List<String> getServicesOffered() {
		return servicesOffered;
	}

	public void setServicesOffered(List<String> servicesOffered) {
		this.servicesOffered = servicesOffered;
	}

	public Set<DiagnosticTest> getTests() {
		return tests;
	}

	public void setTests(Set<DiagnosticTest> tests) {
		this.tests = tests;
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", address=" + address
				+ ", contactEmail=" + contactEmail + ", servicesOffered=" + servicesOffered + ", tests=" + tests + "]";
	}
	
	

	
}
