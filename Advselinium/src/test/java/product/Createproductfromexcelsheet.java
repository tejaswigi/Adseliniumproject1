package product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createproductfromexcelsheet {

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
			
			driver.findElement(By.xpath("//a[text()='Products']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
			
			Random ran=new Random();
			int rannum=ran.nextInt(1000);
			FileInputStream fes=new FileInputStream("C:\\Users\\suhas\\Desktop\\createproduct.xlsx");
			

			Workbook book=WorkbookFactory.create(fes);
			
			
			Sheet sheet=book.getSheet("product");
			
			
			Row row=sheet.getRow(1);
			
			
	        org.apache.poi.ss.usermodel.Cell cell=row.getCell(1);
			String Exceldata= cell.getStringCellValue()+ rannum;
			driver.findElement(By.name("productname")).sendKeys( Exceldata);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	/*String actdata=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	if(actdata.contains(Exceldata))
	{
		System.out.println("validation pass");
	}
	else
	{
		System.out.println("validation fail");
	}
			
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//driver.findElement(By.linkText("Sign Out")).click();*/
	Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
     // driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
      
	}




	}


