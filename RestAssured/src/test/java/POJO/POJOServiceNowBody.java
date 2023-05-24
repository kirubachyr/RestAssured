package POJO;

public class POJOServiceNowBody 
{
	private String short_description;
	private String state;
	
	
	public POJOServiceNowBody(String short_description, String state)
	{
		this.short_description = short_description;
		this.state = state;
		
	}
	
	public String getShort_description()
	{
		return short_description;
	}

	
	/*public void setShort_description(String short_description)
	{
		this.short_description = short_description;
		
	}*/
	
	public String getState()
	{
		return state;
	}

	
	/*public void setState(String state)
	{
		this.state = state;
		
	}*/
}
