package com.api.utilities;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;
import java.util.Random;
import java.util.ResourceBundle;

import com.api.payLoad.LoginPayload;
import com.api.reqBody.LoginJSONReader;
import com.api.reqBody.ProgramEditDeleteJSONReader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CommonUtils {
	public static RequestSpecification request;
	public static RequestSpecification userRequest;
	public static ResourceBundle endpoint = ResourceBundle.getBundle("endpoint");	
	public static ResourceBundle path = ResourceBundle.getBundle("path");	
	
	public static JsonReader jsonReaderObj = new JsonReader();
	public static LoginJSONReader loginjsonReaderObj=new LoginJSONReader();
	
	public static void setBaseRequest_withoutBearer() {
		
            request = RestAssured.given()
                    .baseUri(baseURI)
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON);
        } 
		

	public static void setBaseUrl()
	{
		baseURI = endpoint.getString("baseUrl");
	}
	
	
	public static void setBaseRequest_withBearer () throws IOException 
	{		
		String token = LoginPayload.getToken();			
		userRequest = RestAssured.given().log().all().baseUri(baseURI).header("Authorization", "Bearer " + token);
	}
	public static String generateRandomString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            result.append(alphabet.charAt(index));
        }

        return result.toString();
    }
}

