package com.api.utilities;
import com.api.payLoad.BatchPayload;
import com.api.payLoad.LoginPayload;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
public class JsonReader {
	
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
    	
}



