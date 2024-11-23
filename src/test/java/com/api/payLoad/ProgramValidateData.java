package com.api.payLoad;

public class ProgramValidateData {
	private String endpoint;
	private int expectedStatusCode;
	private String expectedResMsg;

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public int getExpectedStatusCode() {
		return expectedStatusCode;
	}

	public void setExpectedStatusCode(int expectedStatusCode) {
		this.expectedStatusCode = expectedStatusCode;
	}
	
	public String getExpectedResMsg() {
		return expectedResMsg;
	}

	public void setExpectedResMsg(String expectedResMsg) {
		this.expectedResMsg = expectedResMsg;
	}
}
