package com.api.utilities;
import com.api.payLoad.BatchPayload;
import com.api.payLoad.*;

import com.api.payLoad.LoginPayload;
import com.api.payLoad.ProgramPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.api.payLoad.LoginPayload;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
public class JsonReader {
	
	public static int EXP_STATUSCODE;
    	public  BatchPayload batch_json_Reader(String filepath,String scenarioNode) throws IOException
    	{
    	ObjectMapper objectMapper = new ObjectMapper();
            // Read the JSON file
            JsonNode rootNode = objectMapper.readTree(new File(filepath));
            // Access the "scenarioNode" data
            JsonNode Scenario_Node = rootNode.path(scenarioNode);
            BatchPayload batchData = objectMapper.treeToValue(Scenario_Node, BatchPayload.class);
            BatchPayload batchPayLoadObj = new BatchPayload();
            
        //    batchPayLoadObj.
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
			 String JsonRequestBody = gson.toJson(batchPayLoadObj);
				System.out.println(JsonRequestBody);
				return batchPayLoadObj;           
    	}
 
    	public String login_json_Reader(String filepath,String scenarioNode) throws IOException
    	{
    	ObjectMapper objectMapper = new ObjectMapper();
            // Read the JSON file
    	JsonNode rootNode = objectMapper.readTree(new File(filepath));
            // Access the "scenarioNode" data
            JsonNode Scenario_Node = rootNode.path("post_positiveLogin");
            JsonNode ReqBodyNode=Scenario_Node.path("Request_Body");
            String loginData = objectMapper.writeValueAsString(ReqBodyNode);
            JsonNode ValidationData=Scenario_Node.path("ValidationData");
             EXP_STATUSCODE = ValidationData.get("statusCode").asInt();
            System.out.println("statuscode reading from jsonreader class: "+EXP_STATUSCODE);
            
//            LoginPayload loginData = objectMapper.treeToValue(Scenario_Node, LoginPayload.class);
//            LoginPayload loginPayLoadObj = new LoginPayload();
//            
//            loginPayLoadObj.setUserLoginEmailId(loginData.getUserLoginEmailId());
//            loginPayLoadObj.setPassword(loginData.getPassword());
//            loginPayLoadObj.setstatusCode(loginData.getstatusCode());
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//			 String JsonRequestBody = gson.toJson(loginPayLoadObj);
//				System.out.println(JsonRequestBody);
				return loginData;	
            
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




