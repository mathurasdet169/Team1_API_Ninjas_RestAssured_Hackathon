package com.api.payLoad;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.ResourceBundle;
public class ClassUpdatePayload {
	@JsonPropertyOrder({
	   
	    "classRecordingPath",
	    "csId"
	})
	
	
	
  
    private String classRecordingPath;
	private String csId;

   
    public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}

	public String getClassRecordingPath() {
		return classRecordingPath;
	}

	public void setClassRecordingPath(String classRecordingPath) {
		this.classRecordingPath = classRecordingPath;
	}

	
}
