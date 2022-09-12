package testingPackage;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class restAssured_PostGoRest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		RestAssured.baseURI ="https://gorest.co.in/public/v2/users";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject myJson = new JSONObject();
		
		myJson.put("id", 3177);
		myJson.put("name", "Kalinda Pandey");
		myJson.put("email", "kalinda_pandey@harvey-weber.info");
		myJson.put("gender", "female");
		myJson.put("status","active");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(myJson.toJSONString());
		
		Response myResponse = httpRequest.request(Method.POST);
		
		System.out.println(myResponse.then().log().all());
		
		int statusCode = myResponse.getStatusCode();
		
		Assert.assertEquals(statusCode, 201);
		
		
		
		
		

	}

}
