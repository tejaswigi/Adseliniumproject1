package practice;

import org.testng.annotations.Test;

public class Sampletestng2 
{
   

	@Test(priority=1)
public void createcontact()
{
	System.out.println("contact created");
}

	@Test(priority=2)
public void modifycontact()
{
	System.out.println("contact modified");
}
	@Test(priority=3)
	public void deletecontact()
	{
		System.out.println("contact deleted");
	}
}

