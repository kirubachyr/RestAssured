package com.learn.java;

public class InstanceInitializerBlock 
{
int count;
static String name;

InstanceInitializerBlock()		//Userdefined no parameter constructor 
{
	
	System.out.println("Count is "+count);		//print count is 0, if its not initialized by non static block
	System.out.println("Name is " +name);		//print name is null, if its not initialized by static block
}

// block to asssign value to non static global variables
{
	count =5;
	
}
static		// Static block to asssign value to static global variables
{
	name  ="Kiruba";
}

public static void main(String args[])
{
	new InstanceInitializerBlock();
	
	
	
}
	
}
