package com.api.utilities;
import com.api.payLoad.BatchPayload;


import com.api.payLoad.*;

import com.api.payLoad.LoginPayload;
import com.api.reqBody.ClassReqBody;
import com.api.payLoad.ProgramPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {

	public static int EXP_STATUSCODE;
	public static String endpoint;

	

	public  String jsonReader(String filepath,String scenarioNode) throws IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		// Read the JSON file
		JsonNode rootNode = objectMapper.readTree(new File(filepath));
		// Access the "scenarioNode" data
		JsonNode Scenario_Node = rootNode.path(scenarioNode);
		//JsonNode ReqBodyNode=Scenario_Node.path("ReqBody");

		String loginData = objectMapper.writeValueAsString(Scenario_Node);
//		JsonNode ValidationData=Scenario_Node.path("ValidationData");
//		EXP_STATUSCODE=ValidationData.get("exp_code").asInt();
//		System.out.println(EXP_STATUSCODE);
//
//		endpoint=ValidationData.get("endpoint").asText();
//		System.out.println(endpoint);
		return loginData;
	}

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
	

	public  String classUpdateRecording_json_Reader(String filepath,String scenarioNode) throws IOException
	{
	ObjectMapper objectMapper = new ObjectMapper();
   
        // Read the JSON file
        JsonNode rootNode = objectMapper.readTree(new File(filepath));

        // Access the "scenarioNode" data
        JsonNode Scenario_Node = rootNode.path(scenarioNode);
        ClassUpdatePayload classreq = objectMapper.treeToValue(Scenario_Node, ClassUpdatePayload.class);
//        JsonNode addressnode=Scenario_Node.path("userAddress");
//        AddressDetails address=objectMapper.treeToValue(addressnode, AddressDetails.class);
//          
        
        ClassUpdatePayload classobj=new ClassUpdatePayload();
	//	AddressDetails addressDetailsObj=new AddressDetails();
		
        
        classobj.setClassRecordingPath(classreq.getClassRecordingPath());
       classobj.setCsId(classreq.getCsId());
    
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 String JsonRequestBody = gson.toJson(classobj);
			//System.out.println(JsonRequestBody);
			return JsonRequestBody;
			
	}

    	public  String batch_json_Reader(String filepath,String scenarioNode) throws IOException
    	{
    	ObjectMapper objectMapper = new ObjectMapper();
            // Read the JSON file
            JsonNode rootNode = objectMapper.readTree(new File(filepath));
            // Access the "scenarioNode" data
            JsonNode Scenario_Node = rootNode.path(scenarioNode);
//            ObjectNode modifiedNode = (ObjectNode) Scenario_Node;
//            // Fetch the original batch name from the JSON, if it exists
//            String originalBatchName = modifiedNode.path("batchName").asText();
//            String modifiedBatchName = originalBatchName + "-" + RandomStringUtils.randomNumeric(5);
//            // Set the new modified batch name in the JSON node
//            modifiedNode.put("batchName", modifiedBatchName);
            
            String batchDataJsonString = objectMapper.writeValueAsString(Scenario_Node);
				return batchDataJsonString;
      } 
        
	public LoginPayload login_json_Reader(String filepath,String scenarioNode) throws IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		// Read the JSON file
		JsonNode rootNode = objectMapper.readTree(new File(filepath));
		// Access the "scenarioNode" data
		JsonNode Scenario_Node = rootNode.path(scenarioNode);
		LoginPayload loginData = objectMapper.treeToValue(Scenario_Node, LoginPayload.class);
		LoginPayload loginPayLoadObj = new LoginPayload();

		loginPayLoadObj.setUserLoginEmailId(loginData.getUserLoginEmailId());
		loginPayLoadObj.setPassword(loginData.getPassword());

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String JsonRequestBody = gson.toJson(loginPayLoadObj);
		System.out.println(JsonRequestBody);
		return loginPayLoadObj;

	}


	public List<ProgramPayload> getProgramScenarios(String filepath){
		List<ProgramPayload> scenarios = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			File jsonFile = new File(filepath);
			String jsonString=objectMapper.writeValueAsString(objectMapper.readTree(jsonFile));
			scenarios = objectMapper.readValue(jsonString, new TypeReference<List<ProgramPayload>>(){});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return scenarios;
	}
}



