package com.sdet44.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate_time {
	
public static void main(String[] args) {
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_HH_mm_sss");
	String d = sdf.format(date);
	System.out.println(d);
}

}
