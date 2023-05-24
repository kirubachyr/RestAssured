package APIChaining;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class ServiceNowDelete extends BaseReqAndResSpec{
	
	@Test (priority =3 ,dependsOnMethods = "APIChaining.ServiceNowPut.createNewIncidentWithBodyAsFile")
	public void createNewIncidentWithBodyAsFile()
	{
		File ofile = new File("./src/test/resources/Data/ServiceNowUpdateBody.json");
		given(requestSpecification)
		.body(ofile)
		.when()
		.delete("/api/now/table/incident/"+sys_id)	//post request to create a incident
		.then()
		//.spec(responseSpecification)
		.statusCode(204);
		//.contentType(ContentType.JSON);
		
		
		
	}

}
