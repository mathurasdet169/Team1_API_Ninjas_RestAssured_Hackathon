package com.api.reqBody;

import com.api.payLoad.ProgramData;
import com.api.payLoad.ProgramPayload;

import com.api.payLoad.ProgramRequest;
import com.api.payLoad.ProgramValidateData;
import com.api.utilities.CommonUtils;
import com.api.utilities.LoggerLoad;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


public class ProgramReqBody extends CommonUtils{

	static List<ProgramPayload> scenarios;
	ProgramRequest requestBody =null;
	ProgramValidateData validateData=null;
	static String bearerToken;
	Response response;
	String Deleteid = null;


	//static List<ProgramData> lstobjPData=new ArrayList<ProgramData>();

	public ProgramReqBody() {
		LoggerLoad.info("Entering ProgramReqBody constructor.");
		try {
			if(scenarios==null) {
				LoggerLoad.info("Loading scenarios from JSON file.");

				scenarios = jsonReaderObj.getProgramScenarios(path.getString("ProgramJsonPath"));
				LoggerLoad.info("Scenarios successfully loaded.");

				bearerToken =LoginReqBody.getBearerToken();
				LoggerLoad.info("Bearer token successfully retrieved.");

			}

		}catch (Exception ex) {

			LoggerLoad.error("Exception occurred in ProgramReqBody method " + ex.getMessage());
		}
	}

	public boolean createRequest(String scenarioType) {

		LoggerLoad.info("Entering createRequest method with scenarioType: " + scenarioType);

		Optional<ProgramPayload> scenario = scenarios.stream()
				.filter(s -> scenarioType.equals(s.getScenario()))
				.findFirst();
		try {
			if (scenario.isPresent()) {
				LoggerLoad.info("Scenario found for scenarioType: " + scenarioType);

				if(scenario.get().getRequestBody()!=null) {
					requestBody  = scenario.get().getRequestBody();
					LoggerLoad.info("Request body set for scenarioType: " + scenarioType);

					if(scenarioType.contains(ProgramScenarioType.POST_ADDPROGRAM_METHOD.getValue())){
						String progName=requestBody.getProgramName() + "-" + CommonUtils.generateRandomString(4);
						requestBody.setProgramName(progName);
						LoggerLoad.info("Program name generated: " + progName);

					}
				}
				validateData = scenario.get().getValidateData();
				LoggerLoad.info("Validatedata set for scenarioType: " + scenarioType);

				return true;

			} else {
				LoggerLoad.info("Scenario not found:  " + scenarioType);

				return false;
			}	
		}catch (Exception ex) {

			LoggerLoad.error("Exception occurred in createRequest method " + ex.getMessage());
		}
		return false;
	}


	public Response SendRequest(String scenarioType,RequestType requestType) {

		LoggerLoad.info("Starting SendRequest method for scenario: " + scenarioType);

		try {
			if (validateData != null) {		
				String URL = endpoint.getString("baseUrl") + validateData.getEndpoint();
				
				LoggerLoad.info("Original URL: " + URL);
				LoggerLoad.info("list of added Programs: " + lstobjPData.size());


				if (URL.contains("programId") || URL.contains("programName")) {
					URL=updateprogUrl(URL);

				}
				if(scenarioType.toLowerCase().contains("invalidbaseuri")) {
					URL = endpoint.getString("invalidBaseUrl") + validateData.getEndpoint();
					LoggerLoad.info("Using invalid base URL: " + URL);

				}

				RequestSpecification request = RestAssured.given()
						.header("Content-Type", "application/json")
						.log().all(); 
				
				LoggerLoad.info("Request type: " + requestType);


				if (bearerToken != null && !requestType.toString().contains("NOAUTH")) {
					request.header("Authorization", "Bearer " + bearerToken);
					LoggerLoad.info("Added bearer token to request.");

				}

				if (requestBody != null) {
					request.body(requestBody);
					LoggerLoad.info("Request body: "+ requestBody.getProgramDescription() +"  " + requestBody.getProgramName() +" " + requestBody.getProgramStatus() );

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
					
					validateResponseSchema(path.getString("createProgramSchema"), response);
					ProgramData objpdata=new  ProgramData();
					objpdata.setProgramId(response.jsonPath().getString("programId"));
					objpdata.setProgramName(response.jsonPath().getString("programName"));
					lstobjPData.add(objpdata);

					LoggerLoad.info("Program added: ID - " + objpdata.getProgramId() + ", Name - " + objpdata.getProgramName());

					//System.out.println("ProgramId: " + ProgramId);
				}

				if(response.getStatusCode()== 200 && scenarioType.contains(ProgramScenarioType.DELETE.getValue())) {

					deleteIdfromStoredList(scenarioType,Deleteid);
				}
			}

		}catch (Exception ex) {

			LoggerLoad.error("Exception occurred in SendRequest method " + ex.getMessage());
		}


		// Log the response details
		logResponseDetails(response);

		return response;
	}

	private void logResponseDetails(Response response) {
		try {
			System.out.println("Response: " + response.asPrettyString());
			System.out.println("Status Code: " + response.getStatusCode());
		}catch (Exception ex) {

			LoggerLoad.error("Exception occurred inlogResponseDetails method " + ex.getMessage());
		}
	}

	public boolean validateResponse() {
		LoggerLoad.info("Entering validateResponse method.");
		try {

			if(response!=null && validateData!=null) {

				LoggerLoad.info("Response and validatedata are not null.");
				LoggerLoad.info("Actual code: "+ response.getStatusCode());
				LoggerLoad.info("Expected code: "+ validateData.getExpectedStatusCode());
				LoggerLoad.info("Received Response message: "+ response.getBody().asPrettyString());
				
				if(response.getStatusCode()==validateData.getExpectedStatusCode()) {

					LoggerLoad.info("Status codes match. Validation successful.");
					return true;
				}
			}
			
		}catch (Exception ex) {
			LoggerLoad.error("Exception occurred in validateResponse method: " + ex.getMessage());

		}finally {

			LoggerLoad.info("Exiting validateResponse method.");
		}

		return false;
	}

	private void deleteIdfromStoredList(String scenarioType,String Deleteid) {
		LoggerLoad.info("Entering deleteIdfromStoredList function");

		if(lstobjPData!=null && lstobjPData.size()>0 ) {
			LoggerLoad.info("count of Program id before deletion : " + lstobjPData.size());
			LoggerLoad.info("ScenarioType : " + scenarioType);
			LoggerLoad.info("Deleteid : " + Deleteid);

			
			Iterator<ProgramData> iterator = lstobjPData.iterator();
			while (iterator.hasNext()) {
				
			    ProgramData objpdata = iterator.next();
				LoggerLoad.info("ProgramId : " + objpdata.getProgramId());
				LoggerLoad.info("ProgramName from list : " + objpdata.getProgramName());
				//LoggerLoad.info("ProgramName from request : " + requestBody.getProgramName());


			    if (scenarioType.equals(ProgramScenarioType.DELETE_PROGNAME.getValue()) && objpdata.getProgramName().equals(Deleteid)) {
					LoggerLoad.info("Going to Delete ProgName : " + Deleteid);
			        iterator.remove();
			        break;
			    } else if (scenarioType.equals(ProgramScenarioType.DELETE_PROGID.getValue()) && objpdata.getProgramId().equals(Deleteid)) {
					LoggerLoad.info("Going to Delete ProgId : " + Deleteid);
			    	iterator.remove();
			        break;
			    }
			}
		
			LoggerLoad.info("count of Program id after deletion : " + lstobjPData.size());

		}
		LoggerLoad.info("Exiting deleteIdfromStoredList function : " + lstobjPData.size());


	}

	private String updateprogUrl(String URL) {
		LoggerLoad.info("Entering updateprog function ");

		if(lstobjPData!=null && lstobjPData.size()>0 ) {
			for (ProgramData objpdata : lstobjPData) {
				if(URL.contains("programId")) {
					URL = URL.replace("programId", objpdata.getProgramId());
					Deleteid=objpdata.getProgramId();
				}
				else if(URL.contains("programName")) {
					URL = URL.replace("programName", objpdata.getProgramName());
					Deleteid=objpdata.getProgramName();
				}
				if(requestBody!=null)
					requestBody.setProgramName(objpdata.getProgramName());

				LoggerLoad.info("Updated URL: " + URL);
				LoggerLoad.info("Program ID: " + objpdata.getProgramId());
				LoggerLoad.info("Program Name: " + objpdata.getProgramName());
				System.out.println("Updated URL: " + URL);
				System.out.println(objpdata.getProgramId());
				System.out.println(objpdata.getProgramName());

				break;
			}
		}
		LoggerLoad.info("Exiting updateprog function : ");

		return URL;
		
	}
	
	



}
