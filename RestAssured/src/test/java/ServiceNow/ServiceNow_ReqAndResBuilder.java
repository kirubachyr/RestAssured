package ServiceNow;


import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.basic.BasicArrowButton;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.internal.http.HTTPBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ServiceNow_ReqAndResBuilder
{
	String uri="https://dev158601.service-now.com";
	String UName ="admin";
	String Pwd ="lII2W0Qr+z^r";
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void ReqAndResSpec()
	{
		
		requestSpecification = given()
				.auth().basic(UName, Pwd)
				.contentType(ContentType.JSON)	//If we are using Post request , providing Content type is mandatory in Rest assured
				.baseUri(uri)
				.log().all(); 		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		
		/*requestSpecBuilder.setAuth(basic(UName,Pwd))
		.setContentType(ContentType.JSON)
		.setBaseUri(uri)
		.log(LogDetail.ALL);*/
		
		 
		requestSpecification = requestSpecBuilder.build();
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();// has meaningful methods
		
		responseSpecification = responseSpecBuilder.expectStatusCode(201)
		.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL).build();
		
	}
	
	@Test (enabled= false)
	public void createNewIncidentWithoutBody()
	{
		given(requestSpecification)
		.when()
		.post("/api/now/table/incident")	//post request to create a incident
		.then()
		.spec(responseSpecification);
	}
	
	@Test (enabled =false)
	public void createNewIncidentWithBodyAsString()
	{
		String Payload = "{\n"
				+ "  \n"
				+ "    \"state\": \"1\",\n"
				+ "    \"short_description\": \"Incident Created from Rest Assured Library\"\n"
				+ "\n"
				+ "}";
		given(requestSpecification)
		.body(Payload)
		.when()
		.post("/api/now/table/incident")	//post request to create a incident
		.then()
		.spec(responseSpecification);
	}

	@Test (enabled = false)
	public void createNewIncidentWithBodyAsFile()
	{
		File ofile = new File("./src/test/resources/ServiceNowBody.json");
		given(requestSpecification)
		.body(ofile)
		.when()
		.post("/api/now/table/incident")	//post request to create a incident
		.then()
		.spec(responseSpecification);
	}
	
	@Test (enabled = false)
	public void createNewIncodentWithBodyAsFileWithValidation()
	{
		File ofile = new File("./src/test/resources/ServiceNowBody.json");
		given(requestSpecification)
		.body(ofile)
		.when()
		.post("/api/now/table/incident")	//post request to create a incident
		.then()
		.spec(responseSpecification)
		.assertThat()
		.body("result.short_decription",equalTo("Incident Created using Rest Assured from external file"),"result.number",matchesPattern("[A-Z0-9]{10}")); //Regex {10} - expecting total character as 10 with A-Z and 0-9 
		
	}
	
	
	@Test (enabled = false)
	public void createNewIncidentWithBodyAsMapObject()
	{
		Map<String,String> payload = new HashMap<>();
		payload.put("state","1");
		payload.put("short_description","Incident Created using Rest Assured Library from Map object");
		
		given(requestSpecification)
		.body(payload)	//Serialization - Converting from Java object to JSON object , Deserialization- Converting from JSON object to Java object. (use some jar file Ex.FasterXML jackson databind)
		.when()
		.post("/api/now/table/incident")	//post request to create a incident
		.then()
		.spec(responseSpecification)
		.assertThat()
		.body("result.short_description",equalTo("Incident Created using Rest Assured Library from Map object"),"result.number",
				matchesPattern("[A-Z0-9]{10}")); //Regex {10} - expecting total character as 10 with A-Z and 0-9 
		
	}
	
	
	@DataProvider (name = "body")
	public String[] multipleData()
	{
		String[] data = {"ServiceNowBodyDP1","ServiceNowBodyDP2"};
		return data;
		
		
	}
	
	
	@Test (enabled = true,dataProvider = "body")
	public void createNewIncidentWithBodyAsMultipleFile(String Filename)
	{
		
		File ofile = new File("./src/test/resources/"+Filename+".json");
		
		given(requestSpecification)
		.body(ofile)	//run two times because data provider has set of values from two different files
		.when()
		.post("/api/now/table/incident")	//post request to create a incident
		.then()
		.spec(responseSpecification);
		 
		
	}
	
}