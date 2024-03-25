package postman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import POJO.Pojo_PostRequest;


public class DiffWaysToCreatePostRequestBody {
	
	int id;
	
//	@Test(priority=1)
	void testPostusingHashMap() {
		
		HashMap data=new HashMap();
		data.put("name", "Scott");
		data.put("location", "India");
		data.put("phone", "123456");
		
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/students")
			
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location", equalTo("India"))
			.body("phone", equalTo("123456"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", "application/json")
			.log().all();
			
	}
	
//	@Test(priority=2)
	void testDelete()
	{
		given()
	
		
		.when()
			.delete("http://localhost:3000/students/c4f5")
			
			
		.then()
			.statusCode(200);
	}
	
	
//	@Test(priority=1)
	void testPostusingJsonLibrary() {
		
		JSONObject data=new JSONObject();
		data.put("name", "Scott");
		data.put("location", "India");
		data.put("phone", "123456");
		
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/students")
			
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location", equalTo("India"))
			.body("phone", equalTo("123456"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", "application/json")
			.log().all();
			
	}
	
//	@Test(priority=2)
	void testDelete1()
	{
		given()
	
		
		.when()
			.delete("http://localhost:3000/students/d613")
			
			
		.then()
			.statusCode(200);
	}
	
//	@Test(priority=1)
	void testPostusingPOJO() {
		
		Pojo_PostRequest  data=new Pojo_PostRequest();
		data.setName("Scott");
		data.setLocation("India");
		data.setPhone("123456");
		
		String courseArr[]= {"C","C++"};
		data.setCourses( courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/students")
			
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location", equalTo("India"))
			.body("phone", equalTo("123456"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", "application/json")
			.log().all();
			
	}
	
//	@Test(priority=2)
	void testDelete2()
	{
		given()
	
		
		.when()
			.delete("http://localhost:3000/students/207e")
			
			
		.then()
			.statusCode(200);
	}
	
	
	@Test(priority=1)
	void testPostusingExternalJsonFile() throws FileNotFoundException {
		

		File f=new File(".\\body.json");
		
		FileReader fr=new FileReader(f);
		
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject data=new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("http://localhost:3000/students")
			
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location", equalTo("India"))
			.body("phone", equalTo("123456"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", "application/json")
			.log().all();
			
	}
	
	@Test(priority=2)
	void testDelete3()
	{
		given()
	
		
		.when()
			.delete("http://localhost:3000/students/207e")
			
			
		.then()
			.statusCode(200);
	}




}
