package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createproductanddeleteproduct 
{
public static void main(String[] args) throws Throwable 
{
	WebDriver driver=WebDriverManager. edgedriver() .create();
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
	
	driver.findElement(By.xpath("(//a[.='Products'])[2]")).click();
	//driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='Product Name']/../preceeding-sibling::td[2]"));
	
//	driver.findElement(By.xpath("//input[@value='Delete']")).click();
	//Alert alr=driver.switchTo().alert();
	//alr.accept();
	
 
/*List<WebElement> eles1=driver.findElement(By.xpath("//table[@class='lvt small']//tbody//tr//td[3]"));
 
 boolean flag=false;
 for(WebElement webelement:eles1)
 {
	String all=webelement.getText();
	CharSequence productdata;
	if(all.contains(productdata))
	{
		flag=true;
		break;
		
		
	}
	if(flag)
	{
		System.out.println("not deleted");
	}
	else
	{
		System.out.println("deleted");
	}
 }*/
 
WebElement chck3=driver.findElement(By.xpath("//input[@id='9']"));
System.out.println(chck3.isSelected());
chck3.click();
driver.findElement(By.xpath("//input[@value='Delete']")).click();
Alert alt=driver.switchTo().alert();
alt.accept();



}



	
}

