package com.Files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.restassured.RestAssured;

public class payLoad {

	static Properties prop = new Properties();

	public static Map<String, Object> credintials() throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Credentials.properties");
		prop.load(fis);

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("username", prop.getProperty("username"));
		map.put("password", prop.getProperty("password"));

		RestAssured.baseURI = prop.getProperty("endpoint");

		return map;

	}

	public static String b(String ISBN, int AISLE) {

		String b = "{\r\n" + "\"name\":\"Learn Appium Automation with Java\"," + "\"" + ISBN + "\":\"bdrr\"," + "\""
				+ AISLE + "\":\"2799\"," + "\"author\":\"John foe\"" + "}";
		return b;

	}

}
