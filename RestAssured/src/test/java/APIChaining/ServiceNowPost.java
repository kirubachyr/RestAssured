package APIChaining;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ServiceNowPost extends BaseReqAndResSpec{
	
	@Test (priority =1, enabled = true)
	public void createNewIncidentWithBodyAsFile()
	{
		File ofile = new File("./src/test/resources/ServiceNowBody.json");
		JsonPath jsonPath = given(requestSpecification)
		.body(ofile)
		.when()
		.post("/api/now/table/incident")	//post request to create a incident
		.then()
		.statusCode(201)
		//.spec(responseSpecification)
		.and()
		.extract()
		.body()
		.jsonPath();
		
		sys_id= jsonPath.getString("result.sys_id");
		System.out.println(sys_id);
		
		
	}

}
