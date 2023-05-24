package ServiceNow;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class ServiceNow 
{
	String uri="https://dev158601.service-now.com";
	String UName ="admin";
	String Pwd ="lII2W0Qr+z^r";

	@Test (enabled =false)
	public void ValidateStatusCode()
	{
		/*
		 * Difference B/W BaseURI and BasePATH
		 * BaseURI - Preferred  when we are interacting with external server
		 * BaseURL - Preferred  when we are interacting with internal server
		 */

		given()
		.baseUri(uri)
		.auth()
		.basic(UName,Pwd)
		.when()
		.get("/api/now/table/incident")
		.then()
		.assertThat()
		.statusCode(200);


		//		System.out.println("Status code :"+response.getStatusCode());
		//		Assert.assertEquals(response.getStatusCode(),200);
		//		System.out.println(response.asPrettyString());


	}

	@Test (enabled =false)
	public void ValidateStatusCodeWithLog()
	{

		given()
		.baseUri(uri)
		.auth()
		.basic(UName,Pwd)
		.when()
		.get("/api/now/table/incident")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}
	@Test(enabled = false)
	public void ValidateStatusCodeAndExtractResponse()
	{

		Response response = given()
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

		System.out.println(response.body().asPrettyString());
		System.out.println("Content Type: "+response.getContentType());
		System.out.println("Date ofreponse :"+response.getHeader("Date"));


	}

	@Test (enabled =false)
	public void extractResponseBodyAsJSON()
	{

		Response response = given()
				.baseUri(uri)
				.auth()
				.basic(UName,Pwd)
				.when()
				.get("/api/now/table/incident")
				.then()
				.extract()
				.response();


		JsonPath jsonRes =response.jsonPath();
		System.out.println("First incident Number"+jsonRes.get("result[0].number"));

		System.out.println("*****Alternate Way*******");

		String incident = JsonPath.from(response.asString()).get("result[0].number");
		System.out.println("First Incident number is :" + incident);

		System.out.println("*****Count of Incident*******");

		List<Object> li= jsonRes.getList("result");
		System.out.println("Total number of incident:"+li.size());

		System.out.println("********Get All the Incident*******");

		for (int i=0; i<li.size();i++)
		{
			String number = jsonRes.get("result["+i+"].number");
			System.out.println("Incident Number "+i+" : "+ number);

		}
	}
	
	//Enum - To store the constants, using. operator to get all the constant values
	
	@Test

	public void extractResponseBodyAsXML()
	{

		Response response = given()
				.baseUri(uri)
				.auth()
				.basic(UName,Pwd)
				.accept(ContentType.XML) // Content Type - Enum
				.when()
				.get("/api/now/table/incident")
				.then()
				.log()
				.all()
				.extract()
				.response();
		
		System.out.println("XML Response : "+response.asPrettyString());
		
		System.out.println("Content Type : "+response.getContentType());
		
		XmlPath xmlResponse = response.xmlPath();
		
		System.out.println("First Incident number is : "+xmlResponse.get("response.result[0].number")); // always Response tag is added for xml
		
		System.out.println("******Get all the incident*****");
		
		List<Object> li =xmlResponse.getList("response.result");
		
		int size = li.size();
		
		for(int i=0;i<size;i++)
		{
			System.out.println("Incident "+i+": "+xmlResponse.getString("response.result["+i+"].number"));
		}
		
	}
}


