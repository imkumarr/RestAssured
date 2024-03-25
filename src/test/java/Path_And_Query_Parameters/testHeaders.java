package Path_And_Query_Parameters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class testHeaders {
	
//	@Test(priority=1)
	void testCookies()
	{
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding","gzip")
			.and()
			.header("Server", "gws");
			
	}
	@Test(priority=2)
	void getHeaders()
	{
		Response res = given()
				
				.when()
					.get("https://www.google.com/");
					
				//get single values
//				String headervalues=res.getHeader("Content-Type");
//				System.out.println("The value of content header is :"+headervalues);
		
		Headers headers = res.headers();

	    // Iterate over each header and print its name and value
	    for (Header header : headers) {
	        System.out.println(header.getName() + ":     " + header.getValue());
		}
	}
	


}
