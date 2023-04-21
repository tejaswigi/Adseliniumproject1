package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validationandverificationpage 
{
 
   public Validationandverificationpage(WebDriver driver) 
   
	   {
		   PageFactory.initElements(driver, this);
	   }

@FindBy(xpath="//span[@id='dtlview_Organization Name']")
   private WebElement actualorganisationdata;
   
 //getter method
public WebElement getActualorganisationdata() {
	return actualorganisationdata;
}
 
//business logics
public String organisationvalidation(WebDriver driver,String data)
{
	String actdata=actualorganisationdata.getText();
	if(actdata.contains(data))
	{
		System.out.println("validation pass");
	}
	else
	{
		System.out.println("validation fail");
	}
	return actdata;
}
   
}
