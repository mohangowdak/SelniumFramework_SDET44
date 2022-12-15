package com.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reusable methods for property file
 * @author MOHAN GOWDA
 *
 */
public class FileUtility {
	private FileInputStream fis;
	private Properties property;
	/**
	 * 
	 * @param propertyFilePath
	 * @throws IOException
	 */
	public void openPropertyFile(String propertyFilePath) throws IOException {
		 fis = new FileInputStream(propertyFilePath);
			 property=new Properties();
			property.load(fis);
	}
	
	/**
	 * This method is used to fetch data from property file
	 * @param propertyFilePath
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) {
		String value=property.getProperty(key).trim();
		return value;
	}
	/**
	 * This method is used to close the property file input stream
	 * @throws IOException
	 */
	public void closePropertyFile() throws IOException {
		fis.close();
	}

}
