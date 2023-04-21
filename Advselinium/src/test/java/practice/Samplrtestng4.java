package practice;

import org.testng.annotations.Test;

public class Samplrtestng4 
{
	@Test
public void createcontact()
{
	System.out.println("contact created");
}

	@Test(invocationCount=3)
public void modifycontact()
{
	System.out.println("contact modified");
}
	@Test
	public void deletecontact()
	{
		System.out.println("contact deleted");
	}
	
}
