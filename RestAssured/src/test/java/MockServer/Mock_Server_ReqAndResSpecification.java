package MockServer;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Mock_Server_ReqAndResSpecification 
{
String uri = "https://c559dba9-7674-417f-ab73-4db80b3b9995.mock.pstmn.io";
RequestSpecification requestSpecification;
ResponseSpecification responseSpecification;

@BeforeClass		//one time activity which will work for all test method
public void ReqAndResSpec()
{
	requestSpecification  = given().header("x-mock-match-request-headers","header")
			.header("header", "Value 2")
			.baseUri(uri)
			.log().all();
	
	responseSpecification = RestAssured.expect().statusCode(200)
			.and().contentType(ContentType.JSON)
			.logDetail(LogDetail.ALL);
	
}

@Test
public void PassingHeaderMethod()
{
	given(requestSpecification)	//passing all the given details through request specification
	.when()
	.get("/header")
	.then() // we cannot pass direct response spec to then method , so we used to spec method
	.spec(responseSpecification);
}

}
 