package com.health.boot.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity

public class DiagnosticTest {

		@Id
		private int id;
		private String testName;
		private double testPrice;
		private String normalValue;
		private String units;
		@ManyToMany(fetch=FetchType.LAZY,mappedBy="diagnosticCenters")
		private Set<DiagnosticCenter> diagnosticCenters = new HashSet<>();
		
		public DiagnosticTest(int id, String testName, double testPrice, String normalValue, String units,
				Set<DiagnosticCenter> diagnosticCenters) {
			super();
			this.id = id;
			this.testName = testName;
			this.testPrice = testPrice;
			this.normalValue = normalValue;
			this.units = units;
			this.diagnosticCenters = diagnosticCenters;
		}

		public DiagnosticTest() {
			super();
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTestName() {
			return testName;
		}

		public void setTestName(String testName) {
			this.testName = testName;
		}

		public double getTestPrice() {
			return testPrice;
		}

		public void setTestPrice(double testPrice) {
			this.testPrice = testPrice;
		}

		public String getNormalValue() {
			return normalValue;
		}

		public void setNormalValue(String normalValue) {
			this.normalValue = normalValue;
		}

		public String getUnits() {
			return units;
		}

		public void setUnits(String units) {
			this.units = units;
		}

		public Set<DiagnosticCenter> getDiagnosticCenters() {
			return diagnosticCenters;
		}

		public void setDiagnosticCenters(Set<DiagnosticCenter> diagnosticCenters) {
			this.diagnosticCenters = diagnosticCenters;
		}

		@Override
		public String toString() {
			return "DiagnosticTest [id=" + id + ", testName=" + testName + ", testPrice=" + testPrice + ", normalValue="
					+ normalValue + ", units=" + units + "]";
		}
		
		
		
	}