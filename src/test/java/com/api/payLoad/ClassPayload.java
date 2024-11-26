
package com.api.payLoad;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.ResourceBundle;
public class ClassPayload {
	public static ResourceBundle endpoint = ResourceBundle.getBundle("endpoint");	
	
	//@JsonPropertyOrder({ "batchDescription", "batchName", "batchNoOfClasses", "batchStatus", "programId", "programName" })
	
	@JsonPropertyOrder({
	    "batchId",
	    "classComments",
	    "classDate",
	    "classDescription",
	    "classNo",
	    "classNotes",
	    "classRecordingPath",
	    "classStaffId",
	    "classTopic",
	    "classScheduledDates"
	})

  //
//private String[] classScheduledDates;
	 private List<String> classScheduledDates;

    // Other fields
    private static String batchId;
    private String classComments;
    private String classDate;
    private String classDescription;
    private int classNo;
    private String classStatus;
    private String classNotes;
    private String classRecordingPath;
    private String classStaffId;
    private String classTopic;

    // Getters and Setters for classScheduledDates
//    public String[] getClassScheduledDates() {
//        return classScheduledDates;
//    }
//
//    public void setClassScheduledDates(String[] classScheduledDates) {
//        this.classScheduledDates = classScheduledDates;
//    }
    public List<String> getClassScheduledDates() {
        return classScheduledDates;
    }

    public void setClassScheduledDates(List<String> classScheduledDates) {
        this.classScheduledDates = classScheduledDates;
    }


    // Other getters and setters
    public String getBatchId() {
        return batchId;
    }

//    public   void setBatchId(String batchId)  {
//    	this.batchId = batchId;
//    }

    
    
    public static void setBatchId(String batchId) {
       ClassPayload.batchId = batchId;
    }

    public String getClassComments() {
        return classComments;
    }

    public void setClassComments(String classComments) {
        this.classComments = classComments;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }

    public String getClassNotes() {
        return classNotes;
    }

    public void setClassNotes(String classNotes) {
        this.classNotes = classNotes;
    }

    public String getClassRecordingPath() {
        return classRecordingPath;
    }

    public void setClassRecordingPath(String classRecordingPath) {
        this.classRecordingPath = classRecordingPath;
    }

    public String getClassStaffId() {
        return classStaffId;
    }

    public void setClassStaffId(String classStaffId) {
        this.classStaffId = classStaffId;
    }

    public String getClassTopic() {
        return classTopic;
    }

    public void setClassTopic(String classTopic) {
        this.classTopic = classTopic;
    }
    
    public static String getClassRecordEndpoint(String batchId) {
        String getClassRecordEndpoint = endpoint.getString("classRecordingsByBatchId");
      
        return getClassRecordEndpoint.replace("{batchId}", String.valueOf(batchId));
    } 
    
    
    public static String getClassbybatchid(String batchId) {
    	  String getClassEndpoint = endpoint.getString("getallClassesbyBatchId");
      
        return getClassEndpoint .replace("{batchId}", String.valueOf(batchId));
    } 
  
    public static String getallClassesbyClasstopic(String classTopic) {
        String getallClassesbyClasstopic = endpoint.getString("getallClassesbyClasstopic");
      
        return getallClassesbyClasstopic.replace("{clasTopic}", String.valueOf(classTopic));
    } 
    
    
}
