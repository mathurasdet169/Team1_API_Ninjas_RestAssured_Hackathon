package com.api.utilities;
import com.api.payLoad.ClassPayload;
import com.api.reqBody.ClassReqBody;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
public class JsonReader {
	public static int EXP_STATUSCODE;
	public static String endpoint;
	
    	public String login_json_Reader(String filepath,String scenarioNode) throws IOException
    	{
    	ObjectMapper objectMapper = new ObjectMapper();
            // Read the JSON file
            JsonNode rootNode = objectMapper.readTree(new File(filepath));
            // Access the "scenarioNode" data
            JsonNode Scenario_Node = rootNode.path(scenarioNode);
            JsonNode ReqBodyNode=Scenario_Node.path("ReqBody");
          
           String loginData = objectMapper.writeValueAsString(ReqBodyNode);
           JsonNode ValidationData=Scenario_Node.path("ValidationData");
           EXP_STATUSCODE=ValidationData.get("exp_code").asInt();
           System.out.println(EXP_STATUSCODE);
           
           endpoint=ValidationData.get("endpoint").asText();
           System.out.println(endpoint);
   		return loginData;
           }
    	
    	
    	public  String batch_json_Reader(String filepath,String scenarioNode) throws IOException
    	{
    	ObjectMapper objectMapper = new ObjectMapper();
            // Read the JSON file
            JsonNode rootNode = objectMapper.readTree(new File(filepath));
            // Access the "scenarioNode" data
            JsonNode Scenario_Node = rootNode.path(scenarioNode);
            String batchDataJsonString = objectMapper.writeValueAsString(Scenario_Node);
//            BatchPayload batchData = objectMapper.treeToValue(Scenario_Node, BatchPayload.class);
//            BatchPayload batchPayLoadObj = new BatchPayload();
            
//            batchPayLoadObj.setBatchDescription(batchData.getBatchDescription());
//            batchPayLoadObj.setBatchName(batchData.getBatchName());
//            batchPayLoadObj.setBatchNoOfClasses(batchData.getBatchNoOfClasses());
//            batchPayLoadObj.setBatchStatus(batchData.getBatchStatus());
//            batchPayLoadObj.setProgramId(batchData.getProgramId());
//            batchPayLoadObj.setProgramName(batchData.getProgramName());
            
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//			 String JsonRequestBody = gson.toJson(batchData);
//				System.out.println(JsonRequestBody);
				return batchDataJsonString;
            
	
            
    	}
    	




//import com.fasterxml.jackson.databind.JsonNode;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.api.payLoad.ClassPayload;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//public class JsonReader {
//	
//	//JsonReader jsonReaderObj = new JsonReader();
//	public List<ClassPayload> getClassScenarios(String filepath){
//		List<ClassPayload> scenarios = null;
//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			File jsonFile = new File(filepath);
//			String jsonString=objectMapper.writeValueAsString(objectMapper.readTree(jsonFile));
//			scenarios = objectMapper.readValue(jsonString, new TypeReference<List<ClassPayload>>(){});
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return scenarios;
//	}
//	public String getString(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
	

//
//	public String classJsonReader(String filepath, String scenarioNode) throws IOException {
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    // Read the JSON file
//    JsonNode rootNode = objectMapper.readTree(new File(filepath));
//       // Access the "scenarioNode" data
//       JsonNode Scenario_Node = rootNode.path(scenarioNode);
//        String classJsondatastring = objectMapper.writeValueAsString(Scenario_Node);
//      return classJsondatastring ;
//
//	}
//	
//	
	
	
	public  String classJsonReader(String filepath,String scenarioNode) throws IOException
	{
	ObjectMapper objectMapper = new ObjectMapper();
        // Read the JSON file
        JsonNode rootNode = objectMapper.readTree(new File(filepath));
        // Access the "scenarioNode" data
        JsonNode Scenario_Node = rootNode.path(scenarioNode);
        ClassPayload classreq = objectMapper.treeToValue(Scenario_Node, ClassPayload.class);
//        JsonNode addressnode=Scenario_Node.path("userAddress");
//        AddressDetails address=objectMapper.treeToValue(addressnode, AddressDetails.class);
//
        ClassPayload classobj=new ClassPayload();
	//	AddressDetails addressDetailsObj=new AddressDetails();
		
        classobj.setBatchId(ClassReqBody.batchId);
        classobj.setClassComments(classreq.getClassComments());
        classobj.setClassDate(classreq.getClassDate());
        classobj.setClassDescription(classreq.getClassDescription());
        classobj.setClassNo(classreq.getClassNo());
        classobj.setClassNotes(classreq.getClassNotes());
        classobj.setClassRecordingPath(classreq.getClassRecordingPath());
        classobj.setClassStaffId(classreq.getClassStaffId());
        classobj.setClassStatus(classreq.getClassStatus());
        classobj.setClassTopic(classreq.getClassTopic());
        classobj.setClassScheduledDates(classreq.getClassScheduledDates());
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 String JsonRequestBody = gson.toJson(classobj);
			//System.out.println(JsonRequestBody);
			return JsonRequestBody;
			
	}
	
	
	
	
}