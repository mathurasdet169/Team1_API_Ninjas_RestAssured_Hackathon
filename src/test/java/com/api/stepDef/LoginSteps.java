package com.api.stepDef;

import java.io.IOException;

import org.testng.Assert;

import com.api.reqBody.LoginReqBody;
import com.api.utilities.JsonReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	LoginReqBody loginReqBodyObj = new LoginReqBody();
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() {
	    // Write code here that turns the phrase above into concrete actions
	//    throw new io.cucumber.java.PendingException();
	}

	@When("Admin calls Post Https method with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		loginReqBodyObj.postRequestToGenerateToken();
	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer int1) {
	
		Assert.assertEquals(JsonReader.EXP_STATUSCODE, 200);
		
	}

}
