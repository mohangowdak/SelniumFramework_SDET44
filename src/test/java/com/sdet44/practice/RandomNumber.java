package com.sdet44.practice;

import java.util.Random;

public class RandomNumber {
public static void main(String[] args) {
	Random ran=new Random();
	int randomNumber = ran.nextInt(1000);
	System.out.println(randomNumber);
}
}
