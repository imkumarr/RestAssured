package RestAssure;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidator {
	
	@Test
	public void schemaValidator() throws IOException {
		File file=new File("./SoapRequest/add.xml");
		if(file.exists()) 
			System.out.println(" >>File is Exists");
		
		FileInputStream fileInputStream=new FileInputStream("./SoapRequest/add.xml");
		String reqestBody = IOUtils.toString(fileInputStream,"UTF-8");
		baseURI="https://ecs.syr.edu";
		
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(reqestBody)
		.when()
			.post("/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx")
		.then()
			.statusCode(200)
			.log().all()
		.and()
			.body("//*:AddResult.text()", equalTo("5"))
		.and()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("cal.xsd"));
	}

}
