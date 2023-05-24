package APIChaining;

import org.testng.annotations.BeforeClass;

import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseReqAndResSpec {
	String uri="https://dev158601.service-now.com";
	String UName ="admin";
	String Pwd ="lII2W0Qr+z^r";
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	static String sys_id = "";	//should be static because , all the global variable reinitialised as null whenever a call is made to this clss
	
	@BeforeClass
	public void reqAndResSpec()
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

}
