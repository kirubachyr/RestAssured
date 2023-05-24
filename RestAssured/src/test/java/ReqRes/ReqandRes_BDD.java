package ReqRes;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ReqandRes_BDD 
{
	String uri = "https://reqres.in";
	@Test
	public void getAllUsers()
	{
	Response response = given()	//Precondition
	.baseUri(uri)
	.when()						// condition
	.get("/api/users");
		
	System.out.println("List of users :" +response.asPrettyString());
	System.out.println("Status code:" + response.getStatusCode());
	
	}
}


