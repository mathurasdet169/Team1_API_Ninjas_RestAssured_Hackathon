package com.api.reqBody;

import com.api.utilities.CommonUtils;
import com.api.utilities.JsonReader;

import io.restassured.response.Response;

import java.io.IOException;

import com.api.payLoad.*;

public class ClassReqBody extends CommonUtils {
	
	public static Response response;

		public Response getGetAllClassRecording() throws IOException {
		
			if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}
		
		response = request.header("Authorization", "Bearer " + 
		LoginReqBody.getBearerToken()).get(JsonReader.endpoint);
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;
		
	}
		public Response getGetAllClassRecordingWithInvalidMethod() throws IOException {
			
			if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}
		
		response = request.header("Authorization", "Bearer " + 
		LoginReqBody.getBearerToken()).post(JsonReader.endpoint);
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;
		
	}
		public Response getGetAllClassRecordingNoAuth() throws IOException {
			
			if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}
		
		response = request.header("Authorization", "Bearer " + 
		" ").get(JsonReader.endpoint);
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;
		
	}
		
}
