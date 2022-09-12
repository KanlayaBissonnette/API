package testingPackage;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import com.demoqa.Utility.BaseClass;

public class API_listVerify {

	
	public static void main(String[] args) {
		
		 RestAssured.given().params("key", BaseClass.getProperty("key"))
		 					.param("token", BaseClass.getProperty("token"))
		 					.get(BaseClass.getProperty("baseUrl"))
		 					.then().statusCode(Integer.parseInt(BaseClass.getProperty("apiOkay")))
		 					.body("id[0]", equalTo("62a936e6c171926abd1d4c8b"))
		 					.body("name", hasItems("API"));

		System.out.println("done");
		
		
	}
	
}
