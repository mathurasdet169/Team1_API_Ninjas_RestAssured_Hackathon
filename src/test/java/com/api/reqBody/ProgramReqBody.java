package com.api.reqBody;

import com.api.payLoad.ProgramData;
import com.api.payLoad.ProgramPayload;

import com.api.payLoad.ProgramRequest;
import com.api.payLoad.ProgramValidateData;
import com.api.utilities.CommonUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProgramReqBody extends CommonUtils{

	List<ProgramPayload> scenarios;
	ProgramRequest requestBody =null;
	ProgramValidateData validateData=null;
	String bearerToken;
	Response response;
	//="16302";
	//static List<ProgramData> lstobjPData=new ArrayList<ProgramData>();

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
				if(scenarioType.contains(ProgramScenarioType.POST_ADDPROGRAM_METHOD.getValue())){
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


	public Response SendRequest(String scenarioType,RequestType requestType) {
//		if (requestBody == null) {
//			requestBody = new ProgramRequest(); // Default to an empty request body
//		}

		if (validateData != null) {
			System.out.println("validateData : " + validateData.toString());
		}

		String URL = endpoint.getString("baseUrl") + validateData.getEndpoint();
		System.out.println("URL : " + URL);
		System.out.println("list of added Programs: " + lstobjPData.size());

		if (URL.contains("programId") || URL.contains("programName")) {
			if(lstobjPData!=null && lstobjPData.size()>0 ) {
				for (ProgramData objpdata : lstobjPData) {
					if(URL.contains("programId")&& requestBody!=null) {
						URL = URL.replace("programId", objpdata.getProgramId());
						requestBody.setProgramName(objpdata.getProgramName());
					}
					else if(URL.contains("programName"))
						URL = URL.replace("programName", objpdata.getProgramName());
					else if(URL.contains("programId"))
						URL = URL.replace("programId", objpdata.getProgramId());

					System.out.println("Updated URL: " + URL);
					System.out.println(objpdata.getProgramId());
					System.out.println(objpdata.getProgramName());
					//break;
				}
			}
//			else {
//				URL = URL.replace("programId","16356");
//
//			}
		}
		if(scenarioType.toLowerCase().contains("invalidbaseuri")) {
			URL = endpoint.getString("invalidBaseUrl") + validateData.getEndpoint();
		}

		RequestSpecification request = RestAssured.given()
				.header("Content-Type", "application/json")
				.log().all(); 

		if (bearerToken != null && !requestType.toString().contains("NOAUTH")) {
			request.header("Authorization", "Bearer " + bearerToken);
		}

		if (requestBody != null) {
			request.body(requestBody);
		}

		switch (requestType) {
		case POST:
		case NOAUTH_POST:
			response = makeRequest(URL,request,RequestType.POST);
			break;
		case PUT:
		case NOAUTH_PUT:
			response = makeRequest(URL,request,RequestType.PUT);
			break;
		case GET:
		case NOAUTH_GET:
			response = makeRequest(URL,request,RequestType.GET);
			break;
		case DELETE:
		case NOAUTH_DELETE:
			response = makeRequest(URL,request,RequestType.DELETE);
			break;
		default:
			throw new IllegalArgumentException("Unsupported request type: " + requestType);
		}

		// Handle specific scenario for post_addProgram
		if (scenarioType.contains(ProgramScenarioType.POST_ADDPROGRAM_METHOD.getValue()) && response != null) {
			ProgramData objpdata=new  ProgramData();
			objpdata.setProgramId(response.jsonPath().getString("programId"));
			objpdata.setProgramName(response.jsonPath().getString("programName"));
			lstobjPData.add(objpdata);
			//System.out.println("ProgramId: " + ProgramId);
		}

		// Log the response details
		logResponseDetails(response);

		return response;
	}

	private void logResponseDetails(Response response) {
		System.out.println("Response: " + response.asPrettyString());
		System.out.println("Status Code: " + response.getStatusCode());
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
