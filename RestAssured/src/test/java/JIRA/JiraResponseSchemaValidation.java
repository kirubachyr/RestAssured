package JIRA;


import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class JiraResponseSchemaValidation
{
	String uri="https://kirubachyr.atlassian.net";
	String UName ="kirubachyr@gmail.com";
	String Pwd ="ATATT3xFfGF0ZNsMPANYU4UecOwVq9rvhFBetNcVoeyzQQ3MljA0-TBt6V5c9sp4Tzr4ROICZbhGoLcJ2NEeawuRFSQJ46bFFqFTbAMnhGOnyX8_J7kIcr8bGJonIPa1saFXvoNAd8ik9fAvTfbYbYeoKcTFfQ_o3UXc_195Q7tKmMnx_Nivi4M=C0BC9DA3";
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void ReqAndResSpec()
	{
		
				
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		
		requestSpecBuilder.setAuth(new PreemptiveAuthProvider().basic(UName,Pwd))
		.setContentType(ContentType.JSON)
		.setBaseUri(uri)
		.log(LogDetail.ALL);
		
		 
		requestSpecification = requestSpecBuilder.build();
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();// has meaningful methods
		
		responseSpecification = responseSpecBuilder.expectStatusCode(201)
		.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL).build();
		
	}
	

	@Test (enabled = true)
	public void createNewIncidentWithBodyAsFile()
	{
		File ofile = new File("./src/test/resources/JiraBody.json");
		File oSchema = new File("./src/test/resources/Data/JiraResponseSchema.json");
		given(requestSpecification)
		.body(ofile)
		.when()
		.post("/rest/api/2/issue")	//post request to create a issue
		.then()
		.spec(responseSpecification)
		.assertThat()
		.body(matchesJsonSchema(oSchema));
	}
	
}