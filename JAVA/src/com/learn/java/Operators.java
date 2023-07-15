package com.learn.java;

public class Operators {
	
	
	public void ternary()
	{
		int s= 100;
		int  t = 50;
		int min = (s<t)?s:t;
		System.out.println(min+" is minimum");
	}
	
	public String Name1()
	{
		String a  = "Kiruba";
		return a;
	}
	public String Name2()
	{
		String a  = "Karan";
		return a;
	}
	
	public void incrementOrDecrement()
	{
		int s= 5;
		s++; 
		System.out.println(s);	//Print as 5 , first it will be 5 , next will be 5+1
		System.out.println(s); //print as 6
		int t = 6;
		++t;
		System.out.println(t);
		
			while(s>=0 && s!=10) {
			++s;
			System.out.println(s);
			
		}	
		
				
	}
	
	
	
	public static void main (String args[])
	{
		Operators s= new Operators();
		s.ternary();
		
		String EqOrNotEq = (s.Name1().equals(s.Name2()))?s.Name1()+"  Name is equal":s.Name1()+" name is not equal";
		System.out.println(EqOrNotEq);
		
		s.incrementOrDecrement();
		
		System.out.println(s instanceof Operators); 	// if s instance is created for operator class then , ll return boolean value -true
		
		
	}
	
	

}
