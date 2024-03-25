package RestAssure;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;

public class GetAndPostExample {

//	@Test
	void testGet()
	{
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then()
			.statusCode(200)
			.body("data[4].first_name", equalTo("George"))
			.body("data.first_name", hasItems("George","Byron"))
			.log().all();
	}
	
	@Test
	public void testPost() {
		Map<String,Object> map = new HashMap<String,Object>();
		
//		map.put("name", "Kumar R");
//		map.put("job", "Tester");
//		
//		System.out.println(map);
		
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
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
	}
}
