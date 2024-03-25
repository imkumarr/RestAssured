package Path_And_Query_Parameters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;



public class Logging {

	
	@Test(priority=1)
	void testCookies()
	{
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
//			.log().body();
//			.log().cookies();
//			.log().headers();
			.log().all();
	}
	

}
