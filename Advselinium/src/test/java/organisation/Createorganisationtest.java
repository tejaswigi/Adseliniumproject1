package organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericutility.Baseclass;
import genericutility.Property_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Createorganisationtest 
{
 
	@Test
	public void Createorganisation() throws Throwable
	{
		Property_utility plib=new Property_utility();
		String Browser=plib.getkeyvalue("browser");
		WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else
		{

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
	}
}
