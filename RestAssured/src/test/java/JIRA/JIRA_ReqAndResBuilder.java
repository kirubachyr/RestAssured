package JIRA;


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
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.internal.http.HTTPBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class JIRA_ReqAndResBuilder
{
	String uri="https://kirubachyr.atlassian.net";
	String UName ="kirubachyr@gmail.com";
	String Pwd ="ATATT3xFfGF0ZNsMPANYU4UecOwVq9rvhFBetNcVoeyzQQ3MljA0-TBt6V5c9sp4Tzr4ROICZbhGoLcJ2NEeawuRFSQJ46bFFqFTbAMnhGOnyX8_J7kIcr8bGJonIPa1saFXvoNAd8ik9fAvTfbYbYeoKcTFfQ_o3UXc_195Q7tKmMnx_Nivi4M=C0BC9DA3";
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void ReqAndResSpec()
	{
		
		/*
		 * server developed with basic auth or preemptive auth , we need to go for it.
		 * 
		 * Basic Auth ---> It will send request without 
		 * authentication and if server requested to send the authentication,
		 * then for the 2 nd call it will basic auth details. (Service now)
		 * 
		 * preemptive ---> It will send authentication to interact with the server. (On step ahead of basic)
		 */
		
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
	
	@Test (enabled =false)
	public void createNewIssueInJiraWithBodyAsString()
	{
		String Payload = "{\n"
				+ "	\"fields\": {\n"
				+ "		\"project\":\n"
				+ "		{\n"
				+ "			\"key\": \"LEAR\",\n"
				+ "			\"name\": \"12345\"\n"
				+ "		},\n"
				+ "		\"summary\": \"JIRA REST Assured Issues \",\n"
				+ "		\"description\": \"Bug Created Using REST ASSURED\" ,\n"
				+ "		\"issuetype\": {\n"
				+ "			\"name\" : \"Bug\"\n"
				+ "		}\n"
				+ "		\n"
				+ "	}\n"
				+ "	\n"
				+ "}";
		given(requestSpecification)
		.body(Payload)
		.when()
		.post("/rest/api/2/issue")	//post request to create a issue
		.then()
		.spec(responseSpecification);
	}

	@Test (enabled = false)
	public void createNewIncidentWithBodyAsFile()
	{
		File ofile = new File("./src/test/resources/JiraBody.json");
		given(requestSpecification)
		.body(ofile)
		.when()
		.post("/rest/api/2/issue")	//post request to create a issue
		.then()
		.spec(responseSpecification);
	}
	
	@Test (enabled = true)
	public void attachFiletoJiraIssue()
	{
		File ofile = new File("./src/test/resources/Data/MyFile.txt");
		given()
		.auth()
		.preemptive()
		.basic(UName, Pwd)
		.baseUri(uri)
		.header("X-Atlassian-Token","no-check")
		.multiPart("file",ofile)
		//.multiPart(ofile)
		.post("/rest/api/2/issue/10020/attachments")	//post request to create a issue
		.then()
		.assertThat()
		.statusCode(200);
	}
	
}