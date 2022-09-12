package testingPackage;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Trello_POST_Board {

	public static void main(String[] args) {

//		 --url 'https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken'
//		RestAssured.baseURI = "https://api.trello.com/1/boards/";
//		RequestSpecification httpRequest = RestAssured.given();
//		
//		String key = "edaa5afd151a8eced29954738c38db26";
//		String accessToken = "e99a044da99ed02c59e0a85ce0269827d08890b1b5f590986163f3e0ce670bef";
//		String boardName = "Test";
//		
//		Response myResponse = httpRequest
//				.post(RestAssured.baseURI + "?name=" + boardName + "&key=" + key + "&token=" + accessToken);
//		
//		System.out.println(myResponse.then().log().all());
//
//		Assert.assertEquals(myResponse.getStatusCode(), 200);

		
		//Java format
		  RestAssured.baseURI = "https://api.trello.com/1/boards/";
	        
	      RequestSpecification httpRequest = RestAssured.given();
	        
		
		JSONObject payload = new JSONObject();
		//payload or request body
		payload.put("name",  "Finally"); //new name
		payload.put("key", "edaa5afd151a8eced29954738c38db26"); //your key
		payload.put("token", "e99a044da99ed02c59e0a85ce0269827d08890b1b5f590986163f3e0ce670bef"); //your token
        
        
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(payload.toJSONString());  
        
        Response myResponse = httpRequest.request(Method.POST);
        System.out.println(myResponse.then().log().all());
        
        int statusCode = myResponse.getStatusCode();
        Assert.assertEquals(statusCode, 200);

	}

}
