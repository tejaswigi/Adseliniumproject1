package organisation;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import genericutility.Property_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Createorganisation {

	public static <webdriver> void main(String[] args) throws Throwable 
	{
		//String key="webdriver.chrome.driver";
		//String value="./src/main/resources/chromedriver.exe";
		//System.setProperty(key, value);
		 WebDriver driver=WebDriverManager. edgedriver() .create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Property_utility plib=new Property_utility();
		String URL=plib.getkeyvalue("url");
		String USERNAME=plib.getkeyvalue("username");
		String PASSWORD=plib.getkeyvalue("password");
		
		
		/*//FileInputStream fis=new FileInputStream("./src/test/resources/commondata10.properties.txt");
		FileInputStream fis=new FileInputStream("C:\\Users\\suhas\\Desktop\\commondata10.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String url=pro.getProperty("url");
		//String url=pro.getProperty("url1");*/
		driver.get(URL);

				
		//String USERNAME=pro.getProperty("username");
		//String PASSWORD=pro.getProperty("password");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		

		//driver.get("http://localhost:8888/ ");
		//driver.findElement(By.name("user_name")).sendKeys("admin");
		//driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("suhas");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}