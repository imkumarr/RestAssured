package RestAssure;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import  static org.hamcrest.Matchers.equalTo;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SoapXMLRequest {
	
	@Test
	public void validateSoapXML() throws IOException {
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
			.body("//*:AddResult.text()", equalTo("5"));
	}

}
