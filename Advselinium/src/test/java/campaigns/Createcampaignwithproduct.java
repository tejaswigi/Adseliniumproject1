package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import genericutility.Java_utility;
import genericutility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Createcampaignwithproduct {


	public static void main(String[] args) throws Throwable 
	{

		 WebDriver driver=WebDriverManager. edgedriver() .create();
			driver.manage().window().maximize();
			
			Webdriver_utility wlib=new Webdriver_utility();
			wlib.implicitywait(driver);
			//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
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
			
			//Random ran=new Random();
			//int rannum=ran.nextInt(1000);
			Java_utility jlib=new Java_utility();
			int rannum=jlib.getRandomNum();
			
FileInputStream fes=new FileInputStream("C:\\Users\\suhas\\Desktop\\createproduct.xlsx");
			

			Workbook book=WorkbookFactory.create(fes);
			
			
			Sheet sheet=book.getSheet("product");
			
			
			Row row=sheet.getRow(1);
			
			
	        Cell cell=row.getCell(1);
			String productdata= cell.getStringCellValue()+ rannum;
			driver.findElement(By.name("productname")).sendKeys( productdata);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		Thread.sleep(2000);
			
			driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Campaigns")).click();
			
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			
		
			
			FileInputStream fes1=new FileInputStream("C:\\Users\\suhas\\Desktop\\createcampaign.xlsx");
			

			Workbook book1=WorkbookFactory.create(fes1);
			
			
			Sheet sheet1=book1.getSheet("campaign");
			
			
			Row row1=sheet1.getRow(0);
			
			
	        Cell cell1=row1.getCell(0);
			String campdata=cell1.getStringCellValue()+rannum;
			driver.findElement(By.name("campaignname")).sendKeys( campdata);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//img[@Alt='Select']")).click();
			
			wlib.switchwindow(driver, "Products&action");
			/*Set<String>allid=driver.getWindowHandles();
			Iterator<String>id=allid.iterator();
			while(id.hasNext())
			{
				String wid=id.next();
				driver.switchTo().window(wid);
				String title=driver.getTitle();
				if(title.contains("Products&action"));
				{
					break;
				}
			}*/
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(productdata);
			driver.findElement(By.xpath("//input[@type='button']")).click();
			
			driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
			
			wlib.switchwindow(driver,"Campaigns&action");
			/*Set<String>allid1=driver.getWindowHandles();
			Iterator<String>id1=allid.iterator();
			while(id1.hasNext())
			{
				String wid=id1.next();
				driver.switchTo().window(wid);
				String title1=driver.getTitle();
				if(title1.contains("Campaigns&action"));
				{
					break;
				}
			}*/
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			String actdata=driver.findElement(By.name("campaignname ")).getText();
			if(actdata.contains(campdata)) 	
			{
				System.out.println("campdata pass");
			}
			else
			{
				System.out.println("campdata fail");
			}
			
			String actdata1=driver.findElement(By.xpath("product_name ")).getText();
			if(actdata1.contains(campdata))
			{
				System.out.println("productdata pass");
			}
			else
			{
				System.out.println("productdata fail");
			}
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			

	}

	}


