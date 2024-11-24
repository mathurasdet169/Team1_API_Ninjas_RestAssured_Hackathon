package com.api.reqBody;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.api.payLoad.LoginPayload;
import com.api.utilities.CommonUtils;
import com.api.utilities.JsonReader;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginReqBody extends CommonUtils{
	
	//int responseCode =0;	

	private static String token;
	public int statuscode;
	public static Response response;
	LoginPayload lp=new LoginPayload();
	//JsonReader js=new JsonReader();
	
	
	public void validatestatuscode() throws IOException {
		int actstatuscode=response.getStatusCode();
		int Expectedcode=LoginJSONReader.EXP_STATUSCODE;
		System.out.println("Actual status code is:"+actstatuscode);
      System.out.println("Expected status code is:"+Expectedcode);
      Assert.assertEquals(actstatuscode, Expectedcode);
      if (actstatuscode==Expectedcode) {
    	  System.out.println("This Test Scenario is Passed");
	}
      else {
    	  System.out.println("###########Actual Status code is not same as Expected status code###########");
      }
	}
	// login
	public static void postRequestToGenerateToken() throws IOException {

	
		 response = request.body(loginjsonReaderObj.login_json_Reader(path.getString("loginJsonFilePath"), "post_positiveLogin")).post(endpoint.getString("login"));
		token = response.jsonPath().getString("token");
		System.out.println("token-->" + token);

	}

	public static String getBearerToken() throws IOException {
		// Generate the token if it does not exist
		if (token == null) {
			postRequestToGenerateToken();
		}
		return token;
		}
	
	public static void ResponseMessage() {
		String message=response.getBody().asPrettyString();
		System.out.println(message);
	}
	
//	public static int ResponseCode() {
//		int statuscode=response.statusCode();
//		System.out.println("Generated response status code is:"+statuscode);
//		return statuscode;
//	}
	
	public static void postRequestLogin_WithInvalid_EndPoint() throws IOException {
		 response = request.body(loginjsonReaderObj.Invalid_EndPoint(path.getString("loginJsonFilePath"), "post_invalidEndPoint")).post(endpoint.getString("Invalid_EndPoint"));

	}
	
	public static void post_invalid_username() throws IOException {
		 response = request.body(loginjsonReaderObj.Invalid_UserName_json_Reader(path.getString("loginJsonFilePath"), "post_invalidLoginUserName")).post(endpoint.getString("login"));
	}
	
	public static void post_invalid_Password() throws IOException {
		 response = request.body(loginjsonReaderObj.Invalid_Password_json_Reader(path.getString("loginJsonFilePath"), "post_invalidLoginPassword")).post(endpoint.getString("login"));
	}
	
	public static void get_Logout_Without_Bearer() throws IOException {
//		RestAssured.baseURI="https://lms-hackthon-oct24-3efc7e0df381.herokuapp.com/lms/";
//		response=request.when().get(endpoint.getString("login"));
		response = request.get(endpoint.getString("login"));

	}
	

}
