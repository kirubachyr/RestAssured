package com.learn.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class IteratorClass {
	
	static ArrayList list = new ArrayList();
	static HashSet<String> set = new HashSet();
	static HashMap<String,String> map= new HashMap();
	
	
	public static void main (String args[])
	{
		list.add(10);
		list.add("KK");
		
		Iterator itr = list.listIterator();
	//	System.out.println(itr.next()); 	//print first item
		
		while(itr.hasNext())				// print list item one by one
		{
			System.out.println(itr.next());
		}
		itr.remove();
		
		set.add("Kiruba");
		set.add("Karan");
		
		set.remove("Kiruba");
		
		for (String s: set)
		{
			System.out.println(s);
		}
	
		map.put("K","KK");
		map.put("KK","Kiruba");
		map.remove("KK", "Kiruba");

	}

}
