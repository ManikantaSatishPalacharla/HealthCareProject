package com.health.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.health.boot.entities.Appointment;
import com.health.boot.entities.DiagnosticCenter;
import com.health.boot.entities.DiagnosticTest;
import com.health.boot.exceptions.DiagnosticCenterAllReadyExistsException;
import com.health.boot.exceptions.DiagnosticCenterNotFoundException;

public interface IDiagnosticCenterService {

	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter CreateDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws DiagnosticCenterAllReadyExistsException;
	public String updateDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	public Optional<DiagnosticCenter> getDiagnosticCenterById(int diagnosticCenterId);
	public DiagnosticCenter addTestInCenter(int testId,int centerId);
	DiagnosticCenter getDiagnosticCenter(String centername);
	String removeDiagnosticCenter(int id) throws DiagnosticCenterNotFoundException;
	DiagnosticTest viewTestDetails(int centerId, String testname);
	
 // List<Appointment> getListOfAppointments(String centerName);
	

}
