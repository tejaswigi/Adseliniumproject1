package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderexample 
{
	@Test (dataProvider="dataprovider")
	public void booktickets(String src,String des)
	{
		System.out.println("book tickets from"+src+ "to"+des);
	}
	@DataProvider
	public Object[][] dataprovider()
	{
		Object[][] objarr=new Object[3][2];
		
		objarr[0][0]="banglore";
		objarr[0][1]="Goa";
		
		objarr[1][0]="banglore";
		objarr[1][1]="mysore";
		
		objarr[2][0]="banglore";
		objarr[2][1]="hyd";
		
		return objarr;
		
		
	}

}
