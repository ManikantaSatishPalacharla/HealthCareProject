package com.health.boot.service;

import java.awt.dnd.DragSourceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.health.boot.entities.Appointment;
import com.health.boot.entities.DiagnosticCenter;
import com.health.boot.entities.DiagnosticTest;
import com.health.boot.exceptions.DiagnosticCenterAllReadyExistsException;
import com.health.boot.exceptions.DiagnosticCenterNotFoundException;
import com.health.boot.exceptions.DiagnosticTestNotFoundException;
//import com.health.boot.repository.AppointmentRepository;
import com.health.boot.repository.DiagnosticCenterRepository;
import com.health.boot.repository.DiagnosticTestRepository;

@Service
public class IDiagnosticCenterServiceImpls implements IDiagnosticCenterService {
	@Autowired
	DiagnosticCenterRepository dcr;
	@Autowired
	DiagnosticTestRepository dtr;
	@Autowired
//	AppointmentRepository apr;
	
	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters(){
		return dcr.findAll();
	}
	@Override
	public DiagnosticCenter CreateDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws DiagnosticCenterAllReadyExistsException{
		int id=diagnosticCenter.getId();
		Optional<DiagnosticCenter> dc=dcr.findById(id);
		if(dc.isEmpty()) {
			dcr.save(diagnosticCenter);
			return diagnosticCenter;
		}
		else {
			throw new DiagnosticCenterAllReadyExistsException("Diagnostic center with id "+id+" All ready existed");
		}
	}
	@Override
	public Optional<DiagnosticCenter> getDiagnosticCenterById(int diagnosticCenterId) {
		Optional<DiagnosticCenter> dc=dcr.findById(diagnosticCenterId);
		if(dc.isEmpty()) {
			throw new DiagnosticCenterNotFoundException("There is no Diagnostic Center with id: "+diagnosticCenterId);
		}
		return dc;
		
	}
	@Override
	public DiagnosticCenter getDiagnosticCenter(String centername) {
		ArrayList<DiagnosticCenter> list=(ArrayList<DiagnosticCenter>) dcr.findAll();
		for(DiagnosticCenter dc:list) {
			if(dc.getName().equals(centername)) 
			return dc;
		}
		throw new DiagnosticCenterNotFoundException("Dignostic center is not available with name"+centername);
	}
	@Override
	public String removeDiagnosticCenter(int id) throws DiagnosticCenterNotFoundException{
		if(dcr.findById(id).isPresent()) {
			DiagnosticCenter dc=dcr.findById(id).get();
			dcr.delete(dc);
			return "Deleted";
			}
		else
			throw new DiagnosticCenterNotFoundException("Dignostic center is not available with "+id);
	}
	
	
	public DiagnosticCenter addTestInCenter(int testId,int centerId) {
		DiagnosticCenter dc= dcr.getById(centerId);
		DiagnosticTest dt =dtr.getById(testId);
		dc.addtest(dt);
		dcr.save(dc);
		return dc;
	}
	
	@Override
	public String updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		int id=diagnosticCenter.getId();
		Optional<DiagnosticCenter> dc=dcr.findById(id);
		if(dc.isEmpty()) {
			throw new DiagnosticCenterNotFoundException("Dignostic center is not available with provided details and not possible");}
		dcr.save(diagnosticCenter);
		return "Updated";
	}
		
	public DiagnosticTest viewTestDetails(int centerId, String testname) {
		Optional<DiagnosticCenter> dc=dcr.findById(centerId);
		if(dc.isEmpty()) {
			throw new DiagnosticCenterNotFoundException("Center not found with Id: "+centerId);
		}
		DiagnosticCenter dc1=dcr.findById(centerId).get();
		Set<DiagnosticTest> set=dc1.getTests();
		for(DiagnosticTest t:set) {
			if(t.getTestName().equals(testname)) {
				return t;}
		}
		throw new DiagnosticTestNotFoundException("Test not found with name as "+testname+" in the center.");
	}
	
//	@Override
//	public List<Appointment> getListOfAppointments(String centerName){
//		List<Appointment> list=new ArrayList<>();
//		List<Appointment> list2=apr.findAll();
//		for(Appointment a:list2) {
//			String name=a.getDiagnosticCenter().getName();
//			if(name==centerName) {
//				list.add(a);
//			}
//		}
//		
//		return list;
//	}
	
}

