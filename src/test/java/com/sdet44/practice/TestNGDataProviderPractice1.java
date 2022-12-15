package com.sdet44.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderPractice1  {
	
	@Test(dataProvider = "getData")
	public void test3(String cityName, int pincode) {
		System.out.println("City Name ===> "+ cityName + "    Pin Code ===> "+ pincode);
		System.out.println();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] arr=new Object[4][2];
		
		arr[0][0]="Bangalore";
		arr[0][1]=560058;
		
		arr[1][0]="Mandya";
		arr[1][1]=573201;
		
		arr[2][0]="Kodagu";
		arr[2][1]=571232;
		
		arr[3][0]="vizag";
		arr[3][1]=530013;
		
		return arr;
	}

	

}
