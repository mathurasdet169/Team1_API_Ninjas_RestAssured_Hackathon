package com.api.reqBody;

import com.api.utilities.CommonUtils;
import com.api.utilities.JsonReader;

import io.restassured.response.Response;

import java.io.IOException;

import com.api.payLoad.*;

public class ClassReqBody extends CommonUtils {

	public static Response response;
	static JsonReader jsonReaderObj=new JsonReader();
	public static int classID=157;
	public static String batchId="8547";
	public static int deletedclassID=111;
	
	 public static int csId= 157;
		public static String classTopic="Team 1ninja";
		public static String classStaffId="U49";
		public static String invalidBatchId="gg";
	public static String invalidClassId= "cc";
	public static String invalidClassTopic="javadff oops";
	public static String invalidStaffId="ee";

	    // Endpoint variables from configuration
//	    String classEndpoint = endpoint.getString("getAllClass");
//	    String invalidEndpoint = endpoint.getString("invalidGetAllClass");
//	    String invalidBatchIdEndpoint = endpoint.getString("invalidGetAllClass");
//	    String classInvalidEndpoint = endpoint.getString("ClasdetailsbyclassidInvalidEp");
//	    String invalidClassId = endpoint.getString("Clasdetailsbyinvalidclassid");
	  //  String createClass = endpoint.getString("createNewClass");
	   // String invalidNewClassEndpoint = endpoint.getString("InvalidCreateEndpoint");

	    // ============================ Request Body Creation ============================
	    //String classJson = jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), scenarioType);



	    public Response createClass(String ScenarioType) throws IOException {
	    	  String token = LoginReqBody.getBearerToken();
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }
	        //ClassPayload.setBatchId("12345"); 
	        response = request.header("Authorization", "Bearer " +  token)
	                .body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), ScenarioType))
	                .post(endpoint.getString("createNewClass"));
	        System.out.println("--createClass status-- " + response.statusCode());
	        response.prettyPrint();
	        if (response.statusCode() == 201) {
	        	
	         
	        	csId = response.jsonPath().getInt("csId");
	        	classTopic = response.jsonPath().getString("classTopic");
	        	classStaffId= response.jsonPath().getString("classStaffId");
				
				System.out.println("csId---->" + csId);
				System.out.println("classTopic---->" + classTopic);
				System.out.println("classStaffId---->" + classStaffId);
			}
	        return response;
	    }

	    public Response createClassWithInvalidEndpoint(String ScenarioType) throws IOException {
	    	String token = LoginReqBody.getBearerToken();
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + token)
	                .body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), ScenarioType))
	                .post(endpoint.getString("InvalidCreateEndpoint"));
	        System.out.println("--createClassWithInvalidEndpoint status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	    public Response createClassWithoutRequestBody(String ScenarioType) throws IOException {
	    	String token = LoginReqBody.getBearerToken();
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " +token)
	                .body("") // Empty body
	                .post(endpoint.getString("createNewClass"));
	        System.out.println("--createClassWithoutRequestBody status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	    public Response createClassWithoutAuth(String ScenarioType) throws IOException {
	        response = request.header("Authorization", "Bearer " +"") // no token 
	                .body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), ScenarioType))
	                .post(endpoint.getString("createNewClass"));
	        System.out.println("--createClassWithoutAuth status-- " + response.statusCode());
	        System.out.println("--File Path-- " + path.getString("classJsonFilePath"));
	        response.prettyPrint();
	        return response;
	    }

	    public Response createClassWithInvalidData(String ScenarioType) throws IOException {
	    	String token = LoginReqBody.getBearerToken();
	    	
	    	
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + token)
	                .body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), ScenarioType))
	                .post(endpoint.getString("createNewClass"));
	        System.out.println("--createClassWithInvalidData status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	    public Response createClassWithAdditionalFieldValues(String ScenarioType) throws IOException {
	    	String token = LoginReqBody.getBearerToken();
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + token)
	                .body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), ScenarioType))
	                .post(endpoint.getString("createNewClass"));
	        System.out.println("--createClassWithAdditionalFieldValues status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	    public Response createClassWithMandatoryFieldsOnly(String ScenarioType) throws IOException {
	    	String token = LoginReqBody.getBearerToken();
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + token)
	                .body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), ScenarioType))
	                .post(endpoint.getString("createNewClass"));
	        System.out.println("--createClassWithMandatoryFieldsOnly status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }  public Response createClassWithExistingClassTopic(String scenarioType) throws IOException {
	    	String token = LoginReqBody.getBearerToken();
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + token)
	                .body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), scenarioType))
	                .post(endpoint.getString("createNewClass"));
	        System.out.println("--createClassWithExistingClassTopic status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
//	    public Response CreateClassWithInvalidBaseUrl(String scenarioType) throws IOException {
//	    	String token = LoginReqBody.getBearerToken();
//	        if (LoginReqBody.getBearerToken() == null) {
//	            throw new IllegalStateException("User token has not been generated.");
//	        }
	//
//	        response = request.header("Authorization", "Bearer " +token)
//	                .body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), scenarioType))
//	                .post(endpoint.getString("invalidBaseUrl"));
//	        System.out.println("--createClassWithInvalidBaseUrl status-- " + response.statusCode());
//	        response.prettyPrint();
//	        return response;
//	    }
	    
	    public Response CreateClassWithInvalidBaseUrl(String scenarioType) throws IOException {
	        // Ensure the token is valid
	        String token = LoginReqBody.getBearerToken();
	        if (token == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        //  invalidBaseUrl from the properties file
	        String invalidUrl = endpoint.getString("invalidBaseUrl");

	        // 
	        response = request.given()
	                .baseUri(invalidUrl)  // invalid base URI 
	                .header("Authorization", "Bearer " + token)  //  Bearer token
	                .header("Content-Type", "application/json")  //  Content-Type
	                .body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), scenarioType))  //  request body
	                .post(endpoint.getString("createNewClass"));  

	        // Log the response
	        System.out.println("--createClassWithInvalidBaseUrl status-- " + response.statusCode());
	        response.prettyPrint();

	        return response;
	    }



	//=================================================get classdetails by classid ===================================================================
	    public Response getClassDetailsByValidClassId() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("getClassDetailsEndpoint")+ csId);
	        System.out.println("--getClassDetailsByValidClassId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalid classid 
	    public Response getClassDetailsByInvalidClassId() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("getClassDetailsEndpoint")  + invalidClassId);
	        System.out.println("--getClassDetailsByInvalidClassId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalid endpoint 
	    
	    public Response getClassDetailsWithInvalidEndpoint() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("invalidGetClassDetailsEndpoint") + csId);
	        System.out.println("--getClassDetailsWithInvalidEndpoint status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalid method
	    public Response getClassDetailsWithInvalidMethod() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .post(endpoint.getString("getClassDetailsEndpoint")  + csId); // Using POST instead of GET
	        System.out.println("--getClassDetailsWithInvalidMethod status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//no auth
	    public Response getClassDetailsWithoutAuth() throws IOException {
	    response = request.header("Authorization", "Bearer " + "")
	    		
	    		.get(endpoint.getString("getClassDetailsEndpoint") + csId);
	    System.out.println("--getClassDetailsWithoutAuth status-- " + response.statusCode());
	    response.prettyPrint();
	    return response;
	    }
	    //============================================================get class by classtopic=================================
	    
	    public Response getAllClassesByValidClassTopic() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("getAllClassesEndpointbytopic")  + classTopic);
	        System.out.println("--getAllClassesByValidClassTopic status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalid classtopic
	    
	    public Response getAllClassesByInvalidClassTopic() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("getAllClassesEndpointbytopic")  + invalidClassTopic);
	        System.out.println("--getAllClassesByInvalidClassTopic status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalid endpoint
	    public Response getAllClassesBytopicInvalidEndpoint() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("getclassbyinvalidtopic") +classTopic);
	        System.out.println("--getAllClassesWithInvalidEndpoint status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalid method
	    public Response getAllClassesbytopicWithInvalidMethod() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .post(endpoint.getString("getAllClassesEndpointbytopic")+ classTopic); // Using POST instead of GET
	        System.out.println("--getAllClassesWithInvalidMethod status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//no auth 
	    public Response getAllClassesbytopicWithoutAuth() throws IOException {
	        response = request.header("Authorization", "Bearer " + "")
	        		
	        		.get(endpoint.getString("getAllClassesEndpointbytopic")+ classTopic);
	        System.out.println("--getAllClassesWithoutAuth status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//==============================================getclass by batchid======================================//
	    public Response getAllClassesByValidBatchId() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("getAllClassesByBatchIdEndpoint")  + batchId);
	        System.out.println("--getAllClassesByValidBatchId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalidbatchid
	    public Response getAllClassesByInvalidBatchId() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("getAllClassesByBatchIdEndpoint")+ invalidBatchId);
	        System.out.println("--getAllClassesByInvalidBatchId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }

	//invalidendpoint
	    public Response getAllClassesWithInvalidEndpointByBatchId() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("invalidGetAllClassesByBatchIdEndpoint")  + batchId);
	        System.out.println("--getAllClassesWithInvalidEndpointByBatchId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalid http 
	    public Response getAllClassesWithInvalidMethodByBatchId() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .post(endpoint.getString("getAllClassesByBatchIdEndpoint") + batchId); // Using POST instead of GET
	        System.out.println("--getAllClassesWithInvalidMethodByBatchId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//no auth 
	    public Response getAllClassesWithoutAuthByBatchId() throws IOException {
	        response = request.get(endpoint.getString("getAllClassesByBatchIdEndpoint")  + batchId);
	        System.out.println("--getAllClassesWithoutAuthByBatchId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//=================================================get class by staffid===================================
	    public Response getAllClassesByValidStaffId() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("getAllClassesByStaffIdEndpoint") + classStaffId);
	        System.out.println("--getAllClassesByValidStaffId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalid staffid
	    public Response getAllClassesByInvalidStaffId() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("getAllClassesByStaffIdEndpoint")  + invalidStaffId);
	        System.out.println("--getAllClassesByInvalidStaffId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalid endpoint
	    public Response getAllClassesWithInvalidEndpointByStaffId() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("invalidGetAllClassesByStaffIdEndpoint") + classStaffId);
	        System.out.println("--getAllClassesWithInvalidEndpointByStaffId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//invalid http 
	    public Response getAllClassesWithInvalidMethodByStaffId() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .post(endpoint.getString("getAllClassesByStaffIdEndpoint") + classStaffId); // Using POST instead of GET
	        System.out.println("--getAllClassesWithInvalidMethodByStaffId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }
	//no auth
	    public Response getAllClassesWithoutAuthByStaffId() throws IOException {
	        response = request.get(endpoint.getString("getAllClassesByStaffIdEndpoint")  + classStaffId);
	        System.out.println("--getAllClassesWithoutAuthByStaffId status-- " + response.statusCode());
	        response.prettyPrint();
	        return response;
	    }

	//==================================================get all class==================================//
	 // Get All Classes with Auth
	    public Response getAllClassesWithAuth() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("getAllClassesEndpoint")); 
	        System.out.println("--Get All Classes with Auth-- " + response.statusCode()); // Fixed concatenation
	        return response;
	    }


	    // Get All Classes with Invalid Endpoint
	    public Response getAllClassesWithInvalidEndpoint() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .get(endpoint.getString("invalidGetAllClassesEndpoint"));
	        System.out.println("--Get All Classes with Invalid Endpoint--"+ response.statusCode());
	        return response;
	    }

	    // Get All Classes with Invalid Method
	    public Response getAllClassesWithInvalidMethod() throws IOException {
	        if (LoginReqBody.getBearerToken() == null) {
	            throw new IllegalStateException("User token has not been generated.");
	        }

	        response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	                .post(endpoint.getString("getAllClassesEndpoint")); // POST instead of GET
	        System.out.println("--Get All Classes with Invalid Method--"+ response.statusCode());
	        return response;
	    }

	    // Get All Classes without Auth
	    public Response getAllClassesWithoutAuth() throws IOException {
	        response = request.get(endpoint.getString("getAllClassesEndpoint")); // No Authorization 
	        System.out.println("--Get All Classes without Auth--"+ response.statusCode());
	        return response;
	    }

	    // Log the Response
//	    private void logResponse(String context, Response response) {
//	        System.out.println(context + " Status Code: " + response.statusCode());
//	        response.prettyPrint();
//	    }

	//======================================get class recodring by batchid======================================
	    public Response getClassRecordingsWithoutAuth() throws IOException {
	    	
	    	
	    	response = request
	    			.get(endpoint.getString("getClassRecordingsEndpoint") + batchId); // No Authorization 
	        System.out.println("--Get All Classes without Auth--"+ response.statusCode());
	        return response;
	    
	     
	    }

	    // Get class recordings with a valid batch ID
	    public Response getClassRecordingsByValidBatchId() throws IOException {
	    	response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	    			.get(endpoint.getString("getClassRecordingsEndpoint") + batchId); 
	        System.out.println("--Get All Classes without Auth--"+ response.statusCode());
	        return response;
	    }

	    // Get class recordings with an invalid batch ID
	    public Response getClassRecordingsByInvalidBatchId() throws IOException {
	    	response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	    			.get(endpoint.getString("getClassRecordingsEndpoint") + invalidBatchId); 
	        System.out.println("--Get All Classes without Auth--"+ response.statusCode());
	        return response;
	    }
	    // Get class recordings with an invalid endpoint
	    public Response getClassRecordingsWithInvalidEndpoint() throws IOException {
	    	response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	    			.get(endpoint.getString("InvalidgetClassRecordingsEndpoint") + batchId); 
	        System.out.println("--Get All Classes without Auth--"+ response.statusCode());
	        return response;
	    }
	    // Get class recordings with an invalid method (e.g., POST instead of GET)
	    public Response getClassRecordingsWithInvalidMethod() throws IOException {
	    	response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken())
	    			.post(endpoint.getString("getClassRecordingsEndpoint") + batchId); 
	        System.out.println("--Get All Classes without Auth--"+ response.statusCode());
	        return response;
	    }
	 

	public static Response getGetAllClassRecording() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).get(endpoint.getString("GetAllClassRecording_ValidEndpoint"));

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static Response getGetAllClassRecordingWithInvalidMethod() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).post(endpoint.getString("GetAllClassRecording_ValidEndpoint"));
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static Response getGetAllClassRecordingNoAuth() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				" ").get(endpoint.getString("GetAllClassRecording_ValidEndpoint"));
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}

	//---------GET Class Recordings By ClassID----------//

	public static Response getClassRecordingByClassID() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).get(endpoint.getString("GetAllClassRecordingID_ValidEndpoint")+"157");

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static Response getClassRecordingByInValidClassID() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).get(endpoint.getString("GetAllClassRecordingID_ValidEndpoint")+endpoint.getString("invalidClassID"));

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}

	public static Response getClassRecordingByClassID_With_InvalidMethod() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).post(endpoint.getString("GetAllClassRecordingID_ValidEndpoint")+"157");
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static  Response getClassRecordingByClassID_With_NoAuth() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				" ").get(endpoint.getString("GetAllClassRecordingID_ValidEndpoint")+"157");
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	
	public static Response getClassRecordingByClassID_InvalidEndpoint() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				" ").get(endpoint.getString("invalidEndpoint")+"/157");
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}

	
	/*---------------------GET CLassRecordingDownload----------------------*/
	
	
	public static Response getClassRecording_Download_ClassID() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).get(endpoint.getString("downloadRec")+"157");

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	
	public static Response getClassRecording_Download_InValidClassID() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).get(endpoint.getString("downloadRec")+endpoint.getString("invalidClassID"));

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}

	
	public static Response getClassRecordingDownload_With_InvalidMethod() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).post(endpoint.getString("downloadRec")+"157");
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static Response getClassRecordingDownload_With_NoAuth() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				" ").get(endpoint.getString("downloadRec")+"157");
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	
	
	public static Response getClassRecordingWith_InvalidEndpoint() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				" ").get(endpoint.getString("invalidEndpoint")+"157");
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	
	/*-----------------------------GET UPCOMING CLASSES BY STUDENT ID--------------------------------------------*/

/*---------------------GET CLassRecordingDownload----------------------*/
	
	
	public static Response Get_UpcomingClasses_StudentID() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).get(endpoint.getString("GetUpcomingClasses")+"U71");

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	
	public static Response Get_UpcomingClasses_InValidStudentID() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).get(endpoint.getString("GetUpcomingClasses")+endpoint.getString("invalidClassID"));

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}

	
	public static Response Get_UpcomingClassesByStudentID_InvalidEndpoint() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).get(endpoint.getString("invalidEndpoint")+"U71");
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static Response Get_UpcomingClassesByStudentID_InvalidMethod() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " +
		LoginReqBody.getBearerToken()).post(endpoint.getString("GetUpcomingClasses")+"U71");
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	
	
	public static Response Get_UpcomingClassesByStudentID_NoAuth() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				" ").get(endpoint.getString("GetUpcomingClasses")+"U71");
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}

/*---------------------POST CLASS---------------------------------*/
	public  Response postClassDetails(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		//jsonReaderObj.jsonReader(path.getString("classJsonFilePath"), "CreateClassWithValidData")
		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"),scenario)).post(endpoint.getString("PostClass"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}



	/*----------------------------UPDATE CLASS DETAILS---------------------------*/

	public static  Response putClassDetailsByClassID(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+classID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static  Response Put_ClassDetails_With_InValidClassID(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+endpoint.getString("invalidClassID"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	
	public static  Response Put_ClassDetails_With_InvalidEndpoint(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("invalidEndpoint")+classID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}

	public static  Response Put_ClassDetails_With_InvalidMethod(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"),scenario)).post(endpoint.getString("putClassDetails")+classID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static  Response Put_ClassDetails_With_NoAuth(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					"").body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+classID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static  Response Put_ClassDetails_MissingMandtoryFields(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken()).body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+classID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static  Response Put_ClassDetails_With_DeletedBatchID(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+endpoint.getString("deletedBatchID"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	
	public static  Response Put_ClassDetails_With_DeletedClassID(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+deletedclassID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	
	/*----------Update class recordings--------*/
	
	public static  Response Put_ClassRecordings_ValidClassID(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classUpdateRecording_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassRecording")+classID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static  Response Put_ClassRecordings_InValidClassID(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classUpdateRecording_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassRecording")+endpoint.getString("invalidClassID"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	
	public static  Response Put_ClassRecordings_With_InvalidEndpoint(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classUpdateRecording_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("invalidEndpoint")+classID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}

	public static  Response Put_Classrecordings_With_InvalidMethod(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classUpdateRecording_json_Reader(path.getString("classJsonFilePath"),scenario)).post(endpoint.getString("putClassRecording")+classID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static  Response Put_ClassRecordings_With_NoAuth(String scenario) throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					"").body(jsonReaderObj.classUpdateRecording_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassRecording")+classID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static  Response Put_ClassRecordings_InvalidData(String scenario) throws IOException {
		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		try {
			response = request.header("Authorization", "Bearer " + 
					LoginReqBody.getBearerToken()).body(jsonReaderObj.classUpdateRecording_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassRecording")+classID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}

	
	/*-----------------------------------------Delete---------------*/


	
	public static Response Delete_ClassDetails_With_ValidClassID() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).delete(endpoint.getString("deleteClass")+classID);

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static Response Delete_ClassDetails_With_InValidClassID() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).delete(endpoint.getString("deleteClass")+endpoint.getString("invalidClassID"));

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static Response Delete_ClassDetails_With_InValidEndpoint() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).delete(endpoint.getString("invalidEndpoint")+classID);

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}

	
	public static Response Delete_ClassDetails_With_InValidMethod() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).post(endpoint.getString("deleteClass")+classID);
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static Response Delete_ClassDetails_With_NoAuth() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				" ").delete(endpoint.getString("deleteClass")+classID);
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public static Response getRequest(String scenario) throws IOException {
		
		switch(scenario){
		
		case "Get_AllClassRecordings_With_ValidEndpoint":
			response=getGetAllClassRecording();
			break;
			
		case "Get_AllClassRecordings_With_InValidEndpoint":
			response=getClassRecordingWith_InvalidEndpoint();
			break;
		
		case "Get_AllClassRecordings_With_InValidMethod":
			response=getGetAllClassRecordingWithInvalidMethod();
			break;
			
		case "Get_AllClassRecordings_With_NoAuth":
			response=getGetAllClassRecordingNoAuth();
			break;
		
		case "Get_ClassRecordingByClassID_With_ValidClassID":
			response=getClassRecordingByClassID();
			break;
			
		case "Get_ClassRecordingByClassID_With_InValidClassID":
			response=getClassRecordingByInValidClassID();
			break;
		
		case "Get_ClassRecordingByClassID_With_InvalidEndpoint":
			response=getClassRecordingByClassID_InvalidEndpoint();
			break;
		
		case "Get_ClassRecordingByClassID_With_InvalidMethod":
			response=getClassRecordingByClassID_With_InvalidMethod();
			break;
		
		case "Get_ClassRecordingByClassID_With_NoAuth":
			response=getClassRecordingByClassID_With_NoAuth();
			break;
		
			
			
			case "Get_ClassRecordingDownload_With_ValidClassID":
				response=getClassRecording_Download_ClassID();
				break;
				
			case "Get_ClassRecordingDownload_With_InValidClassID":
				response=getClassRecording_Download_InValidClassID();
				break;
		
			case "Get_ClassRecordingDownload_With_InvalidEndpoint":
				response=getClassRecordingWith_InvalidEndpoint();
				break;
		
			case "Get_ClassRecordingDownload_With_InvalidMethod":
				response=getClassRecordingDownload_With_InvalidMethod();
				break;
		
			case "Get_ClassRecordingDownload_With_NoAuth":
				response=getClassRecordingDownload_With_NoAuth();
				break;
		
			case "Get_UpcomingClasses_StudentID":
				response=Get_UpcomingClasses_StudentID();
				break;
		
			case "Get_UpcomingClasses_InValidStudentID":
				response=Get_UpcomingClasses_InValidStudentID();
				break;
		
			case "Get_UpcomingClassesByStudentID_InvalidEndpoint":
				response=Get_UpcomingClassesByStudentID_InvalidEndpoint();
				break;
		
			case "Get_UpcomingClassesByStudentID_InvalidMethod":
				response=Get_UpcomingClassesByStudentID_InvalidMethod();
				break;
		
			case "Get_UpcomingClassesByStudentID_NoAuth":
				response=Get_UpcomingClassesByStudentID_NoAuth();
				break;
				//put	
			case "Put_ClassDetails_With_ValidClassID":
				response=putClassDetailsByClassID(scenario);
				break;
				
			case "Put_ClassDetails_With_InValidClassID":
				response=Put_ClassDetails_With_InValidClassID(scenario);
				break;		
			case "Put_ClassDetails_With_InvalidEndpoint":
				response=Put_ClassDetails_With_InvalidEndpoint(scenario);
				break;
			case "Put_ClassDetails_With_InvalidMethod":
				response=Put_ClassDetails_With_InvalidMethod(scenario);
				break;				
			case "Put_ClassDetails_With_NoAuth":
				response=Put_ClassDetails_With_NoAuth(scenario);
				break;			
			case "Put_ClassDetails_MissingMandtoryFields":
				response=Put_ClassDetails_MissingMandtoryFields(scenario);
				break;		
			case "Put_ClassDetails_With_DeletedBatchID":
				response=Put_ClassDetails_With_DeletedBatchID(scenario);
				break;			
			case "Put_ClassDetails_With_DeletedClassID":
				response=Put_ClassDetails_With_DeletedClassID(scenario);
				break;		
			case "Put_ClassRecordings_ValidClassID":
				response=Put_ClassRecordings_ValidClassID(scenario);
				break;
				
			case "Put_ClassRecordings_InValidClassID":
				response=Put_ClassRecordings_InValidClassID(scenario);
				break;		
			case "Put_ClassRecordings_With_InvalidEndpoint":
				response=Put_ClassRecordings_With_InvalidEndpoint(scenario);
				break;
			case "Put_Classrecordings_With_InvalidMethod":
				response=Put_Classrecordings_With_InvalidMethod(scenario);
				break;				
			case "Put_ClassRecordings_With_NoAuth":
				response=Put_ClassRecordings_With_NoAuth(scenario);
				break;			
			case "Put_ClassRecordings_InvalidData":
				response=Put_ClassRecordings_InvalidData(scenario);
				break;		
			case "Delete_ClassDetails_With_ValidClassID":
				response=Delete_ClassDetails_With_ValidClassID();
				break;
				
			case "Delete_ClassDetails_With_InValidClassID":
				response=Delete_ClassDetails_With_InValidClassID();
				break;		
			case "Delete_ClassDetails_With_InValidEndpoint":
				response=Delete_ClassDetails_With_InValidEndpoint();
				break;
			case "Delete_ClassDetails_With_InValidMethod":
				response=Delete_ClassDetails_With_InValidMethod();
				break;				
			case "Delete_ClassDetails_With_NoAuth":
				response=Delete_ClassDetails_With_NoAuth();
				break;			
							
			
		}
		return response;
		
	}






}
