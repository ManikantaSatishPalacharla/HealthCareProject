package com.health.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.boot.entities.DiagnosticCenter;
import com.health.boot.entities.DiagnosticTest;
import com.health.boot.repository.DiagnosticCenterRepository;
import com.health.boot.service.IDiagnosticCenterService;
import com.health.boot.service.IDiagnosticCenterServiceImpls;


@RestController
@RequestMapping("/dc")
public class DiagnosticCenterController {
	@Autowired
	IDiagnosticCenterService dcs;
	
	@GetMapping()
	public List<DiagnosticCenter> getDiagnosticCenters(){
		
		return dcs.getAllDiagnosticCenters();}
	
	@GetMapping("{id}")
	public Optional<DiagnosticCenter> searchCenter(@PathVariable("id") int id) {
		return dcs.getDiagnosticCenterById(id);}
	
	@GetMapping("/cn/{centername}")
	public DiagnosticCenter searchCenterByName(@PathVariable("centername") String name) {
		return dcs.getDiagnosticCenter(name);}
	
	@PutMapping("{tid}/{cid}")
	public String addtestincenter(@PathVariable("cid") int cid,@PathVariable("tid") int tid) {
		System.out.println("received1");
		DiagnosticCenter dm=dcs.addTestInCenter(tid, cid);
		if(dm==null) {
			return "not added";
		}
		return"added";
		
	}
	@PostMapping()
	public DiagnosticCenter createDiagnosticCenter(@RequestBody DiagnosticCenter dc) {
		dcs.CreateDiagnosticCenter(dc);
		return dc;}
	
	@DeleteMapping("{id}")
	public String DeleteDiagnosticCenter(@PathVariable("id") int id) {
		return dcs.removeDiagnosticCenter(id);
		 
	}
	
	@PutMapping()
	public String updateTheCenterdetails(@RequestBody DiagnosticCenter dc) {
		return dcs.updateDiagnosticCenter(dc);
	}
	
	@GetMapping("{cid}/{testname}")
	public DiagnosticTest viewDetails(@PathVariable("cid") int centerId,@PathVariable("testname") String testname) {
		return dcs.viewTestDetails(centerId, testname);
	}
	

}
