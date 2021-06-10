package com.health.boot.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.health.boot.entities.Appointment;
import com.health.boot.entities.ApprovalStatus;
import com.health.boot.entities.DiagnosticCenter;
import com.health.boot.entities.DiagnosticTest;
import com.health.boot.entities.Patient;
import com.health.boot.entities.TestResult;
import com.health.boot.entities.User;

public class main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		User u = new User(111,"hasibul","hasibul123","Customer");
		
		Patient p = new Patient();
		p.setPatientId(12);
		p.setName("Hasibul");
		p.setAge(23);
		p.setGender("Male");
		p.setPhoneNo("8116282819");
		
		
		Appointment a = new Appointment();
		
		a.setId(1000);
		a.setApprovalStatus(ApprovalStatus.approved);
		a.setAppointmentDate(LocalDate.now());
//		a.setDiagnosticCenter(diagnosticCenter);
		
		p.addAppointment(a);
		em.persist(p);
		
		TestResult tr = new TestResult();
		tr.setId(1111);
		tr.setTestReading(12.4);
		tr.setCondition("Good");
		
		DiagnosticTest dt= new DiagnosticTest();
		dt.setId(101);
		dt.setTestName("glucose test");
		dt.setTestPrice(500);
		dt.setNormalValue("ok");
		dt.setUnits("mol");
		
		
		DiagnosticCenter dc = new DiagnosticCenter();
		dc.setId(101);
		dc.setAddress("Mumbai");
		dc.setContactEmail("hasibul.cpc@gmail.com");
		dc.setContactNo("8116282829");
		dc.setName("Mani");
		
		dc.getTests().add(dt);
		
		dt.getDiagnosticCenters().add(dc);
		
		em.persist(dc);
		
		
		em.getTransaction().commit();
		
		System.out.println("Code is running fine");
		em.close();
		emf.close();
	}

}
