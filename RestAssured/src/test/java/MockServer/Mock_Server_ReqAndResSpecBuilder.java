package MockServer;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Mock_Server_ReqAndResSpecBuilder 
{
	String uri = "https://c559dba9-7674-417f-ab73-4db80b3b9995.mock.pstmn.io";
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void ReqAndResSpec()
	{
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();// has meaningful methods
		
		requestSpecBuilder.setBaseUri(uri);
		requestSpecBuilder.addHeader("x-mock-match-request-headers","header");
		requestSpecBuilder.addHeader("header","Value 1");
		requestSpecBuilder.log(LogDetail.ALL);
		requestSpecification = requestSpecBuilder.build();
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();// has meaningful methods
		
		responseSpecBuilder.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL).build();
		
	}
	
	@Test
	public void PassingHeaderMethod()
	{
		given(requestSpecification)
		.when()
		.get("/header")
		.then()
		.spec(responseSpecification);
	}
	
}