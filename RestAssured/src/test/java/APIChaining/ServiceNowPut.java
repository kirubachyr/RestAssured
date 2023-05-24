package APIChaining;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class ServiceNowPut extends BaseReqAndResSpec{
	
	@Test (priority =2, dependsOnMethods = "APIChaining.ServiceNowPost.createNewIncidentWithBodyAsFile")
	public void createNewIncidentWithBodyAsFile()
	{
		File ofile = new File("./src/test/resources/Data/ServiceNowUpdateBody.json");
		given(requestSpecification)
		.body(ofile)
		.when()
		.put("/api/now/table/incident/"+sys_id)	//post request to create a incident
		.then()
		//.spec(responseSpecification)
		.statusCode(200)
		.contentType(ContentType.JSON);
		
		
		
	}

}
