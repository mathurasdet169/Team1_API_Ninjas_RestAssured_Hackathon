package com.api.payLoad;


public class ProgramPayload {

	private String scenario;
	private ProgramRequest requestBody;
	private ProgramValidateData validateData;

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public ProgramRequest getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(ProgramRequest requestBody) {
		this.requestBody = requestBody;
	}

	public ProgramValidateData getValidateData() {
		return validateData;
	}

	public void setValidateData(ProgramValidateData validateData) {
		this.validateData = validateData;
	}
}
