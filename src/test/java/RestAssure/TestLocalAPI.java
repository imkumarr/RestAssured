package RestAssure;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;

public class TestLocalAPI {
	
	@Test(priority=1)
	public void get() {
		baseURI="http://localhost:3000";
		given()
			.get("/users")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=2)
	public void post() {
		JSONObject request=new JSONObject();
		
		request.put("firestName","jagga");
		request.put("lastName", "K");
		request.put("subject", 1);
		
		baseURI="http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
			
		.when()
			.post("/users")
			
		.then()
			.statusCode(201);

	}
	@Test(priority=3)
	public void put() {
		JSONObject request=new JSONObject();
	
		request.put("firestName","Yogi");
		request.put("lastName", "P");
		request.put("subject", 2);
		
		baseURI="http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
			
		.when()
			.put("/users/0b30")
			
		.then()
			.statusCode(200);

	}
	@Test(priority=4)
	public void patch() {
		JSONObject request=new JSONObject();
		
		
		request.put("lastName", "Venkatesh");
		
		
		baseURI="http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
			
		.when()
			.patch("/users/0b30")
			
		.then()
			.statusCode(200);

	}
	
	@Test(priority=5)
	public void delete() {
		baseURI="http://localhost:3000";
		
		when()
			.delete("/users/0b30")
		.then()
			.statusCode(200);
	}
	

}
