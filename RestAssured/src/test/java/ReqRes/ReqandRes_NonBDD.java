package ReqRes;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqandRes_NonBDD {
	RequestSpecification request = RestAssured.given();
	
	@BeforeClass
	public void setup()
	{
		RestAssured.baseURI = "https://reqres.in";
		request.baseUri("https://reqres.in");
		
	}
	
	@Test(enabled = false,priority = 1) //dependsOnGroups = {"smoke","sanity"}) //dependsOnMethods = (packagename.ClassName.MethodName) //invocationCount=3)
	public void getAllUsers()
	{
	//RestAssured.baseURI = "https://reqres.in";
	RestAssured.basePath ="/api/users";	
	Response res = RestAssured.get();	//get() - method returns whole response
	
	/*
	RestAssured.baseURI = "https://reqres.in/api/users";
	Response res = RestAssured.get();
	
	OR
	
	Response res = RestAssured.get("https://reqres.in/api/users");	//get with paramater of URL
	*/
	//CTRL + 2 L - shortcut to assign to local variable after RHS
	//CTRL + F11 - Execute default config of program in eclipse
	//CTRL+Shift+o  - Remove unused import statements
	
	AuthenticationScheme basicauthScheme= RestAssured.digest("username", "Password");  // digest method used for basic auth
	System.out.println("Basic auth scheme : "+basicauthScheme.toString());
	
	System.out.println("Response in Single line: "+res.asString()); 	// response in single line
	System.out.println("Response in Json format: "+res.asPrettyString()); 	// Json or object Structure
	System.out.println("Status code : "+res.getStatusCode());	// 200
	System.out.println("Status Line: "+res.getStatusLine()); 	//HTTP/1.1 200 OK
	System.out.println("Session Id: "+res.sessionId());	//
	System.out.println("Content Type: "+res.getContentType());	//application/json; charset=utf-8
	System.out.println("Date of Request :"+res.getHeader("date"));			//Date&time of request
	System.out.println("Response time in MilliSeconds :"+res.getTime());
		
	}
	@Test(enabled = false)	//TestNG default priority is 0
	public void getFirstUsers()
	{
		Response res = RestAssured.get("/api/users/1");
		System.out.println(res.asPrettyString());
	}
	@Test(enabled =false)
	public void addNewUser()
	{
		String jsonString ="{\"name\" : \"Kiru\",\"job\" : \"QA\"}";
		//request.contentType(ContentType.JSON);
		request.basePath("/api/users");
		Response res = RestAssured.get("/api/users");
		System.out.println("List of users before add : "+res.asPrettyString()); //No use of printing this
		
		request.body(jsonString);
		
		Response response = request.post();
		System.out.println("added user :" + response.asPrettyString());  // Not added into existing 
		
		/*ValidatableResponse validatableResponse = response.then();
	    validatableResponse.statusCode(201);*/
		
		
	    System.out.println(response.getStatusCode());
	    System.out.println(response.getTime());
		
	}
	
	@Test
	public void DeleteUser()
	{
		Response response = request.delete("/api/users/1");
		System.out.println("User Deleted :"+response.asPrettyString());	//deleted resource ll be not available to print
		
		System.out.println("Deleted resource status code :"+response.getStatusCode());
	}

}
