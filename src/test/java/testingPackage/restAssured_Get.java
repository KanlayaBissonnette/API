package testingPackage;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class restAssured_Get {

	public static void main(String[] args) {
		
		//How to use API GET Method to get info
		//Set base URL
		RestAssured.baseURI ="https://reqres.in/api/users?page1";
		
		//Creating Request Objectth
		RequestSpecification httpRequest = RestAssured.given();
		
		//response objecct
		Response shafkatResponse = httpRequest.request(Method.GET);
		
		System.out.println(shafkatResponse.then().log().all()); //print out doc as JSON format
		
		System.out.println(shafkatResponse.getStatusCode());
		
		Assert.assertEquals(shafkatResponse.getStatusCode(), 200);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
