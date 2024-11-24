package com.api.stepDef;

import org.testng.Assert;

import com.api.reqBody.ProgramReqBody;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramSteps {
	
	ProgramReqBody prgReqBody=new ProgramReqBody();
	
	@Given("Admin creates POST request by reading from data file with {string} and endpoint")
	public void admin_creates_post_request_by_reading_from_data_file_with_and_endpoint(String scenarioType) {
		
		prgReqBody.createRequest(scenarioType);
	}

	@When("Admin sends POST Api HTTPS request for given scenario {string}")
	public void admin_sends_post_api_https_request_for_given_scenario(String scenarioType) {
		
		if(scenarioType.equals("post_InvalidMethod")) {
			prgReqBody.SendRequest(scenarioType,"Put");
		}else if(scenarioType.equals("post_NoAuth")) {
			prgReqBody.SendRequest(scenarioType,"NoAuth_Post");
		}
		else {
			prgReqBody.SendRequest(scenarioType,"Post");
		}

     }


	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"post_addProgram\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_post_add_program() {
	
		Assert.assertEquals(prgReqBody.validateResponse(), true);
	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"post_InvalidEndpoint\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_post_invalid_endpoint() {
		
		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}
	

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"post_ExistingProgName\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_post_existing_prog_name() {
		
		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"post_InvalidMethod\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_post_invalid_method() {
		
		Assert.assertEquals(prgReqBody.validateResponse(), true);
   
	}
	
	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"post_InvalidReqBody\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_post_invalid_req_body() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"post_MissingValues\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_post_missing_values() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);


	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"post_MissingAdditField\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_post_missing_addit_field() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"post_NullValues\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_post_null_values() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"post_NoAuth\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_post_no_auth() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);


	}

	@Given("Admin creates GETAll request by reading from data file with {string} and endpoint")
	public void admin_creates_get_all_request_by_reading_from_data_file_with_and_endpoint(String scenarioType) {
		prgReqBody.createRequest(scenarioType);

	}

	@When("Admin sends GETAll Api HTTPS request for given scenario {string}")
	public void admin_sends_get_all_api_https_request_for_given_scenario(String scenarioType) {
 
		if(scenarioType.equals("getAll_InvalidMethod")) {
			prgReqBody.SendRequest(scenarioType,"Put");
		}else if(scenarioType.equals("getAll_NoAuth")) {
			prgReqBody.SendRequest(scenarioType,"NoAuth_Get");
		}
		else {
			prgReqBody.SendRequest(scenarioType,"Get");
		}		
	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getAll_validEndpoint\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_all_valid_endpoint() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getAll_InvalidEndpoint\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_all_invalid_endpoint() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getAll_InvalidMethod\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_all_invalid_method() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getAll_NoAuth\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_all_no_auth() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Given("Admin creates GET ProgId Api request by reading from data file with {string} and endpoint and programId")
	public void admin_creates_get_prog_id_api_request_by_reading_from_data_file_with_and_endpoint_and_program_id(String scenarioType) {

		prgReqBody.createRequest(scenarioType);

	}

	@When("Admin sends GET ProgId HTTPS request for given scenario {string}")
	public void admin_sends_get_prog_id_https_request_for_given_scenario(String scenarioType) {

		if(scenarioType.equals("getProgId_NoAuth")) {
			prgReqBody.SendRequest(scenarioType,"NoAuth_Get");
		}
		else {
			prgReqBody.SendRequest(scenarioType,"Get");
		}		
	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getProgId_validProgId\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_prog_id_valid_prog_id() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getProgId_InvalidEndpoint\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_prog_id_invalid_endpoint() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getProgId_InvalidProgId\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_prog_id_invalid_prog_id() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getProgId_InvalidBaseUri\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_prog_id_invalid_base_uri() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getProgId_NoAuth\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_prog_id_no_auth() {
		Assert.assertEquals(prgReqBody.validateResponse(), true);


	}

	@Given("Admin creates GETAll with Admins request from data file with {string} and endpoint")
	public void admin_creates_get_all_with_admins_request_from_data_file_with_and_endpoint(String scenarioType) {

		prgReqBody.createRequest(scenarioType);

	}

	@When("Admin sends GETAll with Admins HTTPS request for given scenario {string}")
	public void admin_sends_get_all_with_admins_https_request_for_given_scenario(String scenarioType) {

		if(scenarioType.equals("getAllAdmin_InvalidMethod")) {
			prgReqBody.SendRequest(scenarioType,"Put");
		}else if(scenarioType.equals("getAllAdmin_NoAuth")) {
			prgReqBody.SendRequest(scenarioType,"NoAuth_Get");
		}
		else {
			prgReqBody.SendRequest(scenarioType,"Get");
		}	

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getAllAdmin_validEndPoint\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_all_admin_valid_end_point() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getAllAdmin_InvalidEndpoint\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_all_admin_invalid_endpoint() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getAllAdmin_InvalidMethod\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_all_admin_invalid_method() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"getAllAdmin_NoAuth\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_get_all_admin_no_auth() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Given("Admin creates PUT progId request by reading data file with {string} endpoint and programId")
	public void admin_creates_put_prog_id_request_by_reading_data_file_with_endpoint_and_program_id(String scenarioType) {

		prgReqBody.createRequest(scenarioType);

	}
	
	@When("Admin sends PUT progId HTTPS request for given scenario {string}")
	public void admin_sends_put_prog_id_https_request_for_given_scenario(String scenarioType) {

		if(scenarioType.equals("putProgId_InvalidMethod")) {
			prgReqBody.SendRequest(scenarioType,"Post");
		}else if(scenarioType.equals("putProgId_NoAuth")) {
			prgReqBody.SendRequest(scenarioType,"NoAuth_Put");
		
		}
		else {
			prgReqBody.SendRequest(scenarioType,"Put");
		}	

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"putProgId_validProgId\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_put_prog_id_valid_prog_id() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"putProgId_InvalidProgId\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_put_prog_id_invalid_prog_id() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"putProgId_InvalidBaseURI\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_put_prog_id_invalid_base_uri() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"putProgId_InvalidMethod\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_put_prog_id_invalid_method() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"putProgId_InvalidReqBody\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_put_prog_id_invalid_req_body() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"putProgId_MissingReqBody\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_put_prog_id_missing_req_body() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario\"putProgId_NoAuth\"")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario_put_prog_id_no_auth() {

		Assert.assertEquals(prgReqBody.validateResponse(), true);

	}



}