package Path_And_Query_Parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
public class PathAndQueryParameters {
	
	@Test
	void testQueryAndPathParameter()
	{
	given()
		.pathParam("mypath", "users")
		.queryParam("page", 2)
		.queryParam("id", 5)
		
	.when()
		.get("https://reqres.in/api/{mypath}")
	
	.then()
		.statusCode(200)
		.log().all();
	}

}
