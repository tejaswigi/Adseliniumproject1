package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericutility.Property_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Createproduct {

	public static void main(String[] args) throws Throwable 
	{
		//WebDriver driver;
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		// WebDriver driver=WebDriverManager. edgedriver() .create();
		Property_utility plib=new Property_utility();
		String BROWSER=plib.getkeyvalue("browser");
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			driver=new ChromeDriver();
			
		}
		
		/*WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}*/
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
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
		//	driver.findElement(By.name("user_name")).sendKeys("admin");
		//	driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
			driver.findElement(By.name("productname")).sendKeys("Qspider");
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}

}
