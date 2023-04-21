package practice;

import java.io.FileInputStream;
import java.util.Properties;
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

public class Createcontactwithorganisation 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=WebDriverManager. edgedriver() .create();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Webdriver_utility wlib=new Webdriver_utility();
		wlib.implicitywait(driver);
		
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
		
		
		
		//driver.get("http://localhost:8888/ ");
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//driver.findElement(By.name("accountname")).sendKeys("suhas");
		
		Java_utility jlib=new Java_utility();
		int rannum=jlib.getRandomNum();

		FileInputStream fes=new FileInputStream("C:\\Users\\suhas\\Desktop\\adselinium.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		Sheet sheet=book.getSheet("organisation");
		Row row=sheet.getRow(0);
        Cell cell=row.getCell(0);
		String Exceldata= cell.getStringCellValue()+rannum;

		
		driver.findElement(By.name("accountname")).sendKeys( Exceldata);
		
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
		
		
	Thread.sleep(2000);
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("qspider");
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
Thread.sleep(2000);
		wlib.switchwindow(driver, "Accounts&action");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Exceldata);
		driver.findElement(By.xpath("//input[@type='button']")).click();
		driver.findElement(By.xpath("//a[text()='"+Exceldata+"']")).click();
		

	}

}
