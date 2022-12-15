package com.sdet44.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		//Step-1 ==> create object for fileinputsteam -> convert from physical file into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		//Step 2 ==> create object for Properties
		Properties property=new Properties();
		//Step 3 ==> Load all keys
		property.load(fis);
		//step 4 ==> fetch data from property file
		System.out.println(property.getProperty("browser"));
		
		fis.close();
		
	}
}
