package com.learn.java;

public class ObjectClassMethods {
	int age = 12;
	String name ="Kiruba";
	
	
	
	public static void main (String args[])
	{
		
		String s1 = new String ("Kiru");
		String s2 = new String ("Kiru");
		
		String s3 = "Karan";
		String s4 = "Karan";
		
		ObjectClassMethods ocm = new ObjectClassMethods();
		
		System.out.println("Compare the content of two object : "+s1.equals(s2));
		
		System.out.println("Compare the content of two object : "+s3.equals(s4));
		
		System.out.println(" "+s1.equals(s3));
		
		Boolean b = s3==s4? true: false ;
		System.out.println(b);
		
		String age1 = ((Object)(ocm.age)).toString();
		System.out.println(age1.length());
		
		
		
	}

}