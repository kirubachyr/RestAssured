package com.learn.java;

public class UseOfFinal extends SecondClass {	//override

	//final 	//if second class method is final , we cannot override the method
	void execute()
	{
		System.out.println("executing");
	}


	public static void main (String args[])
	{
		UseOfFinal uof = new UseOfFinal();
		uof.execute();		//Will execute UseofFinal method because its overrided

		SecondClass sc = new SecondClass();
		sc.execute();


	}


}

class SecondClass
{

	//final 	
	void execute()
	{
		System.out.println("executing second class");
	}


}

