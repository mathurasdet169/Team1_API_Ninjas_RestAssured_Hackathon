package com.api.stepDef;
import java.io.IOException;
import org.testng.Assert;
import com.api.utilities.CommonUtils;

import com.api.reqBody.ClassReqBody;
import com.api.reqBody.LoginReqBody;
import com.api.utilities.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;

public class ClassSteps extends CommonUtils {
    ClassReqBody classreqbodyobj = new ClassReqBody();
    LoginReqBody loginReqBodyObj = new LoginReqBody();
    JsonReader jsonReaderObj = new JsonReader();
    Response response;  // available for all steps

    
//=========================================Create class======================================================//
 
    
    


    
@Given("The admin is logged in successfully into the LMS application")
public void admin_is_logged_in_successfully() {
    // Token or session initialization can be handled here.
    System.out.println("Admin logged in successfully.");
}

//==================================Create Class===============================================//


	@When("Admin sends POST HTTP request for class module with {string} and endpoint")
	public void user_sends_post_http_request_for_class_module_with_and_endpoint(String ScenarioType) throws IOException {

		
//	    if (ScenarioType.equals("CreateClassWithoutAuth "))
//			{
//	    	classreqbodyobj.createClassWithoutAuth(ScenarioType);
//			} else if (ScenarioType.equals("CreateClassWithValidData ") || ScenarioType.equals("CreateClassExistingClassTopic") ||
//			ScenarioType.equals("CreateClassWithMandatoryFieldsOnly ") || ScenarioType.equals(" CreateClassWithAdditionalFieldValues")||
//			ScenarioType.equals("CreateClassWithInvalidData") || ScenarioType.equals("CreateClassWithoutRequestBody"))
//			{
//				classreqbodyobj.createClass(ScenarioType);
//			} else if (ScenarioType.equals("CreateClassWithInvalidEndpoint"))
//				
//			{
//				classreqbodyobj.CreateClassWithInvalidBaseUrl(ScenarioType);
//			}
//				else 
//					System.out.println("Ending all scenarios");
//			
//		}
		
		
		
		  switch (ScenarioType.trim()) {
	        case "CreateClassWithoutAuth":
	            response = classreqbodyobj.createClassWithoutAuth(ScenarioType);
	            break;
	        case "CreateClassWithValidData":
	        case "CreateClassExistingClassTopic":
	        case "CreateClassWithMandatoryFieldsOnly":
	        case "CreateClassWithAdditionalFieldValues":
	        case "CreateClassWithInvalidData":
	        case "CreateClassWithoutRequestBody":
	            response = classreqbodyobj.createClass(ScenarioType);
	            break;
	        case "CreateClassWithInvalidEndpoint":
	            response = classreqbodyobj.CreateClassWithInvalidBaseUrl(ScenarioType);
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid scenario: " + ScenarioType);
	    }
	}

		
		@Then("Admin receives {int} and with response body for all classes for create")
		public void admin_receives_and_with_response_body_for_all_classes_for_create(int  expectedStatusCode) {
	
		
		Assert.assertEquals(response.getStatusCode(),  expectedStatusCode);

	    // Print or verify the response body if necessary
	    System.out.println("Response Body: " + response.getBody().asString());
	}
	//===================================get all class===================================   

		@When("Admin creates GET request for all classes with {string} data")
	public void admin_creates_get_request_for_all_classes_with_data(String scenarioType) throws IOException {
	    try {
			switch (scenarioType) {
			    case "GetAllClassesWithValidEndpoint":
			        response = classreqbodyobj.getAllClassesWithAuth();
			        break;

			    case "GetAllClassesWithoutAuth":
			        response =classreqbodyobj .getAllClassesWithoutAuth();
			        break;

			    case "GetAllClassesInvalidEndpoint":
			        response =classreqbodyobj .getAllClassesWithInvalidEndpoint();
			        break;

			    case "GetAllClassesInvalidMethod":
			        response = classreqbodyobj.getAllClassesWithInvalidMethod();
			        break;

			    default:
			        throw new IllegalArgumentException("Invalid ScenarioType: " + scenarioType);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
//		@Then("Admin receives {int} and with response body for all classes")
//	public void admin_receives_and_with_response_body_for_all_classes(int expectedStatusCode) {
//	Assert.assertEquals(expectedStatusCode, response.getStatusCode());
//	    response.prettyPrint(); 
//	}

	//=============getclassby staffid=========================
	@When("Admin creates GET request for classes by staff ID with {string} data")
	public void admin_creates_get_request_for_classes_by_staff_id_with_data(String scenarioType) throws IOException {
	    switch (scenarioType) {
	        case "GetAllClassesByStaffIdWithoutAuth":
	            response = classreqbodyobj.getAllClassesWithoutAuthByStaffId();
	            break;

	        case "GetAllClassesByStaffIdValidStaffId":
	            response = classreqbodyobj.getAllClassesByValidStaffId();
	            break;

	        case "GetAllClassesByStaffIdInvalidStaffId":
	            response = classreqbodyobj.getAllClassesByInvalidStaffId();
	            break;

	        case "GetAllClassesByStaffIdInvalidEndpoint":
	            response =classreqbodyobj.getAllClassesWithInvalidEndpointByStaffId();
	            break;

	        case "GetAllClassesByStaffIdInvalidMethod":
	            response = classreqbodyobj.getAllClassesWithInvalidMethodByStaffId();
	            break;

	        default:
	            throw new IllegalArgumentException("Invalid ScenarioType: " + scenarioType);
	    }
	}


//	@Then("Admin receives {int} and with response body for all classes by staff ID")
//	public void admin_receives_and_with_response_body_for_all_classes_by_staff_id(int expectedStatusCode) {
//	
//	Assert.assertEquals(expectedStatusCode, response.getStatusCode());
//	   
//	    response.prettyPrint(); 
//	}


	

//=================================================================get class by batch id================================
@When("Admin creates GET request for classes by batch ID with {string} data")
public void admin_creates_get_request_for_classes_by_batch_id_with_data(String scenarioType) throws IOException {
	  switch (scenarioType) {
      case "GetAllClassesByBatchIdWithoutAuth":
          response = classreqbodyobj.getAllClassesWithoutAuthByBatchId();
          break;

      case "GetAllClassesByBatchIdValidBatchId":
          response = classreqbodyobj.getAllClassesByValidBatchId();
          break;

      case "GetAllClassesByBatchIdInvalidBatchId":
          response = classreqbodyobj. getAllClassesByInvalidBatchId();
          break;

      case "GetAllClassesByBatchIdInvalidEndpoint":
          response =classreqbodyobj.getAllClassesWithInvalidEndpointByBatchId();
          break;

      case "GetAllClassesByBatchIdInvalidMethod":
          response = classreqbodyobj.getAllClassesWithInvalidMethodByBatchId();
          break;

      default:
          throw new IllegalArgumentException("Invalid ScenarioType: " + scenarioType);
  }
}


//@Then("Admin receives {int} and with response body for all classes by batch ID")
//public void admin_receives_and_with_response_body_for_all_classes_by_batch_id(int expectedStatusCode) {
//	Assert.assertEquals(expectedStatusCode, response.getStatusCode());
//	   
//    response.prettyPrint(); 
//}



//======================================get class by class topic==================================================================
@When("Admin creates GET request for classes by topic with {string} data")
public void admin_creates_get_request_for_classes_by_topic_with_data(String scenarioType) throws IOException {
   
	switch (scenarioType) {
   
    case "GetClassesByClassTopicWithoutAuth":
        response = classreqbodyobj.getAllClassesbytopicWithoutAuth();
        break;

    
    case "GetClassesByClassTopicValidTopic":
        response = classreqbodyobj.getAllClassesByValidClassTopic();
        break;


    case "GetClassesByClassTopicInvalidTopic":
        response = classreqbodyobj.getAllClassesByInvalidClassTopic();
        break;

    
    case "GetClassesByClassTopicInvalidEndpoint":
        response = classreqbodyobj.getAllClassesBytopicInvalidEndpoint();
        break;

    
    case "GetClassesByClassTopicInvalidMethod":
        response = classreqbodyobj.getAllClassesbytopicWithInvalidMethod();
        break;

   
    default:
        throw new IllegalArgumentException("Invalid ScenarioType: " + scenarioType);
}

}
//@Then("Admin receives {int} and with response body for all classes by topic")
//public void admin_receives_and_with_response_body_for_all_classes_by_topic(int expectedStatusCode) {
//  
//	Assert.assertEquals(expectedStatusCode, response.getStatusCode());
//	   
//    response.prettyPrint(); 
//}



//==============================================get class by class details ============================================================
@When("Admin creates GET request for class details with {string} data")
public void admin_creates_get_request_for_class_details_with_data(String scenarioType) throws IOException {
	switch (scenarioType) {

    case "GetClassDetailsWithoutAuth":
        
        response = classreqbodyobj.getClassDetailsWithoutAuth();
        break;

    case "GetClassDetailsWithValidClassId":
     
        response = classreqbodyobj.getClassDetailsByValidClassId();
        break;

    case "GetClassDetailsInvalidClassId":
        
        response = classreqbodyobj.getClassDetailsByInvalidClassId();
        break;

    case "GetClassDetailsInvalidEndpoint":
      
        response = classreqbodyobj.getClassDetailsWithInvalidEndpoint();
        break;

    case "GetClassDetailsInvalidMethod":
       
        response = classreqbodyobj.getClassDetailsWithInvalidMethod();
        break;

    default:
       
        throw new IllegalArgumentException("Invalid ScenarioType: " + scenarioType);
}

   
}



//@Then("Admin receives {int} and with response body for class details")
//public void admin_receives_and_with_response_body_for_class_details(int expectedStatusCode) {
// 
//
//	Assert.assertEquals(expectedStatusCode, response.getStatusCode());
//	   
//    response.prettyPrint(); 
//}

  

//=====================================getclass by class recording by batchid ==================================================================
@When("Admin creates GET request for class recordings with {string} data")
public void admin_creates_get_request_for_class_recordings_with_data(String scenarioType ) throws IOException{
   
	switch (scenarioType) {

    case "GetClassRecordingsWithoutAuth":
        
        response = classreqbodyobj.getClassRecordingsWithoutAuth();
        break;

    case "GetClassRecordingsWithValidBatchId":
       
        response = classreqbodyobj.getClassRecordingsByValidBatchId();
        break;

    case "GetClassRecordingsInvalidBatchId":
      
        response = classreqbodyobj.getClassRecordingsByInvalidBatchId();
        break;

    case "GetClassRecordingsInvalidEndpoint":
       
        response = classreqbodyobj.getClassRecordingsWithInvalidEndpoint();
        break;

    case "GetClassRecordingsInvalidMethod":
      
        response = classreqbodyobj.getClassRecordingsWithInvalidMethod();
        break;

    default:
       
        throw new IllegalArgumentException("Invalid ScenarioType: " + scenarioType);
}

}
@Then("Admin receives {int} and with response body for all classes")
public void admin_receives_and_with_response_body_for_all_classes (int expectedStatusCode){
		


	Assert.assertEquals(expectedStatusCode, response.getStatusCode());
	   
    response.prettyPrint(); 
}
}

    
