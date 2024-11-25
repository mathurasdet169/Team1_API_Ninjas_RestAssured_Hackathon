package com.api.stepDef;

import java.io.IOException;
import com.api.reqBody.LogoutReqBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
	LogoutReqBody logout=new LogoutReqBody();
	
	@Given("Admin create GET request for Logout")
	public void admin_create_get_request_for_logout() throws IOException {
		logout.CreateGetRequest();
		
	}

	@When("Admin send HTTP Get request for valid end point")
	public void admin_send_http_get_request_for_valid_end_point() throws IOException {
		logout.SendGetRequest();
	}

	@Then("Admin receive status code {int} OK")
	public void admin_receive_status_code_ok(Integer int1) {
		logout.statusvalidate();
	}

	@When("Admin send HTTP Get request for Invalid end point")
	public void admin_send_http_get_request_for_invalid_end_point() {
		logout.CreateGetForInvalidEndPoint();
	}

	@Then("Admin receive status code {int} Unauthorized")
	public void admin_receive_status_code_unauthorized(Integer int1) {
        logout.Unauthorizestatus();
	}
}
