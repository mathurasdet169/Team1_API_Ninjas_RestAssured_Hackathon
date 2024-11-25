package com.api.stepDef;

import org.testng.Assert;

import com.api.reqBody.ProgramReqBody;
import com.api.utilities.LoggerLoad;
import com.api.utilities.CommonUtils.ProgramScenarioType;
import com.api.utilities.CommonUtils.RequestType;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramSteps {

	ProgramReqBody prgReqBody=new ProgramReqBody();
	String scenario;

	@Given("Admin creates POST request by reading from data file with {string} and endpoint")
	public void admin_creates_post_request_by_reading_from_data_file_with_and_endpoint(String scenarioType) {

		scenario=scenarioType;
		LoggerLoad.info("Admin creates POST request for : " +scenarioType);

		prgReqBody.createRequest(scenarioType);
	}

	@When("Admin sends POST Api HTTPS request for given scenario {string}")
	public void admin_sends_post_api_https_request_for_given_scenario(String scenarioType) {

		LoggerLoad.info("Admin Sends POST request for : " +scenarioType);

		if(scenarioType.equals(ProgramScenarioType.POST_INVALID_METHOD.getValue())) {
			prgReqBody.SendRequest(scenarioType, RequestType.PUT); 
		}else if(scenarioType.equals(ProgramScenarioType.POST_NOAUTH_REQUEST.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.NOAUTH_POST);
		}
		else {
			prgReqBody.SendRequest(scenarioType,RequestType.POST);
		}

	}

	@Then("Admin Validates expectedStatusCode and expectedResMsg for given scenario")
	public void admin_validates_expected_status_code_and_expected_res_msg_for_given_scenario() {

		if (prgReqBody.validateResponse()) {
			LoggerLoad.info("Scenario validation passed for : "+ scenario+ " for expected status code and response message.");
		} else {
			LoggerLoad.error("Scenario validation Failed for : " + scenario+ " for expected status code and response message.");
		}
		Assert.assertEquals(prgReqBody.validateResponse(), true);
	}



	@Given("Admin creates GETAll request by reading from data file with {string} and endpoint")
	public void admin_creates_get_all_request_by_reading_from_data_file_with_and_endpoint(String scenarioType) {
		scenario=scenarioType;
		prgReqBody.createRequest(scenarioType);

	}

	@When("Admin sends GETAll Api HTTPS request for given scenario {string}")
	public void admin_sends_get_all_api_https_request_for_given_scenario(String scenarioType) {

		if(scenarioType.equals(ProgramScenarioType.GETALL_INVALID_METHOD.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.PUT);
		}else if(scenarioType.equals(ProgramScenarioType.GETALL_NOAUTH_REQUEST.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.NOAUTH_GET);
		}
		else {
			prgReqBody.SendRequest(scenarioType,RequestType.GET);
		}		
	}


	@Given("Admin creates GET ProgId Api request by reading from data file with {string} and endpoint and programId")
	public void admin_creates_get_prog_id_api_request_by_reading_from_data_file_with_and_endpoint_and_program_id(String scenarioType) {
		scenario=scenarioType;
		prgReqBody.createRequest(scenarioType);

	}

	@When("Admin sends GET ProgId HTTPS request for given scenario {string}")
	public void admin_sends_get_prog_id_https_request_for_given_scenario(String scenarioType) {

		if(scenarioType.equals(ProgramScenarioType.GET_PROGIDNOAUTH_METHOD.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.NOAUTH_GET);
		}
		else {
			prgReqBody.SendRequest(scenarioType,RequestType.GET);
		}		
	}



	@Given("Admin creates GETAll with Admins request from data file with {string} and endpoint")
	public void admin_creates_get_all_with_admins_request_from_data_file_with_and_endpoint(String scenarioType) {
		scenario=scenarioType;
		prgReqBody.createRequest(scenarioType);

	}

	@When("Admin sends GETAll with Admins HTTPS request for given scenario {string}")
	public void admin_sends_get_all_with_admins_https_request_for_given_scenario(String scenarioType) {

		if(scenarioType.equals(ProgramScenarioType.GETALL_ADMIN_INVALID_METHOD.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.PUT);
		}else if(scenarioType.equals(ProgramScenarioType.GETALL_ADMIN_NOAUTH_METHOD.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.NOAUTH_GET);
		}
		else {
			prgReqBody.SendRequest(scenarioType,RequestType.GET);
		}	

	}


	@Given("Admin creates PUT progId request by reading data file with {string} endpoint and programId")
	public void admin_creates_put_prog_id_request_by_reading_data_file_with_endpoint_and_program_id(String scenarioType) {
		scenario=scenarioType;
		prgReqBody.createRequest(scenarioType);

	}

	@When("Admin sends PUT progId HTTPS request for given scenario {string}")
	public void admin_sends_put_prog_id_https_request_for_given_scenario(String scenarioType) {

		if(scenarioType.equals(ProgramScenarioType.PUT_PROGID_INVALID_METHOD.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.POST);
		}else if(scenarioType.equals(ProgramScenarioType.PUT_PROGID_NOAUTH_METHOD.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.NOAUTH_PUT);

		}
		else {
			prgReqBody.SendRequest(scenarioType,RequestType.PUT);
		}	

	}



	@Given("Admin create PUT progName request by reading data from data file with {string} and EndPoint")
	public void admin_create_put_prog_name_request_by_reading_data_from_data_file_with_and_end_point(String scenarioType) {
		scenario=scenarioType;
		prgReqBody.createRequest(scenarioType);

	}

	@When("Admin send PUT progName request for given scenario {string}")
	public void admin_send_put_prog_name_request_for_given_scenario(String scenarioType) {
		if(scenarioType.equals(ProgramScenarioType.PUT_PROGNAME_NOAUTH_METHOD.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.NOAUTH_PUT);

		}
		else {
			prgReqBody.SendRequest(scenarioType,RequestType.PUT);
		}	
	}



	@Given("Admin create DELETE progName request by reading data from data file with {string} and EndPoint")
	public void admin_create_delete_prog_name_request_by_reading_data_from_data_file_with_and_end_point(String scenarioType) {
		scenario=scenarioType;
		prgReqBody.createRequest(scenarioType);

	}

	@When("Admin send DELETE progName request for given scenario {string}")
	public void admin_send_delete_prog_name_request_for_given_scenario(String scenarioType) {
		if(scenarioType.equals(ProgramScenarioType.DELETE_PROGNAME_NOAUTH_METHOD.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.NOAUTH_DELETE);

		}
		else {
			prgReqBody.SendRequest(scenarioType,RequestType.DELETE);
		}	

	}



	@Given("Admin create DELETE progId request by reading data from data file with {string} and EndPoint")
	public void admin_create_delete_prog_id_request_by_reading_data_from_data_file_with_and_end_point(String scenarioType) {
		scenario=scenarioType;
		prgReqBody.createRequest(scenarioType);

	}

	@When("Admin send DELETE progId request for given scenario {string}")
	public void admin_send_delete_prog_id_request_for_given_scenario(String scenarioType) {
		
		if(scenarioType.equals(ProgramScenarioType.DELETE_PROGID_NOAUTH_METHOD.getValue())) {
			prgReqBody.SendRequest(scenarioType,RequestType.NOAUTH_DELETE);

		}
		else {
			prgReqBody.SendRequest(scenarioType,RequestType.DELETE);
		}	

	}




}