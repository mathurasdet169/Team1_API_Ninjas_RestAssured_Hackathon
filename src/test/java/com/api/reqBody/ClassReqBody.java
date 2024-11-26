package com.api.reqBody;
import java.io.IOException;

import com.api.payLoad.ClassPayload;
import com.api.utilities.CommonUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ClassReqBody extends CommonUtils {
   // public static int batchId;
    public static Response response;
    public static String batchId="8547";
    public static int csId= 157;
	public static String classTopic="Team 1ninja";
	public static String classStaffId="U49";
	public static String invalidBatchId="gg";
public static String invalidClassId= "cc";
public static String invalidClassTopic="javadff oops";
public static String invalidStaffId="ee";

    // Endpoint variables from configuration
//    String classEndpoint = endpoint.getString("getAllClass");
//    String invalidEndpoint = endpoint.getString("invalidGetAllClass");
//    String invalidBatchIdEndpoint = endpoint.getString("invalidGetAllClass");
//    String classInvalidEndpoint = endpoint.getString("ClasdetailsbyclassidInvalidEp");
//    String invalidClassId = endpoint.getString("Clasdetailsbyinvalidclassid");
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
//    public Response CreateClassWithInvalidBaseUrl(String scenarioType) throws IOException {
//    	String token = LoginReqBody.getBearerToken();
//        if (LoginReqBody.getBearerToken() == null) {
//            throw new IllegalStateException("User token has not been generated.");
//        }
//
//        response = request.header("Authorization", "Bearer " +token)
//                .body(jsonReaderObj.classJsonReader(path.getString("classJsonFilePath"), scenarioType))
//                .post(endpoint.getString("invalidBaseUrl"));
//        System.out.println("--createClassWithInvalidBaseUrl status-- " + response.statusCode());
//        response.prettyPrint();
//        return response;
//    }
    
    public Response CreateClassWithInvalidBaseUrl(String scenarioType) throws IOException {
        // Ensure the token is valid
        String token = LoginReqBody.getBearerToken();
        if (token == null) {
            throw new IllegalStateException("User token has not been generated.");
        }

        //  invalidBaseUrl from the properties file
        String invalidUrl = endpoint.getString("invalidBaseUrl");

        // 
        response = RestAssured.given()
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
//    private void logResponse(String context, Response response) {
//        System.out.println(context + " Status Code: " + response.statusCode());
//        response.prettyPrint();
//    }

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
  
    
}