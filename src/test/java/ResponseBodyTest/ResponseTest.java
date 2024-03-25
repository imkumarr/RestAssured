package ResponseBodyTest;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class ResponseTest {

	@Test(priority=1)
	void testJSONResponse() {
//		given()
//			.contentType("ContentType/JSON")
//		
//		.when()
//			.get("http://localhost:3000/book")
//		
//		.then()
//			.statusCode(200)
//			.header("Content-Type", "application/json")
//			.body("book[3].title", equalTo("The Lord of the Rings"));
//			.log().all();
		
		
		Response res=given()
				.contentType("Contennt/JSON")
				
		.when()
			.get("http://localhost:3000/book");
			
//		Assert.assertEquals(res.getStatusCode(), 200);
//		Assert.assertEquals(res.header("Content-Type"), "application/json");
//		
//		String bookname=res.jsonPath().get("book[3].title").toString();
//		Assert.assertEquals(bookname, "The Lord of the Rings");
		
		
		 
		
	}
}
