package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsonLocalAPI {
	//@Test
	public void get()
	{
		baseURI="http://localhost:3000";	
		
		given().get("/users").then().statusCode(200).log().all();
		
		}
	
	//@Test
	public void post()
	{
		JSONObject request=new JSONObject();
		request.put("firstname", "Tho");
		request.put("secondname", "Edison");
		request.put("subjectid", 4);
		
		
		
		baseURI="http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when().put("/users")
		.then().statusCode(200);
		
		
		
		
	}
	
	@Test
	
	public void delete()
	{
		
		baseURI="http://localhost:3000";
		String []usersIds= {"cOiawq9XIuc","HZZjpkSWA9A","d1fvC3qW8k4"};
		 for (String Id : usersIds) {
			 when().delete("users/"+Id).then().statusCode(200);
		}
		
	}

}
