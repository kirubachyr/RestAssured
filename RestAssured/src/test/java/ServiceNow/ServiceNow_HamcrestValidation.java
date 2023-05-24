package ServiceNow;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotEqualsDeep;

import java.util.function.Function;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ServiceNow_HamcrestValidation {
	
	/*
	 * Hamcrest is a Assertion Library used for unit testing
	 * Hamcrest can be used as assertion library for testNG
	 * Adv:
	 *  - Assertion method will be in plain English ,which is human readable. EX: isEqual, isNotEqual
	 *  - Descriptive Error message
	 */
	String uri="https://dev158601.service-now.com";
	String UName ="admin";
	String Pwd ="lII2W0Qr+z^r";
	
	@Test (enabled = false)
	public void ValidateFirstIncidentNumberFromExtractedResponse()
	{
		Response response =given()
		.baseUri(uri)
		.auth()
		.basic(UName,Pwd)
		.when()
		.get("/api/now/table/incident")
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();
		
		String incident = response.path("result[0].number");
		assertThat(incident,equalTo("INC0000060"));		// Hamcrest 
			
	}
	
	@Test (enabled =false)
	public void ValidateFirstIncidentNumberusingEqualTo()
	{
		given()
		.baseUri(uri)
		.auth()
		.basic(UName,Pwd)
		.when()
		.get("/api/now/table/incident")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("result[0].number", equalTo("INC0000060"));		
	}
	@Test (enabled = false)
	public void ValidateFirstIncidentNumberusingNumberAssertion()
	{
		given()
		.baseUri(uri)
		.auth()
		.basic(UName,Pwd)
		.when()
		.get("/api/now/table/incident")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("result[0].number", lessThan(1000))	//Number Assertion (Response type is JSON String)
		.and()
		.body("result[0].number",greaterThan(1000))
		.and()
		.body("result[0].number",greaterThanOrEqualTo(1000));
		
	}
	@Test(enabled =false)
	public void ValidateFirstIncidentNumberusingStringAssertion()
	{
		given()
		.baseUri(uri)
		.auth()
		.basic(UName,Pwd)
		.when()
		.get("/api/now/table/incident")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("result[0].number",equalToIgnoringCase("inc0000060"))	
		.and()
		.body("result[0].number",startsWithIgnoringCase("inc"))
		.and()
		.body("result[0].number",containsStringIgnoringCase("c00"))
		.and()
		.body("result[0].number",emptyString());
		
	}
	@Test (enabled = false)
	public void ValidateIncidentNumberusingCollectionAssertion()
	{
		given()
		.baseUri(uri)
		.auth()
		.basic(UName,Pwd)
		.when()
		.get("/api/now/table/incident")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("result.number",hasItems("INC0000021","INC0000024")) //Pass (both Numbers presented in collection)
		.and()
		.body("result.number", contains("INC0000060","INC0009002")); //Fails because it will check the sequence order of values (one after one)
	}
	
	@Test 
	public void ValidateIncidentNumberusingMultipleAssertion()
	{
		given()
		.baseUri(uri)
		.auth()
		.basic(UName,Pwd)
		.when()
		.get("/api/now/table/incident")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("result.number",is(notNullValue()),"result.number",hasSize(68),"result.number",is(not(empty())),"result.number",everyItem(startsWith("INC")),"result[0]",hasKey("number"),"result[0]",hasEntry("subcategory", "email")
		,"result[0]",hasValue("2016-12-14 02:46:44"));
		//"result.number",is(emptyString()),result.number",is(notANumber())
		}
}
