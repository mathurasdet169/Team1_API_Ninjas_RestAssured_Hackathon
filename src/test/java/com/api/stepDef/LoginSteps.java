package com.api.stepDef;

import java.io.IOException;

import org.testng.Assert;

import com.api.reqBody.LoginReqBody;

import com.api.utilities.CommonUtils;

import com.api.utilities.JsonReader;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	CommonUtils cm=new CommonUtils();
	LoginReqBody loginReqBodyObj = new LoginReqBody();
	@Given("Admin creates request with valid credentials")
	
	@Given("Admin create HTTP POST Request for LOGIN")
	public void admin_create_http_post_request_for_login() {
		cm.setBaseRequest_withoutBearer();
	}
	
	
	public void admin_creates_request_with_valid_credentials() {
	   cm.setBaseRequest_withoutBearer();
	}

	@When("Admin calls Post Https method with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() throws IOException {
	    
		loginReqBodyObj.postRequestToGenerateToken();
	}

	@Then("Admin receives {int} created with auto generated token")

	public void admin_receives_created_with_auto_generated_token(Integer int1) throws IOException {
		loginReqBodyObj.validatestatuscode();
		//loginReqBodyObj.ResponseCode();
		loginReqBodyObj.ResponseMessage();
	}
	@When("Admin calls Post Https method with Invalid endpoint")
	public void admin_calls_post_https_method_with_invalid_endpoint() throws IOException {
		loginReqBodyObj.postRequestLogin_WithInvalid_EndPoint();
	}

	@Then("Admin receives Admin receives {int} unauthorized")
	public void admin_receives_admin_receives_unauthorized(Integer int1) throws IOException {
		loginReqBodyObj.validatestatuscode();
		//loginReqBodyObj.ResponseCode();
		loginReqBodyObj.ResponseMessage();
	}
	
	@When("Admin calls Post Https method with valid endpoint for Invalid Username")
	public void admin_calls_post_https_method_with_valid_endpoint_for_Invalid_Username() throws IOException {
		loginReqBodyObj.post_invalid_username();
	}
	
	@When("Admin calls Post Https method with valid endpoint for Invalid Password")
	public void admin_calls_post_https_method_with_valid_endpoint_for_Invalid_Password() throws IOException {
		loginReqBodyObj.post_invalid_Password();
	public void admin_receives_created_with_auto_generated_token(Integer int1) {
	
		Assert.assertEquals(JsonReader.EXP_STATUSCODE, 200);
	}

	@Then("Admin receives {int} Bad Request with message for Invalid username")
	public void admin_receives_bad_request_with_message_for_invalid_username(Integer int1) throws IOException {
		loginReqBodyObj.validatestatuscode();
		//loginReqBodyObj.ResponseCode();
		loginReqBodyObj.ResponseMessage();
	}

	@Then("Admin receives {int} Bad Request with message for Invalid Password")
	public void admin_receives_bad_request_with_message_for_invalid_password(Integer int1) throws IOException {
		loginReqBodyObj.validatestatuscode();
		//loginReqBodyObj.ResponseCode();
		loginReqBodyObj.ResponseMessage();
	}
	
	@When("Admin calls Get Https method with valid endpoint")
	public void admin_calls_get_https_method_with_valid_endpoint() throws IOException {
		loginReqBodyObj.get_Logout_Without_Bearer();
	}

	@Then("Admin receives {int}  unauthorized Access")
	public void admin_receives_unauthorized_access(Integer int1) throws IOException {
		loginReqBodyObj.validatestatuscode();
		//loginReqBodyObj.ResponseCode();
		loginReqBodyObj.ResponseMessage();
	}
}
