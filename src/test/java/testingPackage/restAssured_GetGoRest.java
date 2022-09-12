package testingPackage;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class restAssured_GetGoRest {
	
	public static void main(String[] args) {
	
		
		//get Base URL
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		
		//Create Request Object
		RequestSpecification httpResponse = RestAssured.given();
		
		//response object
		Response kanlayaResponse = httpResponse.request(Method.GET);
		
		System.out.println(kanlayaResponse.then().log().all());
		
		System.out.println(kanlayaResponse.getStatusCode());
		
		Assert.assertEquals(kanlayaResponse.getStatusCode(), 200);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
