package testingPackage;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Trello_DeleteBoard {
	
	public static void main(String[] args) {
		
//                      --url 'https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken'
		RestAssured.baseURI = "https://api.trello.com/1/boards/";
        
        RequestSpecification httpRequest = RestAssured.given();
           
        String key = "edaa5afd151a8eced29954738c38db26";
           
        String accessToken = "e99a044da99ed02c59e0a85ce0269827d08890b1b5f590986163f3e0ce670bef";
        
        String BoardID = "62ad50a6a0289c3fdbe04343"; //This will keep changing as board id you wanna delete
           
        Response myResponse = httpRequest.delete(RestAssured.baseURI + BoardID+ "?key="+ key+"&token="+ accessToken);
        
        System.out.println(myResponse.then().log().all());
        
        Assert.assertEquals(myResponse.getStatusCode(), 200);
		
	}
}
