package Path_And_Query_Parameters;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;



public class Cookies {
	
//	@Test(priority=1)
	void testCookies()
	{
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
//			.cookie("ACE","Ae3NU9MvB7d_yKVv39nMszOXtkDBF4mwjc0aykqf1a2skMDFMTQGqB_6MQ")
			.log().all();
	}
	
	@Test(priority=2)
	void getCookiesInfo()
	{
		
		 Response res=given()
				
		.when()
			.get("https://www.google.com/");
		
//		 get single cookies info
//		String cookie_value=res.getCookie("AEC");
//		System.out.println("Value of cookies is =====>"+cookie_value);
		 
		 
//		 get all cookie info
		 Map<String,String> cookies_values=res.getCookies();
//		 System.out.println(cookies_values.keySet());
		 
		 for(String k:cookies_values.keySet())
		 {
			 String cookies_value=res.getCookie(k);
			 System.out.println(k+"    "+cookies_value);
		 }
	}
	
	
	

}
