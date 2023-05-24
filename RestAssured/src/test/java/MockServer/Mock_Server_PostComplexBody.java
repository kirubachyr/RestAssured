package MockServer;


import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicArrowButton;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.internal.http.HTTPBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class Mock_Server_PostComplexBody
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

		requestSpecBuilder.setContentType(ContentType.JSON)
		.addHeader("x-mock-match-request-body", "true")	//request body should perfectly match with postman mock server (Including the Key and Value)
		.setBaseUri(uri)
		.log(LogDetail.ALL);

		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();// has meaningful methods

		responseSpecification = responseSpecBuilder.expectStatusCode(201)
				.expectContentType(ContentType.JSON)
				.log(LogDetail.ALL).build();

	}

	@Test (enabled= true)
	public void createNewIncodentWithoutBody()
	{
		Map<String,Object> omap1 = new HashMap<>();
		omap1.put("name", "Kirubakaran");
		omap1.put("age", "30");
		omap1.put("dept", "CS");
		
		Map<String,Object> omap2 = new HashMap<>();
		omap2.put("Name", "KK");
		omap2.put("age", "31");
		omap2.put("dept", "CS");
		
		List<Map<String,Object>> olist = new ArrayList<>();
		olist.add(omap1);
		olist.add(omap2);
			
		given(requestSpecification)
		.when()
		.post("/api/now/table/incident")	//post request to create a incident
		.then()
		.spec(responseSpecification);
	}

	
}