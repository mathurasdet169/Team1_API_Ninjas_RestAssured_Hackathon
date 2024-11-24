package com.api.reqBody;
import java.io.IOException;
import java.util.ResourceBundle;
import static io.restassured.RestAssured.given;
import com.api.reqBody.LoginJSONReader;
import com.api.reqBody.LoginReqBody;
import com.api.reqBody.LogoutReqBody;
import com.api.utilities.CommonUtils;
import com.api.utilities.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LogoutReqBody {

	CommonUtils cm=new CommonUtils();
	JsonReader jsonreaderobj=new JsonReader();
	LoginJSONReader loginjsonReaderObj=new LoginJSONReader();
	Response loginResponse;
	RequestSpecification req;
	public static ResourceBundle endpoint = ResourceBundle.getBundle("endpoint");
	String userlogout;
	
	public void CreateGetRequest() {
		userlogout=endpoint.getString("baseUrl")+endpoint.getString("logout");
	}
	
	public void CreateGetForInvalidEndPoint() {
		userlogout=endpoint.getString("baseUrl")+endpoint.getString("Invalid_EndPoint");
	}
	
	public void SendGetRequest() throws IOException {
		req=given()
				.header("Content-Type","application/json")
				.header("Authorization","Bearer " + LoginReqBody.getBearerToken());
		loginResponse=req.when().get(userlogout);
		loginResponse.prettyPrint();
	}
	
	public void statusvalidate() {
		int code=loginResponse.getStatusCode();
		System.out.println("Generated code is:"+code);
	}
	
	public void Unauthorizestatus() {
		if (loginResponse != null) {
			   int code=loginResponse.getStatusCode();
				System.out.println("Generated code is:"+code);
			   }else {
				    System.out.println("Login Response is null. Login is failed as expected.");
			   }
			   
			}
	}
	
	


