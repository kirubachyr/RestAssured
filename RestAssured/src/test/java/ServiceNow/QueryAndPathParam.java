package ServiceNow;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class QueryAndPathParam 
{

	String uri="https://dev158601.service-now.com";
	String UName ="admin";
	String Pwd ="lII2W0Qr+z^r";
	
	
	@Test(enabled = false)
	public void QueryAndPathParam()
	{
		Response response =given()
				.auth()
				.basic(UName,Pwd)
				.param("sysparm_fields", "number,sys_id,short_description")	//older way - for query param and path param (both), return the response with 3 fields alone		
				.baseUri(uri)
				.when()
				.get("/api/now/table/incident");	
		
		System.out.println("Response is : "+response.asPrettyString());
	}
	
	@Test (enabled = false)
	public void QueryParam()
	{
		Response response =given()
				.auth()
				.basic(UName,Pwd)
				.queryParam("sysparm_fields", "number,sys_id,short_description") //query param will get appended with the base uri	
				.baseUri(uri)
				.when()
				.get("/api/now/table/incident");	
		System.out.println("Response is : "+response.asPrettyString());
	}
	
	@Test (enabled = true)
	public void getAllincidentUsingQueryAndPathParam()
	{
		Response response =given()
				.auth()
				.basic(UName,Pwd)
				.log().all()
				.queryParam("sysparm_fields", "number,sys_id,short_description")			
				.pathParam("tableName","incident")
				.baseUri(uri)
				.when()
				.get("/api/now/table/{tableName}");	//incident will coming from path param
		System.out.println("Response is : "+response.asPrettyString());
	}
	
	
	
		
}
