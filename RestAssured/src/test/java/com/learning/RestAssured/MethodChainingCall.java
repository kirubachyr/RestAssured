package com.learning.RestAssured;
import static com.learning.RestAssured.MethodChainingBase.*; // access all the static methods direct without adding className.methoddName();
//static import
public class MethodChainingCall {


	public static void main(String args[])
	{
		method3()
		.method2()
		.method1(); // Method chaining
		System.out.println("*******************************");
		MethodChainingBase mc = new MethodChainingBase();
		mc.method4();
		MethodChainingBase
		.method3()
		.method2()
		.method1(); // Method chaining


	}

}
