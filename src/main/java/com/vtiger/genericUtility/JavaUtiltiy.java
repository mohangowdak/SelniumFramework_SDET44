package com.vtiger.genericUtility;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * This class contains java reusable methods
 * @author MOHAN GOWDA
 *
 */
public class JavaUtiltiy {

	/**
	 * This method is used for convert to string to long datatype
	 * @param s
	 * @return
	 */
	public Object stringToAnyDataType(String s, String strategy) {
		Object convertedData = null;
		if(strategy.equals("int")) {
			convertedData=Integer.parseInt(s);
		}
		else if(strategy.equals("long")) {
			convertedData= Long.parseLong(s);
		}
		return convertedData;
	}

	/**
	 * This method is used to generate random Number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		int randomNumber = new Random().nextInt(limit);
		return randomNumber;
	}

	/**
	 * This method is used to verify the actual result and expected result using if else block
	 * @param actual
	 * @param expected
	 * @param printStatement
	 */
	public void verifyUsingIF_Else(String actual, String expected, String printStatement) {
		if(actual.equals(expected)) {
			System.out.println("TC Pass =====> "+printStatement);
		}
		else {
			System.out.println("TC Fail");
		}
	}


	/**
	 * This method is used to split the string based on strategy
	 * @param s
	 * @param strategy
	 * @return
	 */
	public String[] splitString(String s, String strategy) {
		return s.split(strategy);
	}

	/**
	 * This method is used to get the month in MM Format
	 * @param s
	 * @return
	 */
	public int getMonthInMMFormat(String s) {		
		return DateTimeFormatter.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(s)
				.get(ChronoField.MONTH_OF_YEAR);
	}

	/**
	 * This method is used fetch system date and time in dd_MM_YYYY_HH_mm_sss format
	 * @return
	 */
	public String getDateTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_HH_mm_sss");
		String d = sdf.format(date);
		return d;
	}


}
