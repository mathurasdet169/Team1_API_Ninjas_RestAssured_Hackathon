package com.api.utilities;

import static io.restassured.RestAssured.baseURI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


import com.api.payLoad.LoginPayload;
import com.api.payLoad.ProgramData;
import com.api.reqBody.LoginReqBody;
import com.api.reqBody.LoginJSONReader;
import com.api.reqBody.ProgramEditDeleteJSONReader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonUtils {
	public static RequestSpecification request;
	public static RequestSpecification userRequest;
	public static Response response;
	public static ResourceBundle endpoint = ResourceBundle.getBundle("endpoint");	
	public static ResourceBundle path = ResourceBundle.getBundle("path");	
	
	public static JsonReader jsonReaderObj = new JsonReader();
	public static List<ProgramData> lstobjPData=new ArrayList<ProgramData>();

	public static LoginJSONReader loginjsonReaderObj=new LoginJSONReader();
	
	public static void setBaseRequest_withoutBearer() {
		
            request = RestAssured.given()
                    .baseUri(baseURI)
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON);
        } 
		

	public static void setBaseUrl()
	{
		baseURI = endpoint.getString("baseUrl");
	}
	
	
	public static void setBaseRequest_withBearer () throws IOException 
	{		
		String token = LoginPayload.getToken();			
		userRequest = RestAssured.given().baseUri(baseURI).header("Authorization", "Bearer " + token);
	}

	public static String generateRandomString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            result.append(alphabet.charAt(index));
        }

        return result.toString();
    }
	
	public static  enum RequestType {
		  POST,
		  PUT,
		  GET,
		  DELETE,
		  NOAUTH_POST,
		  NOAUTH_PUT,
		  NOAUTH_GET,
		  NOAUTH_DELETE
		}
	public enum ProgramScenarioType {
	    POST_INVALID_METHOD("post_InvalidMethod"),
	    POST_NOAUTH_REQUEST("post_NoAuth"),
	    GETALL_INVALID_METHOD("getAll_InvalidMethod"),
	    GETALL_NOAUTH_REQUEST("getAll_NoAuth"),
		GET_PROGIDNOAUTH_METHOD("getProgId_NoAuth"),
		GETALL_ADMIN_INVALID_METHOD("getAllAdmin_InvalidMethod"),
		GETALL_ADMIN_NOAUTH_METHOD("getAllAdmin_NoAuth"),
		PUT_PROGID_INVALID_METHOD("putProgId_InvalidMethod"),
		PUT_PROGID_NOAUTH_METHOD("putProgId_NoAuth"),
		PUT_PROGNAME_NOAUTH_METHOD("putProgName_NoAuth"),
		POST_ADDPROGRAM_METHOD("post_addProgram"),
		DELETE_PROGNAME_NOAUTH_METHOD("deleteProgNam_NoAuth"),
		DELETE_PROGID_NOAUTH_METHOD("deleteProgId_NoAuth"),
		DELETE_PROGNAME("deleteProgName_ValidProgName"),
		DELETE_PROGID("deleteProgId_ValidProgId"),
		DELETE("delete");


	    private final String value;

	    ProgramScenarioType(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}
	public static Response makeRequest(String URL, RequestSpecification request, RequestType post) {
	    switch (post) {
	        case POST:
	            return request.when().post(URL);
	        case PUT:
	            return request.when().put(URL);
	        case GET:
	            return request.when().get(URL);
	        case DELETE:
	            return request.when().delete(URL);
	        default:
	            throw new IllegalArgumentException("Unsupported request type: " + post);
	    }
	}
	
	public static String GetProgramID() {
		if(lstobjPData!=null && lstobjPData.size()>0) {
			for (ProgramData pData : lstobjPData) {
				return pData.getProgramId();
			}
		}
		return "Id Not Available";
		
	}
	public static void DeleteAllProgram() {
		LoggerLoad.info("Delete All Program ID method called: ");

		if(lstobjPData!=null && lstobjPData.size()>0) {
			LoggerLoad.info("List of Program IDs: " + lstobjPData.size());

			try {
			String bearerToken =LoginReqBody.getBearerToken();

			RequestSpecification request = RestAssured.given()
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + bearerToken)
					.log().all();
			
			Iterator<ProgramData> iterator = lstobjPData.iterator();
			while (iterator.hasNext()) {
				
			    ProgramData objpdata = iterator.next();
			   
				LoggerLoad.info("ProgramId : " + objpdata.getProgramId());
				LoggerLoad.info("ProgramName from list : " + objpdata.getProgramName());

				String URL = endpoint.getString("ProgDeleteUrl");
				URL=URL+objpdata.getProgramName();
				System.out.println("URL : " + URL);

				response = makeRequest(URL,request,RequestType.DELETE);
				if(response.statusCode()== 200) {
			    	iterator.remove();

				}
			    
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LoggerLoad.info("List of Program IDs while exiting: " + lstobjPData.size());

		LoggerLoad.info("Delete All Program ID method Exited: ");

	}
	
	public static void validateResponseSchema(String schemaFilePath,Response response ) {
		File schemaFile = new File(schemaFilePath);
		LoggerLoad.info("Schema Validation:");
		  try {
	            response.then()
	                    .assertThat()
	                    .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
	            LoggerLoad.info("Schema Validation Passed.");
	        } catch (AssertionError e) {
	        	LoggerLoad.error("Schema Validation Failed: " + e.getMessage());
	        }
   
	 }
	


}

