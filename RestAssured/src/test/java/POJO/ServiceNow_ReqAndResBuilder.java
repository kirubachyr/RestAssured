package POJO;


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
	public void createNewIncidentUsingPOJO()
	{
		POJOServiceNowBody snb= new POJOServiceNowBody("Incident Created throught Rest Assured POJO Class","2");
		given(requestSpecification)
		.body(snb)
		.when()
		.post("/api/now/table/incident")	//post request to create a incident
		.then()
		.spec(responseSpecification)
		.assertThat()
		.body("result.short_description", equalTo(snb.getShort_description()));
	}
	
	
	
}