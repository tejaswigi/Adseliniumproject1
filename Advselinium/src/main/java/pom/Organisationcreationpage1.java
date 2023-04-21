package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organisationcreationpage1 
{
	public Organisationcreationpage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);;
	}
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement organizationCreateImage;
	
	@FindBy(name="accountname") 
	private WebElement organisationNameTextField;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	//gettermethods
	public WebElement getOrganizationCreateImage() {
		return organizationCreateImage;
	}

	public WebElement getOrganisationNameTextField() {
		return organisationNameTextField;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	/**
	 * This method is used for clickon+img
	 */
	
	public void clickorganisationcreateimage()
	{
		organizationCreateImage.click();
		
	}
	/**
	 * This method is used to pass value to organisation textfield
	 */
	public void organisationnamestextfield(String orgname)
	{
		organisationNameTextField.sendKeys(orgname);
	}
	 /**
	  * this method is used to save orgname
	  */
	public void savebutton()
	{
		savebutton.click();
	}
	
	
	

}
