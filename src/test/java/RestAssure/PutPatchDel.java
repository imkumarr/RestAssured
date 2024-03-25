package RestAssure;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;


public class PutPatchDel {
//	@Test
	public void testPut() {
		Map<String,Object> map = new HashMap<String,Object>();
	JSONObject request=new JSONObject(map);
	
	request.put("name", "Kumar R");
	request.put("job", "Tester");
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in/api";
	
	given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
	.when()
		.put("/users/2")
	.then()
		.statusCode(201)
		.log().all();
}
	
//		@Test
		public void testPatch() {
			Map<String,Object> map = new HashMap<String,Object>();
		JSONObject request=new JSONObject(map);
		
		request.put("name", "Kumar R");
		request.put("job", "Tester");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/users/2")
		.then()
			.statusCode(201)
			.log().all();
	}
		@Test
		public void testDelete() {
		
		baseURI = "https://reqres.in/api";
		
		
		when()
			.delete("/users/2")
		.then()
			.statusCode(204)
			.log().all();
	}

}
