package com.api.stepDef;

import java.io.IOException;

import com.api.payLoad.BatchPayload;
import com.api.reqBody.BatchReqBody;
import com.api.utilities.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchSteps extends CommonUtils {

	BatchReqBody batchReqBodyObj = new BatchReqBody();
	BatchPayload batchPayload;
	
//    // Constructor-based dependency injection (PicoContainer will inject BatchPayload)
//    public BatchSteps(BatchPayload batchPayload) {
//        this.batchPayload = batchPayload;
//    }

	@Given("User creates POST request")
	public void user_creates_post_request() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@When("User sends POST HTTP request with {string} and endpoint")
	public void user_sends_post_http_request_with_and_endpoint(String scenarioType) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		if (scenarioType.equals("CreateBatchWithoutAuth")) {
			batchReqBodyObj.createBatchWithoutAuth(scenarioType);
		} else if (scenarioType.equals("CreateBatchWithValidData")
				|| scenarioType.equals("CreateBatchExistingBatchName")
				|| scenarioType.equals("CreateBatchWithMissingData")
				|| scenarioType.equals("CreateBatchWithMissingAdditioanlFields")
				|| scenarioType.equals("CreateBatchWithInValidData")
				|| scenarioType.equals("CreateBatchWithInactiveProgId")) {
			batchReqBodyObj.createBatch(scenarioType, batchPayload);
		} else if (scenarioType.equals("CreateBatchWithInvalidEndpoint")) {
			batchReqBodyObj.createBatchWithInvalidEndpoint(scenarioType);
		} else
			System.out.println("Ending all scenarios");

	}

	@Then("User receives {int} of post with response body for {string}")
	public void user_receives_of_post_with_response_body_for(Integer expectedStatusCode, String scenarioType)
			throws IOException {
		// Write code here that turns the phrase above into concrete actions

		batchReqBodyObj.validateResponse(expectedStatusCode, "create", scenarioType);

	}

	@Given("User creates PUT request")
	public void user_creates_put_request() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("User sends PUT HTTP request with {string} and endpoint")
	public void user_sends_put_http_request_with_and_endpoint(String scenarioType) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		if (scenarioType.equals("UpdateBatchbyBatchIdWithoutAuth")) {
			batchReqBodyObj.updateBatchByBatchIdWithoutAuth(scenarioType);
		} else if (scenarioType.equals("UpdateBatchbyBatchId") || scenarioType.equals("UpdateBatchWithMissingData")
				|| scenarioType.equals("UpdateBatchWithInValidData")
				|| scenarioType.equals("UpdateBatchWithDeletedProgID")) {
			batchReqBodyObj.updateBatchByBatchId(scenarioType);
		} else if (scenarioType.equals("UpdateBatchWithInvalidEndpoint")) {
			batchReqBodyObj.updateBatchByInvalidEndPoint(scenarioType);
		} else if (scenarioType.equals("UpdateBatchbyInvalidBatchId")) {
			batchReqBodyObj.updateBatchByInvalidBatchId(scenarioType);
		} else if (scenarioType.equals("UpdateBatchWithDeletedBatchID")) {
			batchReqBodyObj.updateBatchByDeletedBatchID(scenarioType);
		} else
			System.out.println("Ending all scenarios");

	}


	@Then("User receives {int} of put with response body for {string}")
	public void user_receives_of_put_with_response_body_for(Integer expectedStatusCode, String scenarioType) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		batchReqBodyObj.validateResponse(expectedStatusCode, "update", scenarioType);
	}
	
	@Given("User creates GET request for all batches with {string} data")
	public void user_creates_get_request_for_all_batches_with_data(String string) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("User sends GET HTTP request with endpoint for get all {string} data")
	public void user_sends_get_http_request_with_endpoint_for_get_all_data(String scenarioType) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		if (scenarioType.equals("GetAllBatches")) {
			batchReqBodyObj.getAllBatches(); }
//		} else if (scenarioType.equals("UpdateBatchbyBatchId") || scenarioType.equals("UpdateBatchWithMissingData")
//				|| scenarioType.equals("UpdateBatchWithInValidData")
//		batchReqBodyObj.
	}

	@Then("User receives {int} and with response body for get all batches")
	public void user_receives_and_with_response_body_for_get_all_batches(Integer expectedStatusCode) {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Given("User creates GET request by batchId with {string} data")
	public void user_creates_get_request_by_batch_id_with_data(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("User sends GET HTTP request with endpoint for get by batch Id {string}")
	public void user_sends_get_http_request_with_endpoint_for_get_by_batch_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	 
	}

	@Then("User receives {int} and with response body for get by batch Id")
	public void user_receives_and_with_response_body_for_get_by_batch_id(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Given("User creates GET request by batch name with {string} data")
	public void user_creates_get_request_by_batch_name_with_data(String string) {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@When("User sends GET HTTP request with endpoint for get by batch name {string}")
	public void user_sends_get_http_request_with_endpoint_for_get_by_batch_name(String string) {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Then("User receives {int} and with response body for get by batch name")
	public void user_receives_and_with_response_body_for_get_by_batch_name(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Given("User creates GET request by prog Id with {string} data")
	public void user_creates_get_request_by_prog_id_with_data(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("User sends GET HTTP request with endpoint for get by prog Id  {string}")
	public void user_sends_get_http_request_with_endpoint_for_get_by_prog_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	
	}

	@Then("User receives {int} and with response body for get by prog Id")
	public void user_receives_and_with_response_body_for_get_by_prog_id(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Given("User creates Delete request with {string} data")
	public void user_creates_delete_request_with_data(String scenarioType) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("User sends DELETE HTTP request with {string} endpoint")
	public void user_sends_delete_http_request_with_endpoint(String scenarioType) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		if (scenarioType.equals("DeleteBatchByBatchID")) {
			batchReqBodyObj.deleteBatchByBatchID(); 
			} else if (scenarioType.equals("DeleteBatchWithInvalidEndpoint")) {
				batchReqBodyObj.deleteBatchWithInvalidEndpoint();
			} else if (scenarioType.equals("DeleteBatchbyInvalidBatchId")) {
				batchReqBodyObj.deleteBatchByInvalidBatchId();
			} else if (scenarioType.equals("DeleteBatchWithoutAuth")) {
				batchReqBodyObj.deleteBatchWithoutAuth();
			}  else
				System.out.println("Ending all scenarios");
	}

	@Then("User receives {int} and with response body for delete {string}")
	public void user_receives_and_with_response_body_for_delete(Integer expectedStatusCode, String scenarioType) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		batchReqBodyObj.validateResponse(expectedStatusCode, "delete", scenarioType);
	}
}
