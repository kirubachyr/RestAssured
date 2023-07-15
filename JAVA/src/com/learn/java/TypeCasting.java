
package com.learn.java;

public class TypeCasting {

	int a= 10;
	byte b=20;
	short c = 30;
	long d = 4001;
	float f = 50.0f;
	double g = 30.00;
	String s = "Kiruba";
	char t = 'T';
	boolean u = false;
		
	
	public static void main(String args[])
	{
		TypeCasting tc= new TypeCasting();
		//AutoBoxing - converting from Primitive to wrapper class
		Integer a= tc.a;
		Byte b=tc.b;
		Short c = tc.c;
		Long d = tc.d;
		Float f = tc.f;
		Double g = tc.g;
		Character h = tc.t;
		Boolean  i= tc.u; 
		System.out.println(a+"  "+b+"  "+c+"  "+d+"  "+f+"   "+g+"  "+tc.s+"  "+h+"  "+i);
		
		//AutoUnBoxing - converting from wrapper class to primitive
		int z = a;
		byte y = b;
		short x = c;
		long w = d;
		float v = f;
		double u = g;
		char t = h;
		boolean s = i;
		System.out.println(z+"  "+y+"  "+x+"  "+w+"  "+v+"   "+u+"  "+tc.s+"  "+t+"  "+s);
		
		System.out.println((int)t);		//convert to ascii value of T -84
		//OR
		System.out.println(Integer.valueOf(h));		//convert to ascii value of t -84
				
		char[] name = tc.s.toCharArray();		//String to charArray
		for(char n: name)
		{
			System.out.println(n);
		}
		
		
		System.out.println(((Object)f).getClass());		//get package name .Wrapper class name of class instance variable f
		
		System.out.println(((Object)s).getClass().getSimpleName());		//get the Wrapper class name of a Primitive variable
		
		// byte short int long float double
		//lower type to higher type conversion - implicit conversion - WIDENING
		
		double dd= y;	
		
		
		// double float long int short byte
		//higher type to lower type conversion - explicit conversion - NARROWING
		
		byte bb= (byte)u;
		
		
		System.out.println(Byte.SIZE);	//Default Size in bytes 
		System.out.println(Short.SIZE);
		System.out.println(Integer.SIZE);
		System.out.println(Float.SIZE);
		System.out.println(Long.SIZE);
		System.out.println(Double.SIZE);
		
		
		
		
		
		
		
		
		
		
		
		 
		
		
		
		
	}
}
