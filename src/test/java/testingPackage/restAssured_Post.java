package testingPackage;

import org.json.simple.JSONObject;
import org.junit.Assert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class restAssured_Post {

	public static void main(String[] args) {

		// How to use API POST Method
		// Set base URL
		RestAssured.baseURI = "https://reqres.in/api/users?page1";

		// Creating Request Object
		RequestSpecification httpRequest = RestAssured.given();

		///JsonObject myJson = new JsonObject(); // import from google, dont use it
		 JSONObject myJason2 = new JSONObject();
		
		myJason2.put("page",0);
		myJason2.put("per page",5);
		myJason2.put("total",10);
		myJason2.put("total_page",5);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(myJason2.toJSONString());
		
		Response myResponse = httpRequest.request(Method.POST);
		
		System.out.println(myResponse.then().log().all());
		
		int statusCode = myResponse.getStatusCode();
		
		Assert.assertEquals(statusCode, 201);
		
		
		
		
		
		

	}

}
