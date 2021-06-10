package com.health.boot.entities;

import java.time.LocalDate;
import java.util.Set;

public class Appointment {
	
	private int id;
	private LocalDate appointmentDate;
	private ApprovalStatus approvalStatus;
	private Set<DiagnosticTest> diagnosticTests;
	private Patient patient;
	private DiagnosticCenter diagnosticCenter;
	private Set<TestResult> testResult;

}
