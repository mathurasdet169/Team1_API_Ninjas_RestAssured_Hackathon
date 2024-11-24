package com.api.utilities;
import com.api.payLoad.BatchPayload;
import com.api.payLoad.LoginPayload;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
public class JsonReader {
	
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
    	
}



