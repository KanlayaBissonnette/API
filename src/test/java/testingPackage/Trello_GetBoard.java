package testingPackage;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Trello_GetBoard {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://api.trello.com/1/members/me/boards";
        
        RequestSpecification httpRequest = RestAssured.given();
           
        String key = "edaa5afd151a8eced29954738c38db26";
           
        String accessToken = "e99a044da99ed02c59e0a85ce0269827d08890b1b5f590986163f3e0ce670bef";
           
        Response myResponse = httpRequest.get(RestAssured.baseURI+"?key="+key+"&token="+accessToken);
        
        System.out.println(myResponse.then().log().all());
        
        Assert.assertEquals(myResponse.getStatusCode(), 200);
           
		
		
		
		
		
	}

}
