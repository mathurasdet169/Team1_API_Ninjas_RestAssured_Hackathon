package com.api.stepDef;

import java.io.IOException;
import org.testng.Assert;
import com.api.utilities.*;
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

    @Given("The admin is logged in successfully into the LMS application")
    public void the_admin_is_logged_in_successfully_into_the_lms_application() throws IOException {
        // Log in and generate the token
        loginReqBodyObj.postRequestToGenerateToken();
    }

    @Given("Admin creates GET Request for {string}")
    public void admin_creates_request_for(String scenario) {
        // jsonReaderObj gets the endpoint and status code for scenario
        try {
            jsonReaderObj.login_json_Reader(path.getString("loginJsonFilePath"), scenario);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Request created for scenario: " + scenario);
    }


    @When("Admin sends HTTPS {string} with {string}")
    public void admin_sends_https_with(String methodType, String endpoint) throws IOException {
        // Based on scenario, send the appropriate request.
        if (JsonReader.EXP_STATUSCODE == 405) {
            response = classreqbodyobj.getAllClassesWithInvalidMethod();  // Invalid Method
        } else if (JsonReader.EXP_STATUSCODE == 401) {
            response = classreqbodyobj.getAllClassesWithoutAuth();  //no auth
        } else if (JsonReader.EXP_STATUSCODE == 404) {
            response = classreqbodyobj.getAllClassesWithInvalidEndpoint();  // invalidendpoint
        } else {
            response = classreqbodyobj.getAllClassesWithAuth();  // Valid Authorization
        }

        // Print response for debugging
        System.out.println("Response Status Code: " + response.getStatusCode());
    }

    @Then("Admin receives {int} and {string} with response body.")
    public void admin_receives_and_with_response_body(Integer expectedStatusCode, String expectedMessage) {
//        // Assert that the actual status code matches the expected one
//        Assert.assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch!");
//
//        // Assert that the response body contains the expected message
//        String actualResponseBody = response.getBody().asString();
//        Assert.assertTrue(actualResponseBody.contains(expectedMessage), 
//                          "Expected message not found! Actual response body: " + actualResponseBody);
//    }

    	
 	
    	
    	Assert.assertEquals(JsonReader.EXP_STATUSCODE,response.getStatusCode());
    }
		
	

}
