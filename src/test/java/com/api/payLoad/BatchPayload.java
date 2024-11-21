package com.api.payLoad;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class BatchPayload {
	@JsonPropertyOrder({ "batchDescription", "batchName", "batchNoOfClasses", "batchStatus", "programId", "programName" })
	
	String batchDescription;
	String batchName;
	int batchNoOfClasses;
	String batchStatus;
	int programId;
	String programName;
	//String ScenarioType;
	
	
	public String getBatchDescription() {
		return batchDescription;
	}
	public void setBatchDescription(String batchDescription) {
		this.batchDescription = batchDescription;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public int getBatchNoOfClasses() {
		return batchNoOfClasses;
	}
	public void setBatchNoOfClasses(int batchNoOfClasses) {
		this.batchNoOfClasses = batchNoOfClasses;
	}
	public String getBatchStatus() {
		return batchStatus;
	}
	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	

}
