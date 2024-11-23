package com.api.utilities;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    	
    	
    		
}