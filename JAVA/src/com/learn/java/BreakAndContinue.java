package com.learn.java;

public class BreakAndContinue {
	
	public void methodForBreak()
	{
		for (int i= 0; i<3;i++)
		{
			System.out.println("Break Method "+ i);
			break;
		}
		
		
		
	}
	public void methodForContinue()
	{
		int j =3;
		
		while(j<=5)
		{
		for (int i= 0; i<3;i++)
		{
			System.out.println("Count of i "+ i);
		}
		j++;
		if(j==5)
		{
			System.out.println("J count is 5 and continuing one more time");	
			continue;
		}
		}
		
	}
	
	
	public static void main(String args[])
	{
		BreakAndContinue bac = new BreakAndContinue();
		bac.methodForBreak();
		bac.methodForContinue();
		
		
		
	}

}
