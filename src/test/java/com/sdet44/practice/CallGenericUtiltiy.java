package com.sdet44.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.vtiger.genericUtility.JavaUtiltiy;

public class CallGenericUtiltiy {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUtiltiy javaUtiltiy=new JavaUtiltiy();
		
		int l = (Integer)javaUtiltiy.stringToAnyDataType("124","int");
		
	System.out.println(l);
	}

}
