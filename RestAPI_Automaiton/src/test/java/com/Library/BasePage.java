package com.Library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BasePage {
	
	String tokenvalue;

	static Properties prop = new Properties();
	Map<String, Object> jsonMap;

		
	
	@BeforeMethod
	public void beformethod() throws IOException {

		FileInputStream fis = new FileInputStream("src\\test\\resources\\Credentials .properties");
		prop.load(fis);

		Map<String, Object>	jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("username", prop.getProperty("username"));
		jsonMap.put("password", prop.getProperty("password"));

		RestAssured.baseURI = prop.getProperty("endpoint");

	}

}
