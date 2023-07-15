package com.learn.java;

public class InterfaceClass implements Unimpl {
	
	public String ss()
	{
		return "s";
	}
	public static void main (String args[])
	{
		System.out.println(s);
		
		
	}
}

interface Unimpl
{
	int s=10;		//Variables are By default public static 
	
	String ss();	
}
