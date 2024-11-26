package com.api.reqBody;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Assert;

import com.api.payLoad.BatchPayload;

import com.api.utilities.CommonUtils;
import com.api.utilities.LoggerLoad;

import io.restassured.response.Response;

public class BatchReqBody extends CommonUtils {

	public static String batchId;

	public Response createBatchWithoutAuth(String scenarioType) throws IOException {

		response = request.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.post(endpoint.getString("createBatch"));
		LoggerLoad.info("--createBatchWithoutAuth status--" + response.statusCode());
		response.prettyPrint();
		return response;
	}

	public Response createBatch(String scenarioType, BatchPayload batchPayload) throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.post(endpoint.getString("createBatch"));
		LoggerLoad.info("--createBatch status-- " + response.statusCode());
		response.prettyPrint();
		if (response.statusCode() == 201) {
			batchId = response.jsonPath().getString("batchId");
			// batchPayload.setBatchId(batchId);
			LoggerLoad.info("batchId---->" + batchId);
			BatchPayload batchpayload = new BatchPayload();
			batchpayload.setBatchId(batchId);
			lstobjBData.add(batchpayload);
		}
		return response;

	}

//	public static String getBatchId() throws IOException {
//		// Generate the token if it does not exist
//		if (batchId == null) {
//			createBatch("CreateBatchWithValidData");
//		}
//		return batchId;
//		}

	public Response createBatchWithInvalidEndpoint(String scenarioType) throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.post(endpoint.getString("invalidEndPoint"));
		LoggerLoad.info("--createBatchWithInvalidEndpoint status-- " + response.statusCode());
		response.prettyPrint();
		return response;

	}

	public Response updateBatchByBatchId(String scenarioType) throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		if (batchId == null) {
			throw new IllegalStateException("batchId is null");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.put(endpoint.getString("updateByBatchId") + batchId);
		LoggerLoad.info("--updateByBatchId-- " + response.statusCode());
		response.prettyPrint();
		return response;

	}

	public Response updateBatchByBatchIdWithoutAuth(String scenarioType) throws IOException {

		response = request
				.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.put(endpoint.getString("updateByBatchId") + batchId);
		LoggerLoad.info("--updateBatchByBatchIdWithoutAuth-- " + response.statusCode());
		response.prettyPrint();
		return response;

	}

	public Response updateBatchByInvalidBatchId(String scenarioType) throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.put(endpoint.getString("updateByBatchId") + endpoint.getString("invalidBatchId"));
		LoggerLoad.info("--updateByBatchId-- " + response.statusCode());
		response.prettyPrint();
		return response;

	}

	public Response updateBatchByInvalidEndPoint(String scenarioType) throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		if (batchId == null) {
			throw new IllegalStateException("batchId is null");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.put(endpoint.getString("invalidEndPoint") + batchId);
		LoggerLoad.info("--updateBatchByInvalidEndPoint-- " + response.statusCode());
		response.prettyPrint();
		return response;

	}

	public Response updateBatchByDeletedBatchID(String scenarioType) throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.put(endpoint.getString("updateByBatchId") + endpoint.getString("deletedBatchId"));
		LoggerLoad.info("--updateBatchByDeletedBatchID-- " + response.statusCode());
		response.prettyPrint();
		return response;

	}

	public Response getAllBatches() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("getAllBatches"));
		return response;

	}

	public Response deleteBatchByBatchID() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.delete(endpoint.getString("deleteBatch") + batchId);
		LoggerLoad.info("--deleteBatchByBatchID-- " + response.statusCode());
		response.prettyPrint();
		return response;
	}
	
	public Response deleteBatchWithInvalidEndpoint() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.delete(endpoint.getString("invalidEndPoint") + batchId);
		LoggerLoad.info("--deleteBatchWithInvalidEndpoint-- " + response.statusCode());
		response.prettyPrint();
		return response;
	}
	
	public Response deleteBatchByInvalidBatchId() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.delete(endpoint.getString("deleteBatch") + endpoint.getString("invalidBatchId"));
		LoggerLoad.info("--deleteBatchByInvalidBatchId-- " + response.statusCode());
		response.prettyPrint();
		return response;
	}
	
	public Response deleteBatchWithoutAuth() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request
				.delete(endpoint.getString("deleteBatch") + batchId);
		LoggerLoad.info("--DeleteBatchWithoutAuth-- " + response.statusCode());
		response.prettyPrint();
		return response;
	}

	public void validateResponse(int expectedStatusCode, String operationType, String scenarioType) throws IOException {

		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals("Status code does not match", expectedStatusCode, actualStatusCode);
		// Assert.assertNotNull("Response is null", response);

		if (expectedStatusCode == 201) {
			// String errorMessage = response.jsonPath().getString("message");
			String responseBody = response.getBody().asString();
			String expectedJsonString = jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"),
					scenarioType);
			JSONObject actualJson = new JSONObject(responseBody);
			actualJson.remove("batchId");
			JSONObject expectedJson = new JSONObject(expectedJsonString);
			if ("create".equalsIgnoreCase(operationType)) {
				Assert.assertTrue("Response body does not contain id", responseBody.contains("batchId"));
				Assert.assertEquals("Response body does not match", expectedJson.toString(), actualJson.toString());
			} else if (expectedStatusCode == 200) {
				if ("update".equalsIgnoreCase(operationType)) {
					Assert.assertTrue("Response body does not contain id", responseBody.contains("batchId"));
					Assert.assertEquals("Response body does not match", expectedJson.toString(), actualJson.toString());
					Assert.assertEquals("Batch Id does not match", batchId, response.jsonPath().getString("batchId"));
				} else if ("DeleteBatchByBatchID".equals(scenarioType));
				{
					Assert.assertTrue("Response body does not contain id", responseBody.contains("deleted Successfully!"));
				}
			}

		} else if (expectedStatusCode == 400) {
			String errorMessage = response.jsonPath().getString("message");

			switch (scenarioType) {

			case "CreateBatchExistingBatchName":
				Assert.assertTrue("Response body does not contain error", errorMessage.contains("already exists"));
				break;

			case "CreateBatchWithMissingData":
				Assert.assertTrue("Response body does not contain error",
						errorMessage.contains("No of Classes is needed; It should be a positive number"));
				break;
			case "CreateBatchWithInValidData":
				Assert.assertTrue("Response body does not contain error",
						errorMessage.contains("Required request body is missing"));
				break;
			case "CreateBatchWithInactiveProgId":
				Assert.assertTrue("Response body does not contain error",
						errorMessage.contains("Batch cannot be created for a Program with Inactive status"));
				break;
			case "UpdateBatchWithMissingData":
				Assert.assertTrue("Response body does not contain error",
						errorMessage.contains("Invalid Status: must be Active or Inactive") 
						|| errorMessage.contains("Batch status is needed"));
				break;
			case "UpdateBatchWithInValidData":
				Assert.assertTrue("Response body does not contain error", errorMessage.contains(
						"batchName Please provide a valid name and must begin with letter and can have letters,numbers and sometimes hyphens"));
				break;
			case "UpdateBatchWithDeletedProgID":
				Assert.assertTrue("Response body does not contain error",
						errorMessage.contains("Batch cannot be updated for a Program with Inactive status"));
				break;
			default:
				throw new RuntimeException("Unhandled scenario type: " + scenarioType);

			}

		} else if (expectedStatusCode == 404) {

			String responseBody = response.getBody().asString();
			switch (scenarioType) {
			case "CreateBatchWithInvalidEndpoint":
			case "UpdateBatchWithInvalidEndpoint":
			case "DeleteBatchWithInvalidEndpoint":
				Assert.assertTrue("Response body does not contain error", responseBody.contains("Invalid endpoint"));
				break;	
			case "UpdateBatchbyInvalidBatchId":
			case "DeleteBatchbyInvalidBatchId":
				String errorMessage = response.jsonPath().getString("message");
				Assert.assertTrue("Response body does not contain error",
						errorMessage.contains("not found"));
				break;
			}

		} else {
			LoggerLoad.info("401 UnAuthorized. No Response Body to validate");
		}

	}

}
