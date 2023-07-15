package com.learn.java;

public class Swapcase {
		    
	    public static String StringChallenge(String str)
	    {
	      char c=0;
	      StringBuffer sb=new StringBuffer();
	     
	     int len = str.length();
	     
	     for(int i=0;i<len;i++) 
	     {
	        
	         if(Character.isUpperCase(str.charAt(i)))
	         {
	             c=Character.toLowerCase(str.charAt(i));
	         }
	       
	         
	         else if(Character.isLowerCase(str.charAt(i)))
	         {
	             c=Character.toUpperCase(str.charAt(i));
	         }
	         else 
	         {
	             c=str.charAt(i);
	         }
	        
	         sb.append(c);
	         
	     }
	        
	       return sb.toString();
	    }
	    
	    
	    public static void main(String args[]) {
	     String s=  Swapcase.StringChallenge("Hello-lol");
	     System.out.println(s);
	      
	    }
}
