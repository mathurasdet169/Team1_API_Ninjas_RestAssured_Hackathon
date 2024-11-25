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
	public static String batchID="8547";
	public static int deletedclassID=111;

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
					LoginReqBody.getBearerToken()).body(jsonReaderObj.class_json_Reader(path.getString("classJsonFilePath"),scenario)).post(endpoint.getString("PostClass"));
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
					LoginReqBody.getBearerToken()).body(jsonReaderObj.class_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+classID);
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
					LoginReqBody.getBearerToken()).body(jsonReaderObj.class_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+endpoint.getString("invalidClassID"));
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
					LoginReqBody.getBearerToken()).body(jsonReaderObj.class_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("invalidEndpoint")+classID);
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
					LoginReqBody.getBearerToken()).body(jsonReaderObj.class_json_Reader(path.getString("classJsonFilePath"),scenario)).post(endpoint.getString("putClassDetails")+classID);
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
					"").body(jsonReaderObj.class_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+classID);
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
			response = request.header("Authorization", "Bearer " + LoginReqBody.getBearerToken()).body(jsonReaderObj.class_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+classID);
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
					LoginReqBody.getBearerToken()).body(jsonReaderObj.class_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+endpoint.getString("deletedBatchID"));
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
					LoginReqBody.getBearerToken()).body(jsonReaderObj.class_json_Reader(path.getString("classJsonFilePath"),scenario)).put(endpoint.getString("putClassDetails")+deletedclassID);
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


	
	public Response deleteClassRecordingByClassID() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).delete(JsonReader.endpoint);

		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public Response deleteClassRecordingByClassID_With_InvalidMethod() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				LoginReqBody.getBearerToken()).post(JsonReader.endpoint);
		System.out.println("--GetClassRecordings-- " + response.statusCode() );
		response.prettyPrint();
		return response;

	}
	public Response deleteClassRecordingByClassID_With_NoAuth() throws IOException {

		if (LoginReqBody.getBearerToken() == null) {
			throw new IllegalStateException("User token has not been generated.");
		}

		response = request.header("Authorization", "Bearer " + 
				" ").delete(JsonReader.endpoint);
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
		}
		return response;
		
	}






}
