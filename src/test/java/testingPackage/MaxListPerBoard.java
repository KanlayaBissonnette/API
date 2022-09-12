package testingPackage;

import org.json.simple.JSONObject;

import com.demoqa.Utility.BaseClass;
import com.demoqa.Utility.CommonMethods;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MaxListPerBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int i = 0;
	        int statusCode=0;
	        
	        try {
	        do {

	            RestAssured.baseURI = BaseClass.getProperty("APICreateList");
	            RequestSpecification httpRequest = RestAssured.given();
	            
	            String devKey = BaseClass.getProperty("key");
	            String accessToken = BaseClass.getProperty("token");
	            
	            JSONObject payload = new JSONObject();
	            
	            payload.put("name", CommonMethods.randomsString(3) + " List");
	            payload.put("idBoard", "623290da1a488915081229ad");
	            payload.put("key", devKey);
	            payload.put("token", accessToken);

	            httpRequest.header("Content-Type", "application/json");
	            httpRequest.body(payload.toJSONString());

	            Response myResponse = httpRequest.request(Method.POST);
	            myResponse.then().log().all();

	            i = i + 1;
	            System.out.println("==============================================>>>>>>>>>> " + i);

	            
	            statusCode = myResponse.statusCode();
	            
	        } while (statusCode==200);
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		
		

	}

}
