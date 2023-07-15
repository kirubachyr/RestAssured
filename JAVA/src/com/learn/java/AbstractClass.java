package com.learn.java;

public class AbstractClass extends Vehicle{
	
	String method()
	{
		return "KK";
		
	}
	
	public static void main (String args[])
	{
		Vehicle v = new AbstractClass();	//Create reference variable using Vehicle class for Abstract class
		System.out.println(v.method());
		System.out.println(v.s);
		
		
	}

}


abstract class Vehicle	//object can't be created for abstract class
{
	int s = 100;	//variable shouldn't be abstract
	
	abstract String method();	//method can be abstract and non abstract
	
	String method1()
	{
		return "KKN";
	}
	
}
