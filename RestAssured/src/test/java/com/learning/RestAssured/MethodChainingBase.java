package com.learning.RestAssured;

public class MethodChainingBase {
	static String name= "Kiru";
	
	public MethodChainingBase method1()
	{
		System.out.println("Call made to static method 1"); 
		return new MethodChainingBase(); //After executing the statements inside method block redirect to default constructor
		
	}
	public MethodChainingBase method2()
	{
		System.out.println("Call made to static method 2");
		return new MethodChainingBase();	//After executing the statements inside method block redirect to default constructor
	}
	public static MethodChainingBase method3()
	{
		System.out.println("Call made to static method 3");
		return new MethodChainingBase();	//After executing the statements inside method block redirect to default constructor
	}
	public MethodChainingBase method4()
	{
		System.out.println("Call made to static method 4");
		//return this.method1(); 			//this - current class object , this cannot be used if method is static instead we can use new operator
		return new MethodChainingBase();	//After executing the statements inside method block redirect to default constructor
	}
	
	}
