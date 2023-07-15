package com.learn.java;

public class Constructor extends SupportConstructor
{

	Constructor()
	{
		//super();	//calls no parameterized parent class constructor
		super("Kiruba"); //calls String parameterized parent class constructor
		
	}

public static void main (String args[])
{
	/*SupportConstructor sc =new SupportConstructor();	//Call no argument constructor
	sc.method();
	
	new SupportConstructor("Kiruba");	 //calls string argument constructor
	*/
	new Constructor();
}
	
	
}

class SupportConstructor
{
	String FirstName = null;
	
	SupportConstructor()
	{
		System.out.println("Customized no argument constructor");
			
	}

	SupportConstructor(String name)
	{
		this.FirstName = name;
		System.out.println("Customized String argument constructor " +FirstName);
	}
	public void method()
	{
		System.out.println("Method");
	}
	
}
