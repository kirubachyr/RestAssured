package com.learn.java;

public class SwapString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = new String ("Karan");		//6
		String s2 = new String ("Kiruba");		//5
		
		
		System.out.println("Before swap: " + s1+"     "+s2 ); 
		
		s1 = s1+s2; // KaranKiruba
		s2 = s1.substring(0,s1.length() - s2.length());
		s1 = s1.substring(s2.length());
		System.out.println(" " +s1+"  "+s2);
	
		

	}

}
