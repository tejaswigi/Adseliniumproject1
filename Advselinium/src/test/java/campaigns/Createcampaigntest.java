package campaigns;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import genericutility.Baseclass;
import genericutility.Excel_utility;
import genericutility.Java_utility;
import genericutility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Loginpage;

public class Createcampaigntest extends Baseclass
{
@Test(groups="smoketest")
	public  void createcampaigntest() throws Throwable
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
			
		/*	Loginpage loginpage=new Loginpage(driver);
			loginpage.loginToApp(USERNAME, PASSWORD);
			loginpage.getLoginButtonTextField().click();*/
			
			driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Campaigns")).click();
			
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			//Random ran=new Random();
			//int rannum=ran.nextInt(1000);
		
			
			Java_utility jlib=new Java_utility();
			int rannum=jlib.getRandomNum();
			
			/*Excel_utility elib=new Excel_utility();
			String campdata=elib.getExcelDataformatter("campaign", 2, 2)+rannum;*/
			
			
			FileInputStream fes=new FileInputStream("C:\\Users\\suhas\\Desktop\\createcampaign.xlsx");
			Workbook book=WorkbookFactory.create(fes);
			Sheet sheet=book.getSheet("campaign");
			Row row=sheet.getRow(1);
	        Cell cell=row.getCell(1);
			String campdata= cell.getStringCellValue()+ rannum;
			
			driver.findElement(By.name("campaignname")).sendKeys( campdata);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
		Thread.sleep(1000);	
	String actdata=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(actdata.contains(campdata))
	{
		System.out.println("validation pass");
	}
	else
	{
		System.out.println("validation fail");
	}
			Thread.sleep(1000);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	//Thread.sleep(2000);
    //  driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
     // driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
      
	}


}

	




	



