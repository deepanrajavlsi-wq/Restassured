package demo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.index.qual.LessThan;
import org.testng.Assert;

public class PostApiUsingPojo {

	public static void main(String[] args) {
		
		EmployeePojo employee=new EmployeePojo("morpheus","leader",new String[] {"Java","c"},"XYZ","morpheus@xyz.com");
		
		Response postResponse =
				given()
	            .auth().none()
	            .header("Content-Type", "application/json")
	            .contentType(ContentType.JSON)
	            .when()
	            .body(employee).log().all()
	            .post("https://reqres.in/api/users");
		long responseTimeInSeconds = postResponse.getTimeIn(TimeUnit.SECONDS);
		Assert.assertTrue(responseTimeInSeconds < 5, "Response time exceeded 2 seconds");

	            
	//	String responsebody=postResponse.gethheader();
		
		
		System.out.println("post response is"+postResponse.asString());
		System.out.println("post response status code is"+postResponse.getStatusCode());
		System.err.println(postResponse.getHeader("Date"));
		System.out.println("all the header is"+postResponse.getHeaders());
		System.out.println("post response time is"+postResponse.getTime());
		System.out.println("Cookie time"+postResponse.getCookies());
		if (postResponse.getTime()<500) {
			System.out.println("Response time is less than 2 seconds");
		} else {
			System.out.println("Response time is more than 2 seconds");
			
		}
		
		org.junit.Assert.assertEquals(postResponse.getStatusCode(), 201);
	}
}
