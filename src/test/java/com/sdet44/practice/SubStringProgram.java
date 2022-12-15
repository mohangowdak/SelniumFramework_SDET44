package com.sdet44.practice;

public class SubStringProgram {
	public static void main(String[] args) {
		String s="Prathith";
		for (int i = 0; i < s.length()-1; i++) {
			System.out.print(s.substring(i, i+2)+" ");
		}
	}

}
