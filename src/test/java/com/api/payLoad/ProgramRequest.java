package com.api.payLoad;

public class ProgramRequest {
	private String programName;
	private String programStatus;
	private String programDescription;

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramStatus() {
		return programStatus;
	}

	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}

	public String getProgramDescription() {
		return programDescription;
	}

	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
}
