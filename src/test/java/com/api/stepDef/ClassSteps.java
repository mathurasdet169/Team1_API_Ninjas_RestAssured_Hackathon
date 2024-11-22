package com.api.stepDef;

import java.io.IOException;

import org.testng.Assert;

import com.api.utilities.*;

import com.api.reqBody.ClassReqBody;
import com.api.reqBody.LoginReqBody;
import com.api.utilities.JsonReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class ClassSteps extends CommonUtils{
	
	ClassReqBody classreqbodyobj=new ClassReqBody();
	LoginReqBody loginReqBodyObj = new LoginReqBody();
	ClassReqBody classReqBodyobj=new ClassReqBody();
	JsonReader jsonreaderobj=new JsonReader();
	Response response;
	
	@Given("The admin is logged in successfully into the LMS application")
	public void the_admin_is_logged_in_successfully_into_the_lms_application() throws IOException {
		loginReqBodyObj.postRequestToGenerateToken();

	}

	 
	@Given("Admin creates GET Request for {string}")
	public void admin_creates_get_request_for(String Scenario) throws IOException {
		jsonreaderobj.login_json_Reader(path.getString("loginJsonFilePath"), Scenario);
	  	}

	@When("Admin sends HTTPS {string} with {string}")
	public void admin_sends_https_with(String string, String string2) throws IOException {
		if(JsonReader.EXP_STATUSCODE == 405)
		{
			response=classreqbodyobj.getGetAllClassRecordingWithInvalidMethod();
		} else if(JsonReader.EXP_STATUSCODE==401)
		{
			response=classreqbodyobj.getGetAllClassRecordingNoAuth();
		}else {
		response=classreqbodyobj.getGetAllClassRecording();
		}
	System.out.println(response.getStatusCode());   
	
	
	}

	@Then("Admin receives {int} and {string} with response body.")
	public void admin_receives_and_with_response_body(Integer int1, String string) {
		Assert.assertEquals(JsonReader.EXP_STATUSCODE,response.getStatusCode());
		
	    	}
	
	

}
