package com.api.utilities;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;
import java.util.ResourceBundle;

import com.api.payLoad.LoginPayload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CommonUtils {
	public static RequestSpecification request;
	public static RequestSpecification userRequest;
	public static ResourceBundle endpoint = ResourceBundle.getBundle("endpoint");	
	public static ResourceBundle path = ResourceBundle.getBundle("path");	
	//public static String FilePath=getFilePath("loginJsonFilePath");
	
	//public static String SnearioName=getScenarioName("post_positiveLogin");
		
	//ReqPayload(FilePath,"post_positiveLogin");
	
	//public static JsonReader jsonReaderObj = new JsonReader();
	
	public static void setBaseRequest_withoutBearer() {
		
            request = RestAssured.given()
                    .baseUri(baseURI)
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON);
        } 
		
//	private static String getScenarioName(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public static String getFilePath(String key) {
	   
			return path.getString(key);
		
				}
	
	public static void setBaseUrl()
	{
		baseURI = endpoint.getString("baseUrl");
	}
	
	
	public static void setBaseRequest_withBearer () throws IOException 
	{		
		String token = LoginPayload.getToken();			
		userRequest = RestAssured.given().log().all().baseUri(baseURI).header("Authorization", "Bearer " + token);
	}
	
	
//	public static String ReqPayload(String filepath,String ScenarioName) throws IOException
//{
//		JsonReader jsonReaderObj=new JsonReader();
//		
//		 ReqBody=jsonReaderObj.jsonReqBody(FilePath, "post_positiveLogin");
//		return ReqBody;
//
//}
//
//	
//	public static String ReqPayload(String filepath,String ScenarioName) throws IOException
//	{
//		JsonReader jsonReaderObj=new JsonReader();
//			 ReqBody=jsonReaderObj.jsonReqBody(FilePath, "post_positiveLogin");
//			return ReqBody;
//
//}
}
