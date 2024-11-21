package com.api.reqBody;

import java.io.IOException;

import com.api.utilities.CommonUtils;

import io.restassured.response.Response;

public class BatchReqBody extends CommonUtils{
	
	public Response createBatchWithoutAuth(String scenarioType) throws IOException {
		
		response = request.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType)).post(endpoint.getString("createBatch"));
		System.out.println("--createBatchWithoutAuth status--" + response.statusCode());
		response.prettyPrint();
		return response;
	}
	
	
	public Response createBatch(String scenarioType) throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}
		
		response = request.header("Authorization", "Bearer " + 
		LoginReqBody.getBearerToken()).body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType)).post(endpoint.getString("createBatch"));
		System.out.println("--createBatch status-- " + response.statusCode() );
		response.prettyPrint();
		return response;
		
	}
	
	public Response createBatchWithInvalidEndpoint(String scenarioType) throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}
		
		response = request.header("Authorization", "Bearer " + 
		LoginReqBody.getBearerToken()).body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType)).post(endpoint.getString("invalidEndPoint"));
		System.out.println("--createBatchWithInvalidEndpoint status-- " + response.statusCode() );
		response.prettyPrint();
		return response;
		
	}
	
	

}
