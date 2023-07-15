package com.learn.java;

import java.util.HashMap;
import java.util.Map;

public class PojoAliasJavaBean {
	
	public static void main(String args[])
	{
		//Key shouldn't be null for map
		POJO pojo = new POJO();	
		pojo.setValues(1,"KK");			
		pojo.setValues(2,"Kiruba");
		pojo.setValues(3,"Karan");
		pojo.setValues(4,"Kirubakaran");
		pojo.setValues(4,"KKN");	//override the new value to key 4 
		pojo.setValues(5, null);	// one null will be inserted for a key
		pojo.setValues(6, null);
		
		System.out.println("Name at 1st place "+
		
		pojo.getName(1));
		
		pojo.getAllKey();
		
		pojo.getAllValues();
		
		pojo.valuePair();						
		
	}
	
}

class POJO
{
	
	
private	int number;
private String name;

//private ArrayList <String> name  = new ArrayList(); 

private HashMap<Integer,String> map = new HashMap(); //restrict access to assign values from other class (Encapsulation)


	public String getName(int key) {
		return map.get(key);
	}
	
				
	public void setValues(int number, String name) {
		map.put(number, name);
	}
	
	/*public void getAllKey()
	{
		
		for (Integer key: map.keySet())
		{
			System.out.println(key);
		}
			
	}*/
	
	
	public void getAllKey()
	{
		System.out.println("******Get All Keys from Map ******");
		
		for (Map.Entry key: map.entrySet())
		{
			System.out.println(key.getKey());
		}
			
	}
	
	public void getAllValues()
	{
		System.out.println("******Get All Values from Map ******");
		
		for (Map.Entry key: map.entrySet())
		{
			System.out.println(key.getValue());
		}
		
	}
	
	
	
	
	public void valuePair()
	{
		//System.out.println(map.get(1).equals("KK"));	
		
		/*ArrayList<Map<Integer,String>> list = new ArrayList();
		list.add(map); //ArrayList<Map<Integer,String>> list = new ArrayList();
		System.out.println("all the map values are in index 0"+ list.get(0));
		
		System.out.println("******Get All Key & Values from Map ******");*/
		
		
		for (Map.Entry val: map.entrySet())
		{
			//System.out.println(val);
			
			System.out.println("Key is :"+val.getKey()+" and the value is :"+val.getValue());
		}
	}
	
	
	
	
}
