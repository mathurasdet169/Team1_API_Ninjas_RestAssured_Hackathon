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
	//ClassReqBody classReqBodyobj=new ClassReqBody();
	JsonReader jsonreaderobj=new JsonReader();
	Response response;

	@Given("The admin is logged in successfully into the LMS application")
	public void the_admin_is_logged_in_successfully_into_the_lms_application() throws IOException {
	
		loginReqBodyObj.postRequestToGenerateToken();

	}


/*------------------GET REQUESTS----------------------*/
	
	@When("Admin sends HTTPS Request for {string} with endpoint")
	public void admin_sends_https_request_for_with_endpoint(String Scenario) {
	    
	try {
		response=ClassReqBody.getRequest(Scenario);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	@Then("Admin receives {int} and Message with response body.")
	public void admin_receives_and_message_with_response_body(Integer exp_Code) {
	    
		Assert.assertEquals(response.getStatusCode(), exp_Code);
	}

/*--------------PUT CLASS DETAILS-----------------*/


	@When("Admin sends HTTPS Request with {string} update class")
	public void admin_sends_https_request_with_for_update_class(String Scenario) throws IOException {
			
		response=ClassReqBody.getRequest(Scenario);
	}

	@Then("Admin receives exp_statuscode and Message with response body for update class.")
	public void admin_receives_exp_statuscode_and_message_with_response_body_for_update_class() {
		
		//Assert.assertEquals(response.getStatusCode(), exp_Code);
	}


/*--------------------DELETE ClassDetails by classID---------------------------*/

	@Given("Admin creates DELETE Request for {string}")
	public void admin_creates_delete_request_for(String Scenario) throws IOException {
		
		jsonreaderobj.jsonReader(path.getString("loginJsonFilePath"), Scenario);
	}

	@When("Admin sends HTTPS {string} with {string} for delete request")
	public void admin_sends_https_with_for_delete_request(String string, String string2) throws IOException {
		if(JsonReader.EXP_STATUSCODE == 405)
		{
			response=classreqbodyobj.deleteClassRecordingByClassID_With_InvalidMethod();
		} else if(JsonReader.EXP_STATUSCODE==401)
		{
			response=classreqbodyobj.deleteClassRecordingByClassID_With_NoAuth();
		}else {
			response=classreqbodyobj.deleteClassRecordingByClassID();
		}
	}

	@Then("Admin receives {int} and {string} with response body for delete request")
	public void admin_receives_and_with_response_body_for_delete_request(Integer int1, String string) {
		Assert.assertEquals(response.getStatusCode(),JsonReader.EXP_STATUSCODE);

	}



}
