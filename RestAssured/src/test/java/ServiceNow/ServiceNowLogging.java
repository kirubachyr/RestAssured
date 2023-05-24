package ServiceNow;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

public class ServiceNowLogging
{
	/*Two types ofLogging
	Request logging - B4 when()
	Response logging - after when () - when() and then ()
	*/
	String uri="https://dev158601.service-now.com";
	String UName ="admin";
	String Pwd ="lII2W0Qr+z^r";
	
	@Test (enabled =false)
	public void RequestLogging()
	{
		given()
		.auth()
		.basic(UName, Pwd)
		.baseUri(uri)
		.log()
		.all()
		//.log().headers()	- get the header alone from the request
		.when()
		.get("api/now/table/incident")
		.then()
		.assertThat()
		.statusCode(200);
		
	}
	
	@Test  (enabled =false)
	public void ResponseLogging()
	{
		given()
		.auth()
		.basic(UName, Pwd)
		.baseUri(uri)
		.when()
		.get("api/now/table/incident")
		.then()
		//.log().all()			- Get all the log for response 
		.log().body()			//- Get the body alone for response
		.assertThat()			
		.statusCode(200);
		
	}
	
	@Test  (enabled =false)
	public void LoggingifthereisErrorInReponse()
	{
		given()
		//.log().all()	-Request Log
		.auth()
		.basic(UName, Pwd)
		.baseUri(uri)
		.when()
		.get("api/now/table/inciden")	//- Table name is incident
		.then()
		.log().ifError()
		.assertThat()			
		.statusCode(200);
		
	}
	
	@Test  (enabled =false)
	public void LoggingifValidationFailed()
	{
		given()
		//.log().all()	-Request Log
		.auth()
		.basic(UName, Pwd)
		.baseUri(uri)
		.when()
		.get("api/now/table/incident")	
		.then()
		.log().ifValidationFails()
		.assertThat()			
		.statusCode(201); 	//Status code will be 200, So we are seeing the response log
		
	}
	
	@Test  (enabled =false)
	public void LoggingOnlywhenFailureConfig()
	{
		given()
		.auth()
		.basic(UName, Pwd)
		.baseUri(uri)
		.config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))	//used at framework level
		.when()
		.get("api/now/table/incident")	
		.then()
		.log().ifValidationFails()		//no use of it
		.assertThat()			
		.statusCode(201); 	
		
	}
	
	@Test  (enabled =true)
	public void LoggingwithBlacklist()
	{
		given()
		.auth()
		.basic(UName, Pwd)
		.baseUri(uri)
		.config(config.logConfig(LogConfig.logConfig().blacklistHeader("Accept")))	//we won't see Accept type (*/*), It will show blacklisted (Hide the accept type)
		.log().all()
		.when()
		.get("api/now/table/incident")	
		.then()
		.log().all()
		.assertThat()			
		.statusCode(200); 	
		
	}
	

}
