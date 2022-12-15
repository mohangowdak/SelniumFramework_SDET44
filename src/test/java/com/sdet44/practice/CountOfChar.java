package com.sdet44.practice;

public class CountOfChar {
	public static void main(String[] args) {
		String s="bbbbaaabbbccaaaddddddbbbbbbb";
		
	for (int j = 0; j < s.length(); j++) {
		int count=1;
		for (int i = j; i < s.length()-1; i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				count++;
				j=i+1;
			}
			else break;
		}
		System.out.println(s.charAt(j)+" ----> "+count);
		
	}
	}
}
