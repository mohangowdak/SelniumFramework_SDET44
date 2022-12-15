package com.sdet44.practice;

public class GetLesserNumber {

	public static void main(String[] args) {
		String[] str= {"$ 0,234", "$ 1,334","$ 4,034"};
		int lesserAmount=Integer.MAX_VALUE;
		for (int j = 0; j < str.length; j++) {
			String s=str[j]; 
			String num="";
			for (int i = 0; i < s.length(); i++) {
				if(Character.isDigit(s.charAt(i))) {
					num=num+s.charAt(i);
				}
			}
			if(lesserAmount>Integer.parseInt(num)) {
				lesserAmount=Integer.parseInt(num);
			}
		}
		System.out.println(lesserAmount);
	}

}
