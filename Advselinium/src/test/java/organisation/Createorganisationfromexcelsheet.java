package organisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import genericutility.Excel_utility;
import genericutility.Java_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Createorganisationfromexcelsheet {

	public static void main(String[] args) throws Throwable
	{
		 WebDriver driver=WebDriverManager. edgedriver() .create();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			//FileInputStream fis=new FileInputStream("./src/test/resources/commondata10.properties.txt");
			FileInputStream fis=new FileInputStream("C:\\Users\\suhas\\Desktop\\propertiesfile.properties.txt");
			Properties pro=new Properties();
			pro.load(fis);
			String url=pro.getProperty("url");
			//String url=pro.getProperty("url1");
			driver.get(url);

					
			String USERNAME=pro.getProperty("username");
			String PASSWORD=pro.getProperty("password");
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			
	
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			

			//Random ran=new Random();
			//int rannum=ran.nextInt(1000);
			Java_utility jlib=new Java_utility();
			int rannum=jlib.getRandomNum();
			
			Excel_utility elib=new Excel_utility();
			String exceldata=elib.getExcelData("organisation", 1, 1)+rannum;
			
			//FileInputStream fes=new FilenputStream("C:\\Users\\suhas\\Desktop\\adselinium.xlsx");
			//Workbook book=WorkbookFactory.create(fes);
			//Sheet sheet=book.getSheet("organisation");
		//	Row row=sheet.getRow(0);
	      //  Cell cell=row.getCell(0);
			//String Exceldata= cell.getStringCellValue()+rannum;
			
			driver.findElement(By.name("accountname")).sendKeys( exceldata);
			Thread.sleep(2000);
			driver.findElement(By.name("button")).click();
	String actdata=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	if(actdata.contains(exceldata))
	{
		System.out.println("validation pass");
	}
	else
	{
		System.out.println("validation fail");
	}
			
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	
	}

}
