package MockServer;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class  Mock_Server_Headers {
	
	String uri = "https://c559dba9-7674-417f-ab73-4db80b3b9995.mock.pstmn.io";
	
	
	@Test(enabled = false)
	public void HeaderBasedResult()
	{
		given()
		.header("x-mock-match-request-headers","header")
		.header("header","value 1")		//if we change the header value as value 2 , will get response as value 2
		.baseUri(uri)
		.log().all()
		.when()
		.get("/header")
		.then()
		.log().all()
		;
		
	}
	
	@Test
	public void PassingHeaderClass()
	{
		/*
		Header header1 = new Header("x-mock-match-request-headers","header");	//older way
		Header header2 = new Header("header","value 1");
		Headers header = new Headers(header1,header2);
		*/
		Map<String,String> header = new HashMap<>();
		header.put("x-mock-match-request-headers","header");
		header.put("header","value 1");
		given()
		//.headers(header)
		.headers(header)
		.baseUri(uri)
		.log().all()
		.when()
		.get("/header")
		.then()
		.log().all()
		;
		
	}
	

	@Test(enabled = false)
	public void ValidateResponseHeader()
	{
		Map<String,String> header = new HashMap<>();
		header.put("x-mock-match-request-headers","header");
		header.put("header","value 1");
		given()
		.headers(header)
		.baseUri(uri)
		.log().all()
		.when()
		.get("/header")
		.then()
		.log().all()
		.assertThat()
		.and()
		.header("Response-Header", "Value 2")
		.header("content-Type", "application/json; charset=UTF-8")
		;
		
	}
	@Test
	public void ValidateResponseHeaderAsMapObject()
	{
		Map<String,String> reqHeader = new HashMap<>();
		reqHeader.put("x-mock-match-request-headers","header");
		reqHeader.put("header","value 1");
		
		Map<String,String> resHeader = new HashMap<>();
		resHeader.put("x-mock-match-request-headers","header");
		resHeader.put("header","value 1");
		given()
		.headers(reqHeader)
		.baseUri(uri)
		.log().all()
		.when()
		.get("/header")
		.then()
		.log().all()
		.assertThat()
		.and()
		.headers(resHeader);
		
	}

}
