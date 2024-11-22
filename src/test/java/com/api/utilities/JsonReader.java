package com.api.utilities;
import com.api.payLoad.BatchPayload;
import com.api.payLoad.*;

import com.api.payLoad.LoginPayload;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
public class JsonReader {
	public static int EXP_STATUSCODE;
	public static String endpoint;
	
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
    	
    	
    		
}



