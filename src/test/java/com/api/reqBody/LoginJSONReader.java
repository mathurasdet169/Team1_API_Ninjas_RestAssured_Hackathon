package com.api.reqBody;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginJSONReader {
	public static int EXP_STATUSCODE;
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
			return loginData;	  
	}
	public String login_json_Reader1(String filepath,String scenarioNode) throws IOException
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
			return loginData;	
	}
	public String Invalid_UserName_json_Reader(String filepath,String scenarioNode) throws IOException
	{
	ObjectMapper objectMapper = new ObjectMapper();
        // Read the JSON file
        JsonNode rootNode = objectMapper.readTree(new File(filepath));
        // Access the "scenarioNode" data
        JsonNode Scenario_Node = rootNode.path("post_invalidLoginUserName");
        JsonNode ReqBodyNode=Scenario_Node.path("Request_Body");
        String loginData = objectMapper.writeValueAsString(ReqBodyNode);
        JsonNode ValidationData=Scenario_Node.path("ValidationData");
       EXP_STATUSCODE = ValidationData.get("statusCode").asInt();
        System.out.println("statuscode reading from jsonreader class: "+EXP_STATUSCODE);
			return loginData;	
	}
	public String Invalid_Password_json_Reader(String filepath,String scenarioNode) throws IOException
	{
	ObjectMapper objectMapper = new ObjectMapper();
        // Read the JSON file
        JsonNode rootNode = objectMapper.readTree(new File(filepath));
        // Access the "scenarioNode" data
        JsonNode Scenario_Node = rootNode.path("post_invalidLoginPassword");
        JsonNode ReqBodyNode=Scenario_Node.path("Request_Body");
        String loginData = objectMapper.writeValueAsString(ReqBodyNode);
        JsonNode ValidationData=Scenario_Node.path("ValidationData");
        EXP_STATUSCODE = ValidationData.get("statusCode").asInt();
        System.out.println("statuscode reading from jsonreader class: "+EXP_STATUSCODE);
			return loginData;	
        
	}
	public String Invalid_EndPoint(String filepath,String scenarioNode) throws IOException
	{
	ObjectMapper objectMapper = new ObjectMapper();
        // Read the JSON file
        JsonNode rootNode = objectMapper.readTree(new File(filepath));
        // Access the "scenarioNode" data
        JsonNode Scenario_Node = rootNode.path("post_invalidEndPoint");
        JsonNode ReqBodyNode=Scenario_Node.path("Request_Body");
        String loginData = objectMapper.writeValueAsString(ReqBodyNode);
        JsonNode ValidationData=Scenario_Node.path("ValidationData");
        EXP_STATUSCODE = ValidationData.get("statusCode").asInt();
        System.out.println("statuscode reading from jsonreader class: "+EXP_STATUSCODE);
			return loginData;	 
	}
	public String ReadLogoutJsonFile(String filepath,String scenarioNode) throws IOException
	{
	ObjectMapper objectMapper = new ObjectMapper();
        // Read the JSON file
        JsonNode rootNode = objectMapper.readTree(new File(filepath));
        // Access the "scenarioNode" data
        JsonNode Scenario_Node = rootNode.path("Scenario");
        JsonNode ReqBodyNode=Scenario_Node.path("Request_Body");
        String loginData = objectMapper.writeValueAsString(ReqBodyNode);
        JsonNode ValidationData=Scenario_Node.path("ValidationData");
        EXP_STATUSCODE = ValidationData.get("statusCode").asInt();
        System.out.println("statuscode reading from jsonreader class: "+EXP_STATUSCODE);
			return loginData;	 
	}
}
