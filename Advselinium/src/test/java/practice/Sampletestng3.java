package practice;

import org.testng.annotations.Test;

public class Sampletestng3
{


	@Test
public void createcontact()
{
int arr[]={1,2,3};
	System.out.println(arr[5]);

	System.out.println("contact created");
}

	@Test(dependsOnMethods="createcontact")
public void modifycontact()
{
	System.out.println("contact modified");
}
	@Test(dependsOnMethods="createcontact")
	public void deletecontact()
	{
		System.out.println("contact deleted");
	}
}
