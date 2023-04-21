package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamicxpath 
{

	  public static void main(String[] args) throws Throwable
	  {

			 WebDriver driver=WebDriverManager. edgedriver() .create();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[text()='Departure']"));
		Thread.sleep(2000);
		String month="April 2023";
		String date="7";
		
		driver.findElement(By.xpath("//div[text()='"+month+"']"+
		"/ancestor:://div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		
		//driver.findElement(By.xpath("//div[text()='March 2023']"));
		//driver.findElement(By.cssSelector("[id=\\\"htl_dates\\\"]\")).click();\r\n"
			//	+ "	driver.findElement(By.xpath(\"(//table[@class='ui-datepicker-calendar'])[1]/descendant::a[text()='22']\")).click();\r\n"
			//	+ ""));

}
}