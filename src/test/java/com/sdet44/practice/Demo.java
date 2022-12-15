package com.sdet44.practice;

import com.vtiger.genericUtility.JavaUtiltiy;

public class Demo {
	public static void main(String[] args) {
		String a="January"; //1==> MM //jan=> MMM //January ==> MMMM
		JavaUtiltiy javaUtiltiy=new JavaUtiltiy();
		System.out.println(javaUtiltiy.getMonthInMMFormat(a));
	}
}