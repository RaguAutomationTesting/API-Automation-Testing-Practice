package TestSample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class JsonLibrary {
	
	
	
	@Test (priority =1)
	void testPostUsingHashMap() {
		
		
		JSONObject data = new JSONObject();
		
		data.put("name", "Scott");
		data.put("sex", "Male");
		data.put("age","23");
		
		 
		
		
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.put("http://localhost:3000/StudentDetails")
		.then()
			.statusCode(200)
			.body("name",equalTo("Scott"))
			.body("sex",equalTo("Male"))
			.log().all();
		
	}
	
	@Test(priority =2)
	void testDeleteUser() {
		
		given()
			.when()
				.delete("http://localhost:3000/StudentDetails/")
		.then()
		// changed by subb1 on 17-05-2025
		//Changed by SubB1
		.statusCode(200);
		
		
	}


}
