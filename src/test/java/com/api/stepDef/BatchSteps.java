package com.api.stepDef;

import java.io.IOException;

import com.api.payLoad.BatchPayload;
import com.api.reqBody.BatchReqBody;
import com.api.utilities.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchSteps extends CommonUtils{
	
	BatchReqBody batchReqBodyObj = new BatchReqBody();
	
	@Given("User creates POST request")
	public void user_creates_post_request() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	

	@When("User sends POST HTTP request with {string} and endpoint")
	public void user_sends_post_http_request_with_and_endpoint(String scenarioType) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	  
	    
	    if (scenarioType.equals("CreateBatchWithoutAuth"))
		{
			batchReqBodyObj.createBatchWithoutAuth(scenarioType);
		} else if (scenarioType.equals("CreateBatchWithValidData") || scenarioType.equals("CreateBatchExistingBatchName") ||
		scenarioType.equals("CreateBatchWithMissingData") || scenarioType.equals("CreateBatchWithMissingAdditioanlFields")||
		scenarioType.equals("CreateBatchWithInValidData") || scenarioType.equals("CreateBatchWithInactiveProgId"))
		{
				batchReqBodyObj.createBatch(scenarioType);
		} else if (scenarioType.equals("CreateBatchWithInvalidEndpoint"))
		{
			batchReqBodyObj.createBatchWithInvalidEndpoint(scenarioType);
		}
			else 
				System.out.println("Ending all scenarios");
		
	}

	@Then("User receives {int} and with response body for create")
	public void user_receives_and_with_response_body_for_create(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	//    throw new io.cucumber.java.PendingException();
		
		
	}


}
