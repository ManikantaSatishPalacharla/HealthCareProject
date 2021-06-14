package com.health.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.boot.entities.DiagnosticTest;
import com.health.boot.service.IDiagnosticTestService;
import com.health.boot.service.IDiagnosticTestServiceImpls;

@RestController
@RequestMapping("dt")
public class DiagnosticTestController {
	@Autowired
	IDiagnosticTestService dts;

	@GetMapping()
	public List<DiagnosticTest> getAllTest(){
		return dts.getAllTest();
	}
	
	@GetMapping("{id}")
	public DiagnosticTest searchTestById(@PathVariable("id")int id) {
		return dts.testById(id);
	}
	
	@PostMapping()
	public DiagnosticTest createTest(@RequestBody DiagnosticTest t) {
		return dts.CreateNewTest(t);
	}
	
	@PutMapping()
	public DiagnosticTest updateTestDetails(@RequestBody DiagnosticTest test) {
		return dts.updateTestDetail(test);
	}
	
	@GetMapping("centers/{id}")
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(@PathVariable("id")int centerId){
		return dts.getTestsOfDiagnosticCenter(centerId);
	}
	
	@PutMapping("{cid}/{tid}")
	public DiagnosticTest delTestFromCenter(@PathVariable("cid") int cid,@PathVariable("tid") int tid) {
		return dts.removeTestFromDiagnosticCenter(cid, tid);
		
	}
}
