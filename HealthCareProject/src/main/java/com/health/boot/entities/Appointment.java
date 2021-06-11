package com.health.boot.entities;



import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Appointment {
	
	@Id
	private int id;
	private LocalDate appointmentDate;
	private ApprovalStatus approvalStatus;
	
	@OneToMany()
	private Set<DiagnosticTest> diagnosticTests;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Patient patient;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="diago_center")
	private DiagnosticCenter diagnosticCenter;
	
	@OneToMany(mappedBy="appointment")
	private Set<TestResult> testResult;
	
	
	

	public Appointment() {
		super();
	}

	public Appointment(int id, LocalDate appointmentDate, ApprovalStatus approvalStatus,
			Set<DiagnosticTest> diagnosticTests, Patient patient, DiagnosticCenter diagnosticCenter,
			Set<TestResult> testResult) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.approvalStatus = approvalStatus;
		this.diagnosticTests = diagnosticTests;
		this.patient = patient;
		this.diagnosticCenter = diagnosticCenter;
		this.testResult = testResult;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Set<DiagnosticTest> getDiagnosticTests() {
		return diagnosticTests;
	}

	public void setDiagnosticTests(Set<DiagnosticTest> diagnosticTests) {
		this.diagnosticTests = diagnosticTests;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}

	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}

	public Set<TestResult> getTestResult() {

		return testResult;
	}

	public void setTestResult(Set<TestResult> testResult) {
		this.testResult = testResult;
	}
	
	public void addTestResult(TestResult t) {
		t.setAppointment(this);			//this will avoid nested cascade
		System.out.println(t);
		this.getTestResult().add(t);
	}
	
	public void addDiagnosticTest(DiagnosticTest dTest) {			//this will avoid nested cascade
		this.getDiagnosticTests().add(dTest);
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentDate=" + appointmentDate + ", approvalStatus=" + approvalStatus
				+ ", diagnosticTests=" + diagnosticTests + ", patient=" + patient + ", diagnosticCenter="
				+ diagnosticCenter + ", testResult=" + testResult + "]";
	}

}