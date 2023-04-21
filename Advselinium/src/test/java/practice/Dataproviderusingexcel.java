package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericutility.Excel_utility;

public class Dataproviderusingexcel
{
	@Test(dataProvider="getdata")
			public void readData(String from,String to)
			{
		         System.out.println(from+"------"+to);
			}
@DataProvider

	public Object[][] getdata()throws Throwable
	{
	
		Excel_utility elib=new Excel_utility();  
		Object[][] value=elib.readmultipledata("dataprovider");
		return value;
	}

			
}

