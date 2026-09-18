package tests;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Getandpost {

	
	
//	@Test
	
	public void testget()
	{
		
		baseURI="https://reqres.in/api";
		given().get("/users?page=2")
		.then().statusCode(200)
        .body("data[4].first_name", equalTo("George"))
        .body("data.first_name", hasItems("George","Rachel"));
		
	}
	
	@Test
	
	public void test_post()
	{
		
		JSONObject request=new JSONObject();
		
		 
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		baseURI="https://reqres.in/api";
		given().header("content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString()).
		when().post("/users").
		then().statusCode(201).log().all();		
	}
}
