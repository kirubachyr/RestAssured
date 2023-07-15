package com.learn.java;

public class ReturnClass {
	
	public static void main (String args[])
	{
		SuppportClass sc = new SuppportClass();
	String name = sc.method1().method2()
	.name;
	System.out.println(name);
	}

}

class SuppportClass
{
	String name = "Kiruba";
	
	public SuppportClass method1()
	{
		System.out.println("Method 1");
		return this;
	}
	
	public SuppportClass method2()
	{
		System.out.println("Method 2");
		return this;
	}
	
	
}

 


