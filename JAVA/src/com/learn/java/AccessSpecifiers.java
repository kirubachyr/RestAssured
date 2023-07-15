package com.learn.java;

public class AccessSpecifiers extends OtherClass{
	
	
	private void privateMethod()	//method can be used on same class
	{
		System.out.println("Private Method");
	}
	public void publicMethod()	//method can be used on same class
	{
		System.out.println("Public Method from access specifier class");
	}
		
	
	public static void main(String args[])
	{
		AccessSpecifiers as =new AccessSpecifiers();
		as.privateMethod();
		OtherClass oc = new OtherClass();
			
		oc.	protectedMethod();
		
	}
	
	

}


class OtherClass
{
	
	public void publicMethod()
	{
		System.out.println("public methodfrom Other class");
		AccessSpecifiers as =new AccessSpecifiers();
		as.publicMethod();
	}
	
	protected void protectedMethod()	//Protected specifier can be accesses in child class using extends
	{
		System.out.println("protected method");
	}
}
