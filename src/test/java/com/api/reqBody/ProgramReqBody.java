package com.api.reqBody;

import com.api.payLoad.ProgramPayload;

import com.api.payLoad.ProgramRequest;
import com.api.payLoad.ProgramValidateData;
import com.api.utilities.CommonUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;
import java.util.Optional;

public class ProgramReqBody extends CommonUtils{

	List<ProgramPayload> scenarios;
	ProgramRequest requestBody =null;
	ProgramValidateData validateData=null;
	String bearerToken;
	Response response;
	String ProgramId="16302";
;

	public ProgramReqBody() {
		try {
			if(scenarios==null) {
				scenarios = jsonReaderObj.getProgramScenarios(path.getString("ProgramJsonPath"));
				bearerToken =LoginReqBody.getBearerToken();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public boolean createRequest(String scenarioType) {
		Optional<ProgramPayload> scenario = scenarios.stream()
				.filter(s -> scenarioType.equals(s.getScenario()))
				.findFirst();

		if (scenario.isPresent()) {
			// Scenario is present
			if(scenario.get().getRequestBody()!=null) {
				requestBody  = scenario.get().getRequestBody();
				if(scenarioType.equals("post_addProgram")){
					String progName=requestBody.getProgramName() + "-" + CommonUtils.generateRandomString(4);
					requestBody.setProgramName(progName);
				}
			}
			validateData = scenario.get().getValidateData();
			return true;
		} else {
			return false;
		}		
	}



	public Response SendRequest(String ScenarioType,String RequestType) {
		if(requestBody!=null) {
			System.out.println("requestBody : " + requestBody.toString());
		}
		else {
			requestBody=new ProgramRequest();
		}
		if(validateData!=null) {
			System.out.println("validateData : " + validateData.toString());
		}
		String URL=endpoint.getString("baseUrl") + validateData.getEndpoint();
		//String InvalidURL=endpoint.getString("invalidBaseUri") + validateData.getEndpoint();

		System.out.println("URL : " + URL);
		//System.out.println("InvalidURL : " + InvalidURL);


		//int programid=Integer.parseInt(ProgramId);
		if(URL.contains("programId")) {
			URL=URL.replace("programId",ProgramId);
			System.out.println("URL : " + URL);	
		}
		
		switch(RequestType){
		case "Post":
			response = RestAssured
			.given()
			.header("Authorization", "Bearer " + bearerToken)
			.header("Content-Type", "application/json")
			.body(requestBody).log().all()
			.when()
			.post(URL);
			break;
		case "Put":
			response = RestAssured
			.given()
			.header("Authorization", "Bearer " + bearerToken)
			.header("Content-Type", "application/json")
			.body(requestBody).log().all()
			.when()
			.put(URL);
			break;
		case "Get":
			response = RestAssured
			.given()
			.header("Authorization", "Bearer " + bearerToken)
			.header("Content-Type", "application/json")
			.log().all()
			.when()
			.get(URL);
			break;
		case "NoAuth_Post":
			response = RestAssured
			.given()
			.header("Content-Type", "application/json")
			.body(requestBody).log().all()
			.when()
			.post(URL);
			break;
		case "NoAuth_Put":
			response = RestAssured
			.given()
			.header("Content-Type", "application/json")
			.body(requestBody).log().all()
			.when()
			.put(URL);
			break;
		case "NoAuth_Get":
			response = RestAssured
			.given()
			.header("Content-Type", "application/json")			
			.when()
			.get(URL);
			break;

			

		}
		if(ScenarioType.equals("post_addProgram")) {
			ProgramId = response.jsonPath().getString("programId");
			System.out.println(ProgramId);
		}
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());


		return response;
	}	
	public boolean validateResponse() {
		if(response!=null && validateData!=null) {
			if(response.getStatusCode()==validateData.getExpectedStatusCode()) {
				return true;
			}

		}
		System.out.println("Actual code: "+ response.getStatusCode());
		System.out.println("Expected code: "+ validateData.getExpectedStatusCode());

		return false;
	}
}
