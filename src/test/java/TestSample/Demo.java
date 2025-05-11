package TestSample;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class Demo {
	
	int id;
	
	@Test(priority = 1)
	
	public  void test1() {
		
		
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.log().all();
		
		

	}
	
	
	@Test(priority =2)
	void createUser()
	{
		
		HashMap<	String, String > data = new HashMap();
		
		data.put("name", "pavan");
		data.put("job","trainer");
		
		
		given()
			.headers("x-api-key", "reqres-free-v1")
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			//.jsonPath().getInt("id");
		.then()
			.statusCode(201)
		
			.log().all();
		
		
		
	}
	
	@Test(priority = 3, dependsOnMethods= {"createUser"})
	void updateUser()
	{
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		data.put("name", "Raguraman");
		data.put("job", "writer");
		
		
		given()
			.headers("x-api-key", "reqres-free-v1")
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
		
		
		
		
	}

	
	
	@Test(priority=4)
	void deleteUser()
	{
		
		
		
		given()
		.headers("x-api-key", "reqres-free-v1")
			.when()
				.delete("https://reqres.in/api/users/"+id)
			.then()
				.statusCode(204)
				.log().all();
		
		
		
	}
}
