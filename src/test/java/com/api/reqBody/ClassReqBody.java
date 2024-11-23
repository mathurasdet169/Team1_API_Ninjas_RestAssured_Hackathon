package com.api.reqBody;


import java.io.IOException;
import com.api.payLoad.*;
import com.api.utilities.CommonUtils;



import io.restassured.response.Response;

public class ClassReqBody extends CommonUtils {

	 public static Response response;
	  String classEndpoint = endpoint.getString("getAllClass");
	   String invalidEndpoint = endpoint.getString("invalidGetAllClass");
	   
//Get all class	scenarios  
//with auth
	 public Response getAllClassesWithAuth() throws IOException {
		    String token = LoginReqBody.getBearerToken();
		    if (token == null || token.isEmpty()) {
		        throw new IllegalStateException("User token has not been generated.");
		    }
		    response = request.header("Authorization", "Bearer " + token).get(classEndpoint );
		    logResponse("--Get All Classes with Auth--", response);
		    return response;
		}
//invalid endpoint
		public Response getAllClassesWithInvalidEndpoint() throws IOException {
		    String token = LoginReqBody.getBearerToken();
		    if (token == null || token.isEmpty()) {
		        throw new IllegalStateException("User token has not been generated.");
		    }
		    response = request.header("Authorization", "Bearer " + token).get(invalidEndpoint);
		    logResponse("--Get All Classes with Invalid Endpoint--", response);
		    return response;
		}
//invalid method
		public Response getAllClassesWithInvalidMethod() throws IOException {
		    String token = LoginReqBody.getBearerToken();
		    if (token == null || token.isEmpty()) {
		        throw new IllegalStateException("User token has not been generated.");
		    }
		    response = request.header("Authorization", "Bearer " + token).post(classEndpoint); 
		    logResponse("--Get All Classes with Invalid Method--", response);
		    return response;
		}
//no auth
		public Response getAllClassesWithoutAuth() throws IOException {
		    response = request.get(classEndpoint); // No Authorization header
		    logResponse("--Get All Classes without Auth--", response);
		    return response;
		}

	
//Loging the response 
	    private void logResponse(String context, Response response) {
	        System.out.println(context + " Status Code: " + response.statusCode());
	        response.prettyPrint();
	    }
	    


	    
	    
	    
	}

