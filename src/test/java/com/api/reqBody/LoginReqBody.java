package com.api.reqBody;
import java.io.IOException;
import com.api.payLoad.LoginPayload;
import com.api.utilities.CommonUtils;
import com.api.utilities.JsonReader;
import io.restassured.response.Response;

public class LoginReqBody extends CommonUtils{
	
	int responseCode =0;	

	private static String token;
	public static Response response;
	// login
	public static void postRequestToGenerateToken() throws IOException {
		JsonReader jsonReaderObj=new JsonReader();
		response = request.body(jsonReaderObj.jsonReader(path.getString("loginJsonFilePath"), "post_positiveLogin")).post(endpoint.getString("login"));
		token = response.jsonPath().getString("token");
		System.out.println("token-->" + token);

	}

	public static String getBearerToken() throws IOException {
		// Generate the token if it does not exist
		if (token == null) {
			postRequestToGenerateToken();
		}
		return token;
		}


}
