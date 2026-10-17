package tests;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.net.ResponseCache;

@Test
public class DemoclassForGit {
	
	public static void main(String[] args) {
				
		
	}
	@Test
	public void test_post()
	{
		
		baseURI="https://thinking-tester-contact-list.herokuapp.com";
		
	
		
		Response response= given().header("content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(
				"{\"email\":\"deepanrajavlsi@gmail.com\",\"password\":\"Test123!\"}")
		.when().post("/users/login").
		then().statusCode(200).extract().response();
		
		String token=response.jsonPath().get("token");
		System.out.println("token is"+token);
		

}
	
}
