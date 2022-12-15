package com.sdet44.practice;

public class SwitchWord {
	public static void main(String[] args) {

		String s="this is my interView";
		String[] str = s.split(" ");
		String r="";
		for (int i = str.length-1; i >=0 ; i--) {
			String data=str[i];
			for (int j = 0; j <data.length() ; j++) {
				if((int)data.charAt(j)>=65 &&(int)data.charAt(j)<=90) {
					r=r+" ";
					r=r+data.charAt(j);
				}
				else {
					r=r+data.charAt(j);
				}
			}
		}
		System.out.println(r);

	}
}
