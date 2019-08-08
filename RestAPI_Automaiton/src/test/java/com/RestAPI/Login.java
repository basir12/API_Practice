package com.RestAPI;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.Files.payLoad;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Login {

	static String tokenvalue;

	static Properties prop = new Properties();
	Map<String, Object> jsonMap;

	@BeforeMethod
	public void beformethod() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Credentials.properties");
		prop.load(fis);

		RestAssured.baseURI = prop.getProperty("endpoint");

	}

	@Test(priority = 0)
	public void post() throws IOException {

		Response res = given().contentType(ContentType.JSON).body(payLoad.credintials()).when()
				.post("/account/v1/login").then().assertThat().statusCode(200).extract().response();

		String resToken = res.asString();
		JsonPath tokenpath = new JsonPath(resToken);
		tokenvalue = tokenpath.get("data.token");

		System.out.println(res.asString());

		System.out.println(tokenvalue);

	}

}
