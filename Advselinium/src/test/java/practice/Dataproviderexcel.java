package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericutility.Excel_utility;

public class Dataproviderexcel
{

	@Test(dataProvider="getdata")
			public void readData(String from,String to)
			{
		         System.out.println(from+"------"+to);
			}
@DataProvider

	public Object[][] getdata()throws Throwable
	{
		Object[][] objarr=new Object[3][2];
		Excel_utility elib=new Excel_utility();
		
		 for(int i=0;i<3;i++)
		  {
			  for(int j=0;j<3;j++)
			  {
		objarr[i][j] =elib.getExcelData("Dataprovider",i,j);
			  }
}
			return objarr;
}
}