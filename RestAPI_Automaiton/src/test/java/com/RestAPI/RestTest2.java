package com.RestAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestTest2 {

	String b = "{\r\n" + "\"test\": {\r\n" + "\"description\": \"test sdasmr\",\r\n" + "\"typeId\": 2,\r\n"
			+ "\"typeName\": \"test\",\r\n" + "\"questionTime\": 0,\r\n" + "\"quizTime\": 0,\r\n"
			+ "\"randomizeAnswer\": false,\r\n" + "\"randomizeQuestion\": false,\r\n"
			+ "\"statusName\": \"Published\",\r\n" + "\"statusId\": \"\",\r\n" + "\"maxAttempts\": \"1\",\r\n"
			+ "\"course\": \"StaticTest\",\r\n" + "\"noOfQuestions\": \"5\",\r\n" + "\"score\":10,\r\n"
			+ "\"isDynamic\":\"false\",\r\n" + "\"passingScorePercentage\":\"50\",\r\n" + "\r\n" + "\r\n"
			+ "\"testItems\": [\r\n" + "\r\n" + "{\r\n" + "	\"id\": 1326,\r\n" + "\"weightagePercentage\": 30\r\n"
			+ "},\r\n" + "{\r\n" + "		\"id\": 1327,\r\n" + "\"weightagePercentage\": 20\r\n" + "	\r\n" + "},\r\n"
			+ "{\r\n" + "		\"id\": 1328,\r\n" + "\"weightagePercentage\": 20\r\n" + "},\r\n" + "{\r\n"
			+ "		\"id\": 1329,\r\n" + "\"weightagePercentage\": 20\r\n" + "},\r\n" + "{\r\n" + "	\"id\": 1331,\r\n"
			+ "\"weightagePercentage\": 10\r\n" + "}\r\n" + "\r\n" + "]\r\n" + "}\r\n" + "}";

	@Test(priority = 1)
	public void creation_Test() {

		Response res1 = given().header("x-jwt-token", Login.tokenvalue).queryParam("testObject", "true")
				.contentType(ContentType.JSON).body(b).when().post("/exam/v1/tests").then().assertThat().statusCode(200)
				.extract().response();

		System.out.println(res1.asString());

	}

}
