package genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Homepage;
import pom.Loginpage;
public class Baseclass 
{
	public WebDriver driver;
	
	@BeforeSuite(groups= {"smoketest","regressiontest","sanitytest"})
	public void BS()
	{
		System.out.println("Database connection");
	}

	@BeforeTest(groups= {"smoketest","regressiontest","sanitytest"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoketest","regressiontest","sanitytest"})
	public void BC(String BROWSER)throws Throwable
	//public void BC()throws Throwable
	{
		//Property_utility plib=new Property_utility();
		//String BROWSER=plib.getkeyvalue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else
		{

			
			driver=new ChromeDriver();
		}
		
	
		System.out.println("Launching browser");
	}
		@BeforeMethod(groups= {"smoketest","regressiontest","sanitytest"})
		public void BM() throws Throwable
		{

			Property_utility plib=new Property_utility();
			String URL=plib.getkeyvalue("url");
			String USERNAME=plib.getkeyvalue("username");
			String PASSWORD=plib.getkeyvalue("password");
			driver.get(URL);
			Loginpage loginpage=new Loginpage(driver);
			loginpage.loginToApp(USERNAME, PASSWORD);
			System.out.println("Login Application");
		}
		@AfterMethod(groups= {"smoketest","regressiontest"})
		public void AM()
		{
			Homepage home=new Homepage(driver);
			home.signoulink(driver);
			System.out.println("Logout Application");
		}
		@AfterClass(groups= {"smoketest","regressiontest"})
		public void AC()
		{
			driver.quit();
			System.out.println("Browser closed");
		}
	
	@AfterTest(groups= {"smoketest","regressiontest"})
	public void AT()
	{
		System.out.println("parallel execution done");
	}
	@AfterSuite(groups= {"smoketest","regressiontest"})
	public void As()
	{
		System.out.println("Data base connection close");
	}
}

