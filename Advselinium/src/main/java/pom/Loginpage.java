package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	
	//create constructor
		//intilization
		public  Loginpage(WebDriver driver)
		{
			PageFactory.initElements( driver,this);
			//pagefactory----->class
			//initElements----->static method
		}
		//Declaration
		@FindBy(name="user_name")
	private	WebElement UserTextField;
		
		@FindBy(name="user_password")
		private WebElement PassWordTextField;
		
		@FindBy(id="submitButton")
		private WebElement LoginButtonTextField;
		
		//method methods

		public WebElement getUserTextField() {
			return UserTextField;
		}

		public WebElement getPassWordTextField() {
			return PassWordTextField;
		}

		public WebElement getLoginButtonTextField() {
			return LoginButtonTextField;
		}
		
		//Bussiness Logic
		/**
		 * create method
		 * @param username
		 * @param password
		 */
		public void loginToApp(String username ,String password)
		{
			 UserTextField.sendKeys(username);
			 PassWordTextField.sendKeys(password);
			// LoginButtonTextField.click();
				
	

}
}
