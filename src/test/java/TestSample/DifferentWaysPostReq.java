package TestSample;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DifferentWaysPostReq {
	
	@Test
	void testUsingHashMap() {
		
		
		HashMap data = new HashMap();
		
		data.put("name", "Vijendran");
		data.put("location", "Serukaamboor");
		data.put("phone","142368632");
		
		String[] courseArr = {"C","C++","Java"};
		
		data.put("courses", courseArr);
		
		
		
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("http://localhost:3000/stud_det")
		.then()
			.statusCode(200)
			.body("name",equalTo("Vijendran"))
			.log().all();
		
	}

	

}
