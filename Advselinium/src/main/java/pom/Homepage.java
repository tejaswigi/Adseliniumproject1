package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.Webdriver_utility;

public class Homepage 
{
     public Homepage(WebDriver driver)
     {
    	 PageFactory.initElements( driver,this);
     }
     
     //declaration
     @FindBy(linkText="Products")
     private WebElement productlinktext;
     
     @FindBy(linkText="More")
     private WebElement morelink;
     
     @FindBy(linkText="Campaigns")
     private WebElement campaignslinktext;
     
     @FindBy(linkText="Organizations")
     private WebElement organisationlinktext;
     
     @FindBy(xpath="img[@src='themes/softed/images/user.PNG']")
     private WebElement signoutImg;
     
     @FindBy(linkText="Sign Out")
     private WebElement signoutlinktext;
     
//getter method
     
	public WebElement getProductlinktext() {
		return productlinktext;
	}

	public WebElement getMorelinktext() {
		return morelink;
	}

	public WebElement getCampaignslinktext() {
		return campaignslinktext;
	}

	public WebElement getOrganisationlinktext() {
		return organisationlinktext;
	}

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getSignoutlinktext() {
		return signoutlinktext;
	}
     
     //Business logic for product
	
     public void clickproductlink()
     {
    	 productlinktext.click();
    	 
     }
     
     //Business logic for More
     public void morelink(WebDriver driver)
     {
    	 Webdriver_utility wlib=new Webdriver_utility();
    	 wlib.mouseoveronelement(driver,morelink);
     }
     
     //campaign
     public void campaignlinktext()
     {
    	 campaignslinktext.click();
     }
     //organisation
     public void clickorganisationlinktext()
     {
    	 organisationlinktext.click();
     }
     //signout
     public void signoulink(WebDriver driver)
     {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(signoutImg).perform();
    	 signoutlinktext.click();
    	 
     }
}
