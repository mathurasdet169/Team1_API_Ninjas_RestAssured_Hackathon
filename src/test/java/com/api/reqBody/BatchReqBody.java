package com.api.reqBody;

import java.io.File;
import java.io.IOException;

import org.json.JSONObject;
import org.junit.Assert;

import com.api.payLoad.BatchPayload;

import com.api.utilities.CommonUtils;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class BatchReqBody extends CommonUtils {

	public static String batchId;
	public static String batchName;
	public static String programId;

	public Response createBatchWithoutAuth(String scenarioType) throws IOException {

		response = request.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.post(endpoint.getString("createBatch"));
		System.out.println("--createBatchWithoutAuth status--" + response.statusCode());
		response.prettyPrint();
		return response;
	}

	public Response createBatch(String scenarioType) throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.post(endpoint.getString("createBatch"));
		System.out.println("--createBatch status-- " + response.statusCode());
		response.prettyPrint();
		if (response.statusCode() == 201) {
			batchId = response.jsonPath().getString("batchId");
			batchName = response.jsonPath().getString("batchName");
			programId = response.jsonPath().getString("programId");
			// batchPayload.setBatchId(batchId);
			System.out.println("batchId---->" + batchId);
			System.out.println("batchName---->" + batchName);
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
		System.out.println("--createBatchWithInvalidEndpoint status-- " + response.statusCode());
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
		System.out.println("--updateByBatchId-- " + response.statusCode());
		response.prettyPrint();
		return response;

	}

	public Response updateBatchByBatchIdWithoutAuth(String scenarioType) throws IOException {

		response = request.body(jsonReaderObj.batch_json_Reader(path.getString("batchJsonFilePath"), scenarioType))
				.put(endpoint.getString("updateByBatchId") + batchId);
		System.out.println("--updateBatchByBatchIdWithoutAuth-- " + response.statusCode());
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
		System.out.println("--updateByBatchId-- " + response.statusCode());
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
		System.out.println("--updateBatchByInvalidEndPoint-- " + response.statusCode());
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
		System.out.println("--updateBatchByDeletedBatchID-- " + response.statusCode());
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

	public Response getAllBatchesWithoutauth() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.get(endpoint.getString("getAllBatches"));
		return response;

	}

	public Response getAllBatchesWithInvalidEndpoint() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("invalidEndPoint"));
		return response;

	}

	public Response getBatchesWithSearchString() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.queryParam("batchId", batchId).get(endpoint.getString("getAllBatches"));
		return response;

	}

	public Response getBatchByBatchId() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("getBatchByBatchId") + batchId);
		return response;

	}

	public Response getBatchByBatchIdWithoutAuth() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.get(endpoint.getString("getBatchByBatchId") + batchId);
		return response;

	}

	public Response getBatchByDeletedBatchId() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("getBatchByBatchId") + endpoint.getString("deletedBatchId"));
		return response;

	}

	public Response getBatchByInvalidBatchId() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("getBatchByBatchId") + endpoint.getString("invalidBatchId"));
		return response;

	}

	public Response getBatchByInvalidEndpoint() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("invalidEndPoint"));
		return response;

	}

	public Response getBatchByBatchName() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("getBatchByBatchName") + batchName);
		return response;

	}

	public Response getBatchByBatchNameWithoutAuth() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.get(endpoint.getString("getBatchByBatchName") + batchName);
		return response;

	}

	public Response getBatchByDeletedBatchName() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("getBatchByBatchName") + endpoint.getString("deletedBatchName"));
		return response;

	}

	public Response getBatchByInvalidBatchName() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("getBatchByBatchName") + endpoint.getString("invalidBatchName"));
		return response;

	}

	public Response getBatchByProgId() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("getBatchByProgId") + programId);
		return response;

	}

	public Response getBatchByProgIdWithoutAuth() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.get(endpoint.getString("getBatchByProgId") + programId);
		return response;

	}

	public Response getBatchByDeletedProgId() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("getBatchByProgId") + endpoint.getString("deletedProgId"));
		return response;

	}

	public Response getBatchByInvalidProgId() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.get(endpoint.getString("getBatchByProgId") + endpoint.getString("invalidBatchId"));
		return response;

	}

	public Response deleteBatchByBatchID() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.delete(endpoint.getString("deleteBatch") + batchId);
		System.out.println("--deleteBatchByBatchID-- " + response.statusCode());
		response.prettyPrint();
		return response;
	}

	public Response deleteBatchWithInvalidEndpoint() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.delete(endpoint.getString("invalidEndPoint") + batchId);
		System.out.println("--deleteBatchWithInvalidEndpoint-- " + response.statusCode());
		response.prettyPrint();
		return response;
	}

	public Response deleteBatchByInvalidBatchId() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
				.delete(endpoint.getString("deleteBatch") + endpoint.getString("invalidBatchId"));
		System.out.println("--deleteBatchByInvalidBatchId-- " + response.statusCode());
		response.prettyPrint();
		return response;
	}

	public Response deleteBatchWithoutAuth() throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.delete(endpoint.getString("deleteBatch") + batchId);
		System.out.println("--DeleteBatchWithoutAuth-- " + response.statusCode());
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
				} else if ("DeleteBatchByBatchID".equals(scenarioType)) {
					Assert.assertTrue("Response body does not contain id",
							responseBody.contains("deleted Successfully!"));
				} else if ("getByBatchId".equalsIgnoreCase(operationType)) {
					Assert.assertEquals("Batch Id does not match", batchId, response.jsonPath().getString("batchId"));
				} else if ("getByBatchName".equalsIgnoreCase(operationType)) {
					Assert.assertEquals("Batch Name does not match", batchName,
							response.jsonPath().getString("batchName"));
				} else if ("getByProgId".equalsIgnoreCase(operationType)) {
					Assert.assertEquals("Batch Name does not match", programId,
							response.jsonPath().getString("programId"));
				}
			}

			else if (expectedStatusCode == 400) {
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

				// String responseBody = response.getBody().asString();
				switch (scenarioType) {
				case "CreateBatchWithInvalidEndpoint":
				case "UpdateBatchWithInvalidEndpoint":
				case "DeleteBatchWithInvalidEndpoint":
				case "GetAllBatchesWithInvalidEndpoint":
				case "GetBatchWithInvalidEndpoint":
					Assert.assertTrue("Response body does not contain error",
							responseBody.contains("Invalid endpoint"));
					break;
				case "UpdateBatchbyInvalidBatchId":
				case "DeleteBatchbyInvalidBatchId":
				case "GetBatchWithInvalidBatchId":
				case "GetBatchWithInvalidBatchName":
				case "GetBatchWithInvalidProgId":
					String errorMessage = response.jsonPath().getString("message");
					Assert.assertTrue("Response body does not contain error", errorMessage.contains("not found"));
					break;
				}

			} else
				System.out.println("401 UnAuthorized. No Response Body to validate");

		}

	}
	
	public void validateResponseSchema(String schemaFilePath ) {
		File schemaFile = new File(schemaFilePath);
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schemaFile));	
	}
}
