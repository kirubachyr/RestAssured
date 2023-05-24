package ServiceNow;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ServiceNow_Delete {
	String uri="https://dev158601.service-now.com";
	String UName ="admin";
	String Pwd ="lII2W0Qr+z^r";
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	String sys_id= "";
	
	@BeforeClass
	public void ReqAndResSpec()
	{
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		
		requestSpecBuilder.setAuth(new PreemptiveAuthProvider().basic(UName,Pwd))
		.setContentType(ContentType.JSON)
		.setBaseUri(uri)
		.addQueryParam("sysparm_fields", "number,sys_id,short_description")
		.log(LogDetail.ALL);
		
		 
		requestSpecification = requestSpecBuilder.build();
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();// has meaningful methods
		
		responseSpecification = responseSpecBuilder.expectStatusCode(204)
		//.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL).build();
		
	}
	@Test (enabled = true)
	public void extractSysID()
	{
	Response response = given()
		.baseUri(uri)
		.queryParam("sysparm_fields", "number,sys_id,short_description")
		.auth()
		.basic(UName,Pwd)
		.when()
		.get("/api/now/table/incident")
		.then()
		.log()
		.all()
		.extract().response();
	
	JsonPath jsonRes = response.jsonPath();
	List<String> list = jsonRes.getList("result");
	int size = list.size();
	int last_item = list.size()-1;
	sys_id = jsonRes.getString("result["+last_item+"].sys_id");
	System.out.println("SYS_ID is :"+sys_id);
		
	}
	@Test(dependsOnMethods = "extractSysID")	
	public void deleteIncident()
	{

		given(requestSpecification)
		.when()
		.delete("/api/now/table/incident/"+sys_id)	//post request to create a incident
		.then()
		.spec(responseSpecification);
		
	}
}
