package com.learn.java;

public class StringPrograms {

	public static void convertNumToChar(String s)
	{
		for(int i =0; i < s.length(); i++) {
			
			if(Character.isAlphabetic(s.charAt(i))){
				System.out.print(s.charAt(i));
			}else {
				int a = Character.getNumericValue(s.charAt(i));
				for(int j =1; j <a; j++) {
					System.out.print(s.charAt(i-1));
				}
			}
		}

	}

	public static void main(String[] args) {

		String s = "a2b3c4"; //output = aabbbcccc
		
		convertNumToChar(s);
	}

}


